package annotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName SafeVarargsAnnotationDemo
 * @Description
 * @Author alms
 * @Data 2022/5/19 14:59
 **/
public class SafeVarargsAnnotationDemo {
    /**
     * 此方法实际上并不安全，不使用此注解，编译时会告警
     */
    @SafeVarargs
    static void wrongMethod(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList; // 语法错误，但是编译不告警
        String s = stringLists[0].get(0); // 运行时报 ClassCastException
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");

        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");

        wrongMethod(list, list2);
    }
}
