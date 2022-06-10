package reflect;

import java.lang.reflect.Method;

public class ForceTransform {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("Apple");
        Object o = clazz.newInstance();
        Method[] methods = o.getClass().getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

    }
}
