package reflect;

import com.csvreader.CsvReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class CsvReaderImpl {

    public static HashSet<String> basicType = new HashSet<>();
    public static HashSet<String> collection = new HashSet<>();
    static {

            basicType.add("int");
            basicType.add("long");
            basicType.add("byte");
            basicType.add("boolean");
            basicType.add("float");
            basicType.add("double");
            basicType.add("char");
            basicType.add("short");
            basicType.add("string");

    }


    public static <E> ArrayList<E> parseCsv(Class<E> clazz) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        ArrayList<CsvElement> elements = new ArrayList<>();
        Field[] fields = NormalBean.class.getDeclaredFields();
        NormalBean normalBean = new NormalBean();
        ArrayList<E>list = new ArrayList<>();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            CsvElement element = new CsvElement();
            element.setFiledName(field.getName());
            element.setTypeName(field.getType().getSimpleName());
            if (!basicType.contains(element.getTypeName())) {
                element.setGenericTypeName(field.getGenericType().getTypeName());
                element.setTypeName(field.getType().getSimpleName());
                element.setType(field.getGenericType());

            } else {
                element.setType(field.getType());
            }
            elements.add(element);

        }
        CsvReader reader =  new CsvReader(new FileInputStream("C:\\Users\\Betta\\Desktop\\normalBean.csv"),
                Charset.forName("UTF-8"));
        int row = 0;
        while(reader.readRecord()) {
            row++;
            if (row < 4) {
                continue;
            }

            for(int i = 0 ; i < elements.size();i++){
                var element = elements.get(i);
                String methodStr = "set"+element.getFiledName().substring(0, 1).toUpperCase()+element.getFiledName().substring(1);
                Method method = NormalBean.class.getMethod(methodStr, (Class<?>) element.getType());
                method.setAccessible(true);
                method.invoke(normalBean,getValue(reader.get(i),element.getTypeName()) );
            }

        }
        list.add((E) normalBean);
        return list;
    }

    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        //parseCsv(NormalBean.class);


        ArrayList<Integer>list = new ArrayList<>();
    }
    private static Object getValue(String value, String type) throws ClassNotFoundException {
            if(basicType.contains(type)){
                switch (type){
                    case "int":
                        return Integer.parseInt(value);
                    case "double":
                        return Double.parseDouble(value);
                    case "float":
                        return Float.parseFloat(value);
                    case "string":
                        return value;
                    default:
                        return value;
                }
            }else if (collection.contains(type)){
                switch (type){
                    case "set":
                        return Arrays.stream(value.split("&")).collect(Collectors.toSet());
                    case "list":
                        return Arrays.stream(value.split("&")).collect(Collectors.toList());
                    default:
                        return value;
                }
            }else {
                Class<?> clazz = Class.forName(type);
                Field[]fields = clazz.getDeclaredFields();
            }
        return null;
    }
}
