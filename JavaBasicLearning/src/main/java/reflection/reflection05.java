package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName reflection05
 * @Description TODO
 * @Author alms
 * @Data 2022/3/16 15:16
 **/
public class reflection05 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz=Class.forName("reflection.Circle");

        Method method=clazz.getMethod("draw",int.class,String.class);

        Circle circle=(Circle) clazz.getDeclaredConstructor().newInstance();
        System.out.println("method"+method );

        method.invoke(circle,15,"圈圈");

        //获取所有public的方法:
        Method[] methods =clazz.getMethods();
        for (Method m:methods){
            System.out.println("m::"+m);
        }

        System.out.println("=========================================");

        //获取当前类的方法包含private,该方法无法获取继承自父类的method
        Method method1 = clazz.getDeclaredMethod("drawCircle");
        method1.setAccessible(true);
        System.out.println("私有方法需要设置访问为true"+method1.invoke(circle));

        System.out.println("method1::"+method1);
        //获取当前类的所有方法包含private,该方法无法获取继承自父类的method
        Method[] methods1=clazz.getDeclaredMethods();
        for (Method m:methods1){
            System.out.println("m1::"+m);
        }

    }
}


class Shape {
    public void draw(){
        System.out.println("draw");
    }

    public void draw(int count , String name){
        System.out.println("draw "+ name +",count="+count);
    }

}
class Circle extends Shape{

    private void drawCircle(){
        System.out.println("drawCircle");
    }
    public int getAllCount(){
        return 100;
    }
}
