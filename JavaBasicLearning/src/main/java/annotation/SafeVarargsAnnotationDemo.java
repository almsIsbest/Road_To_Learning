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
     * �˷���ʵ���ϲ�����ȫ����ʹ�ô�ע�⣬����ʱ��澯
     */
    @SafeVarargs
    static void wrongMethod(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList; // �﷨���󣬵��Ǳ��벻�澯
        String s = stringLists[0].get(0); // ����ʱ�� ClassCastException
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
