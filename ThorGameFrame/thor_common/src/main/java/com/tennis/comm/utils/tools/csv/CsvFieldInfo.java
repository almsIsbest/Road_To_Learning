package com.tennis.comm.utils.tools.csv;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @ClassName CsvFieldInfo
 * @Description
 * @Author alms
 * @Data 2022/5/20 17:08
 **/
public class CsvFieldInfo {
    private Field field;
    private String filedName;
    private String typeName;
    private Method method;
    private CsvField fieldAnnotation;
    public Type fieldType;
    private Class<?> type;
    private int index = -1;
    private int sort;
    private boolean isKeyField;

    public CsvFieldInfo(Field field,Method method){
        this.field = field;
        this.filedName = field.getName();
        this.fieldAnnotation = field.getAnnotation(CsvField.class);
        this.method = method;
        this.type = field.getType();
        this.typeName = field.getType().getSimpleName();
        if(this.fieldAnnotation != null && this.fieldAnnotation.isKey()){
            isKeyField = true;
        }
    }

    public CsvFieldInfo(Field field){
        this(field,null);
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public String getFiledName() {
        return filedName;
    }

    public void setFiledName(String filedName) {
        this.filedName = filedName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
        if(method != null){
            this.fieldType = method.getGenericParameterTypes()[0];
        }
    }

    public CsvField getFieldAnnotation() {
        return fieldAnnotation;
    }

    public void setFieldAnnotation(CsvField fieldAnnotation) {
        this.fieldAnnotation = fieldAnnotation;
    }

    public Type getFieldType() {
        return fieldType;
    }

    public void setFieldType(Type fieldType) {
        this.fieldType = fieldType;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public boolean isKeyField() {
        return isKeyField;
    }
}
