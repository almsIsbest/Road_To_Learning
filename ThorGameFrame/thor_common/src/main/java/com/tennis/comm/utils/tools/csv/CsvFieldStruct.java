package com.tennis.comm.utils.tools.csv;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * @ClassName CsvFieldStruct
 * @Description
 * @Author alms
 * @Data 2022/5/20 17:07
 **/
public class CsvFieldStruct {
    private CsvFieldInfo keyField;
    private CsvFieldInfo idField;
    private Method keyGetMethod;
    private ArrayList<CsvFieldInfo> fieldList = new ArrayList<>();
    private boolean isMap;
    private boolean indexByName = false;

    public CsvFieldStruct(boolean isMap) {
        this.isMap = isMap;
    }

    public void setIndexByName(boolean indexByName) {
        this.indexByName = indexByName;
    }

    public CsvFieldInfo getKeyField() {
        return keyField;
    }

    public void setKeyField(CsvFieldInfo keyField) {
        this.keyField = keyField;
    }

    public CsvFieldInfo getIdField() {
        return idField;
    }

    public void setIdField(CsvFieldInfo idField) {
        this.idField = idField;
    }

    public ArrayList<CsvFieldInfo> getFieldList() {
        return fieldList;
    }

    public void addFieldInfo(CsvFieldInfo info) throws Exception {
        if (isMap) {
            if (info.isKeyField()) {
                if (this.keyField != null) {
                    throw new Exception("declare too many key field,(" + info.getFiledName() + "," + this.keyField.getFiledName() + "),key field just support only one");
                } else {
                    this.keyField = info;
                }
            }
            if (info.getFiledName().toLowerCase().equals("id")) {
                this.idField = info;
            }
        }
        this.fieldList.add(info);
    }

    public void initFieldInfo(Class<?> clazz) throws Exception{
        if(isMap){
            if(this.keyField == null && this.idField == null){
                throw new Exception("Key field not declare");
            }
            if(this.keyField == null){
                this.keyField = this.idField;
            }
            String tmpFieldName = this.keyField.getFiledName();
            String tmpMethodName = "get" + tmpFieldName.substring(0, 1).toUpperCase() + tmpFieldName.substring(1);
            keyGetMethod = clazz.getMethod(tmpMethodName);
            if(keyGetMethod == null){
                throw new Exception("Key field get method not declare,should declare method "+tmpMethodName+"()");
            }
            if(Modifier.isStatic(keyGetMethod.getModifiers())){
                throw new Exception("Key field get method is static");
            }
        }

        //?????????????????????
        for (int i = 0; i < this.fieldList.size(); i++) {
            for (int j = this.fieldList.size() - 1; j > i; j--) {
                var sourceInfo = this.fieldList.get(i);
                var checkInfo = this.fieldList.get(j);
                if (sourceInfo.getFiledName().equalsIgnoreCase(checkInfo.getFiledName())) {
                    throw new Exception("has the same field name (" + sourceInfo.getFiledName() + "," + checkInfo.getFiledName() + ")");
                }
            }
        }

        //??????set??????
        var methods = clazz.getMethods();
        for (var method : methods) {
            //????????????4,????????????set??????
            if (method.getName().length() < 4) {
                continue;
            }
            //??????set?????????????????????set??????
            if (!method.getName().startsWith("set")) {
                continue;
            }
            //set??????????????????????????????
            if (method.getParameterCount() != 1) {
                continue;
            }
            //????????????????????????set??????
            if (Modifier.isStatic(method.getModifiers())) {
                continue;
            }

            //???????????????????????????,???????????????????????????????????????,????????????
            //set,get???????????????????????????
            String tmpFieldName = method.getName().substring(3);
            tmpFieldName = tmpFieldName.substring(0, 1).toLowerCase() + tmpFieldName.substring(1);
            for (var info : this.fieldList) {
                if (tmpFieldName.equals(info.getFiledName().substring(0, 1).toLowerCase() + info.getFiledName().substring(1))) {
                    info.setMethod(method);
                }
            }
        }


        int index = 0;

        for (var info : this.fieldList) {
            if(!indexByName) {
                var annClass = info.getField().getAnnotation(CsvField.class);
                if (annClass != null && annClass.skip() > 0) {
                    index += annClass.skip();
                }
                info.setIndex(index);
                index++;
            }

            if (info.getMethod() == null) {
                throw new Exception(
                        "Field " + info.getFiledName() + " should declare set" + info.getFiledName().substring(0, 1)
                                .toUpperCase() + info.getFiledName().substring(1) + "(" + info.getField()
                                .getGenericType().getTypeName() + ") method");
            }
        }
    }

    public Method getKeyGetMethod() {
        return keyGetMethod;
    }
}
