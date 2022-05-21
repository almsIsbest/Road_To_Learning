package com.tennis.comm.utils.tools.csv;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface CsvField {
    /**
     * 排序字段,一般按照属性顺序排序,除非约定sort
     * @return
     */
    int sort() default 0;

    /**
     * csv表中的第几个元素,不指定以属性顺序决定
     * @return
     */
    int index() default -1;

    /**
     * 是否忽略该属性的解析
     * 用于自定义的不在配置表中的字段
     * static字段无论如何都不解析
     * @return
     */
    boolean ignore() default false;

    /**
     * 分隔符,用于处理分隔符分隔的字符串
     * @return
     */
    String split() default "";

    /**
     * 用于解析特殊字符串的方法名
     * 方法参数为String
     * @return
     */
    String method() default "";

    /**
     * 是否是key,用于Map类型的解析
     * @return
     */
    boolean isKey() default false;

    /**
     * 跳过的列数
     * @return 跳过多少列
     */
    int skip() default 0;
}
