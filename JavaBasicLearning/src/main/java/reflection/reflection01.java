package reflection;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName reflection01
 * @Description 反射获取数组
 * @Author alms
 * @Data 2022/3/15 16:33
 **/
public class reflection01 {
    /** 获取Class对象 三种方法 getclass（） 、forname（） 、类.class**/
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        /**第一种方法 forname（） **/
        Class<?> cls=Class.forName("java.lang.String");
        Object array= Array.newInstance(cls,25);
        Array.set(array,0,"hello");
        System.out.println(Array.get(array,0));

        /**第二种方法 class**/
        System.out.println();
        System.out.println("第二中反射获取类信息的方法");
        Class<?> klass=methodClass.class;
        Object ob=klass.getDeclaredConstructor().newInstance();
        Method[] methods=klass.getMethods();
        Method[] declareMethods= klass.getDeclaredMethods();
        Method method=klass.getMethod("add", int.class, int.class);
        System.out.println("getMethods获取的方法：");
        for(Method m:methods)
            System.out.println(m);

        System.out.println("getDeclaredMethods获取的方法：");
        for(Method m:declareMethods)
            System.out.println(m);

        System.out.println("getMethod获取的方法");
        System.out.println(method.invoke(ob,1,2));
    }
}

class methodClass{
    public final int fuck=3;

    public int add(int a, int b){
        return a+b;
    }
    public int sub(int a,int b){
        return a+b;
    }
}