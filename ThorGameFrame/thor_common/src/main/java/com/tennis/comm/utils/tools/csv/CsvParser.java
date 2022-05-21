package com.tennis.comm.utils.tools.csv;

import com.csvreader.CsvReader;

import java.io.InputStream;
import java.lang.reflect.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @ClassName CsvParser
 * @Description
 * @Author alms
 * @Data 2022/5/20 16:15
 **/
public class CsvParser {

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> T parseCsv(CsvTypeReference<T> typeReference, InputStream in, int beginIndex) throws Exception{
        if(beginIndex < 0){
            throw new Exception("begin index should >= 0,now is " + beginIndex);
        }

        Type type = typeReference.getType();
        Type rawType = ((ParameterizedType) type).getRawType();
        Type itemType;
        Object result;
        boolean isMap = false;

        if (Collection.class.isAssignableFrom((Class<?>) rawType)) {
            result = createCollection(rawType);
            itemType = ((ParameterizedType) type).getActualTypeArguments()[0];
        } else if (Map.class.isAssignableFrom((Class<?>) rawType)) {
            result = createMap(rawType);
            itemType = ((ParameterizedType) type).getActualTypeArguments()[1];
            isMap = true;
        } else {
            throw new Exception("parser only support Collection or Map Object,now is " + rawType.getTypeName());
        }


        Class<?> clazz = (Class<?>) itemType;
        CsvFieldStruct fieldStruct = createFieldStruct(clazz, isMap);

        CsvReader reader = null;
        try {
            reader = new CsvReader(in, StandardCharsets.UTF_8);
            int row = 0;
            while (reader.readRecord()) {
                row++;
                if (row < beginIndex) {
                    continue;
                }
                Object e = parseCsvElement(reader, clazz, fieldStruct);
                if (!isMap) {
                    ((Collection) result).add(e);
                } else {
                    Method method = fieldStruct.getKeyGetMethod();
                    method.setAccessible(true);
                    ((Map) result).put(method.invoke(e), e);
                }
            }
        } catch (Exception e) {
            throw new Exception("parser error..." + e.toString());
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return (T) result;
    }

    private static Object parseCsvElement(CsvReader reader, Class<?> clazz, CsvFieldStruct fieldStruct) throws Exception {
        Object e = clazz.getDeclaredConstructor().newInstance();
        var fieldList = fieldStruct.getFieldList();
        for (int i = 0; i < fieldList.size(); i++) {
            var element = fieldList.get(i);
            if (element.getIndex() < 0) {
                continue;
            }
            var annotation = element.getFieldAnnotation();
            if (annotation != null && !"".equals(annotation.method())) {
                Method method = e.getClass().getMethod(annotation.method(), String.class);
                method.setAccessible(true);
                method.invoke(e, getValue(reader.get(element.getIndex()), "String"));
            } else if ((annotation != null && !"".equals(annotation.split()))) {
                String value = (String) getValue(reader.get(element.getIndex()), "String");
                if (value == null || value.equals("")) {
                    continue;
                }
                String[] tmp = value.split(annotation.split());
                Method method = element.getMethod();
                method.setAccessible(true);
                if (element.getType().isArray()) {
                    Object arrayObject = Array.newInstance(element.getType().getComponentType(), tmp.length);
                    for (int j = 0; j < tmp.length; j++) {
                        Array.set(arrayObject, j, getValue(tmp[j], element.getType().getComponentType().getName()));
                    }
                    method.invoke(e, arrayObject);
                } else if (Collection.class.isAssignableFrom(element.getType())) {
                    var list = parseObject(element.getFieldType(), tmp);
                    method.invoke(e, list);
                } else {
                    throw new Exception("annotation split should declare Array or Collection Field");
                }
            } else {
                Method method = element.getMethod();
                method.setAccessible(true);
                method.invoke(e, getValue(reader.get(element.getIndex()), element.getTypeName()));
            }
        }
        return e;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Collection parseObject(Type type, String[] tmp) throws Exception {
        Type itemType = ((ParameterizedType) type).getActualTypeArguments()[0];
        Collection list = createCollection(((ParameterizedType) type).getRawType());
        for (String s : tmp) {
            list.add(getValue(s, itemType.getTypeName()));
        }
        return list;
    }

    private static Object getValue(String value, String type) throws Exception {
        switch (type) {
            case "int":
            case "Integer":
            case "java.lang.Integer":
                return Integer.parseInt(value);
            case "long":
            case "Long":
            case "java.lang.Long":
                return Long.parseLong(value);
            case "float":
            case "Float":
            case "java.lang.Float":
                return Float.parseFloat(value);
            case "byte":
            case "Byte":
            case "java.lang.Byte":
                return Byte.parseByte(value);
            case "short":
            case "Short":
            case "java.lang.Short":
                return Short.parseShort(value);
            case "double":
            case "Double":
            case "java.lang.Double":
                return Double.parseDouble(value);
            case "boolean":
            case "Boolean":
            case "java.lang.Boolean":
                return Boolean.parseBoolean(value);
            case "string":
            case "String":
            case "java.lang.String":
                return value;
            case "BigDecimal":
                return new BigDecimal(value);
            default:
                throw new Exception("type not find " + type);
        }
    }

    private static CsvFieldStruct createFieldStruct(Class<?> clazz, boolean isMap) throws Exception {
        CsvFieldStruct struct = new CsvFieldStruct(isMap);
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            var field = fields[i];
            //静态属性不序列化
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            var annClass = field.getAnnotation(CsvField.class);
            if (annClass != null && annClass.ignore()) {
                continue;
            }
            CsvFieldInfo ce = new CsvFieldInfo(field);
            struct.addFieldInfo(ce);
        }
        struct.initFieldInfo(clazz);
        return struct;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static Collection createCollection(Type type) throws Exception {
        Class<?> rawClass = (Class<?>) type;
        Collection list;
        if (rawClass == AbstractCollection.class
                || rawClass == Collection.class) {
            list = new ArrayList();
        } else if (rawClass.isAssignableFrom(HashSet.class)) {
            list = new HashSet();
        } else if (rawClass.isAssignableFrom(LinkedHashSet.class)) {
            list = new LinkedHashSet();
        } else if (rawClass.isAssignableFrom(TreeSet.class)) {
            list = new TreeSet();
        } else if (rawClass.isAssignableFrom(ArrayList.class)) {
            list = new ArrayList();
        } else if (rawClass.isAssignableFrom(EnumSet.class)) {
            Type itemType;
            itemType = Object.class;
            list = EnumSet.noneOf((Class<Enum>) itemType);
        } else if (rawClass.isAssignableFrom(Queue.class)) {
            list = new LinkedList();
        } else {
            try {
                list = (Collection) rawClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new Exception("create instance error, class " + rawClass.getName());
            }
        }
        return list;
    }

    @SuppressWarnings({"rawtypes"})
    public static Map createMap(Type type) throws Exception {
        Class<?> rawClass = (Class<?>) type;
        Map map;
        if (rawClass == AbstractMap.class
                || rawClass == Map.class) {
            map = new HashMap();
        } else if (rawClass == HashMap.class) {
            map = new HashMap();
        } else if (rawClass == Hashtable.class) {
            map = new Hashtable();
        } else if (rawClass == IdentityHashMap.class) {
            map = new IdentityHashMap();
        } else if (rawClass == SortedMap.class || rawClass == TreeMap.class) {
            map = new TreeMap();
        } else if (rawClass == ConcurrentHashMap.class || rawClass == ConcurrentMap.class) {
            map = new ConcurrentHashMap();
        } else if (rawClass == LinkedHashMap.class) {
            map = new LinkedHashMap();
        } else {
            try {
                map = (Map) rawClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new Exception("create instance error, class " + rawClass.getName());
            }
        }
        return map;
    }

}
