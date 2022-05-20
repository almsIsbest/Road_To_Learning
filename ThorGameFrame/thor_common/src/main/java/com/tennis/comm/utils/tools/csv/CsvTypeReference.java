package com.tennis.comm.utils.tools.csv;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @ClassName CsvTypeReference
 * @Description
 * @Author alms
 * @Data 2022/5/20 16:27
 **/
public class CsvTypeReference<T> {
    private Type type;

    protected CsvTypeReference(){
        Type superClass = getClass().getGenericSuperclass();

        this.type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
    }

    public Type getType() {
        return type;
    }
}
