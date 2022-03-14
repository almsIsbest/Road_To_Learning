package testDemo;

import org.junit.Test;

import java.lang.reflect.Field;


/**
 * @ClassName testDemo.TestDemo1
 * @Description TODO
 * @Author alms
 * @Data 2022/3/9 14:37
 **/
public class TestDemo1 {

    @Test
    public void test01 (){
        String str="hello ,world";
        System.out.println(str);
    }

    /**根据反射来获取String中Char[] value ，并修改value;
     *
     */
    @Test
    public void test02() throws NoSuchFieldException, IllegalAccessException {
        String s="hello world ";
        System.out.println("s= "+s);

        Field valueField = String.class.getDeclaredField("value");//改变value属性的访问权限

        valueField.setAccessible(true);//获取对象上的value属性值

        char[] value = (char[]) valueField.get(s);//改变value所引用的数组中的第6个字符

        value[5]='_';
        System.out.println("s ="+s);

    }

}
