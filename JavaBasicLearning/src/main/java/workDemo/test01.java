package workDemo;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @ClassName test01
 * @Description TODO
 * @Author alms
 * @Data 2022/3/3 20:23
 **/
public class test01 {
    public static void main(String[] args) {
//        int i;
//        a:
//        for (i = 0; i < 6; i++) {
//            bbb:for (int j = 3; j < 5; j++) {
//                System.out.println("hello word");
//                break ;
//            }
//        }

        String s1 = "abcd";
        String s2 = "abcd";
        System.out.println("s1==s2" + (s1 == s2));

        try {
            String str = "hello";
            //源码中的value数组
            Field filed = String.class.getDeclaredField("value");
            //设置可访问
            filed.setAccessible(true);
            //得到value数组
            var chars = (byte[]) filed.get(str);
            for (byte c : chars) {
                System.out.print((char) c+" ");
            }
            //修改
            chars[0] = 'w';
            System.out.println(str);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
