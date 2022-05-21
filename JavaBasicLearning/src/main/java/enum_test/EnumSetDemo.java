package enum_test;

import java.util.EnumSet;

/**
 * @ClassName EnumSetDemo
 * @Description
 * @Author alms
 * @Data 2022/5/20 11:17
 **/
public class EnumSetDemo {
    public static void main(String[] args) {
        System.out.println("EnumSetչʾ");
        EnumSet<ErrorCodeEn> errSet = EnumSet.allOf(ErrorCodeEn.class);
        for (ErrorCodeEn e:
             errSet) {
            System.out.println(e.name() + " : " + e.ordinal());
        }
    }
}
