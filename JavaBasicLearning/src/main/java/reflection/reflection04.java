package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName reflection04
 * @Description Field
 * @Author alms
 * @Data 2022/3/16 14:46
 **/
public class reflection04 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz=Class.forName("reflection.Student");
        //获取指定字段名称的Field类,注意字段修饰符必须为public而且存在该字段,
        // 否则抛NoSuchFieldException
        Field field =clazz.getField("age");
        System.out.println("field"+field);


        //获取所有修饰符为public的字段,包含父类字段,注意修饰符为public才会获取
        Field fields[] = clazz.getFields();
        for (Field f:fields) {
            System.out.println("f:"+f.getDeclaringClass());
        }


        System.out.println("================getDeclaredFields====================");
        //获取当前类所字段(包含private字段),注意不包含父类的字段
        Field fields2[] = clazz.getDeclaredFields();
        for (Field f:fields2) {
            System.out.println("f2:"+f.getDeclaringClass());
        }
        //获取指定字段名称的Field类,可以是任意修饰符的自动,注意不包含父类的字段
        Field field2 = clazz.getDeclaredField("desc");
        System.out.println("field2:"+field2);

        Student st=(Student) clazz.getDeclaredConstructor().newInstance();
        Field ageField = clazz.getField("age");
        ageField.set(st,18);
        System.out.printf("age ={%d}\n",st.age);
        Field nameField = clazz.getField("name");
        nameField.set(st,"Lily");
        System.out.printf("name ={%s}\n",st.name);

    }
}

class Person{
    public int age;
    public String name;
    //省略set和get方法
}

class Student extends Person{
    public String desc;
    private int score;
    //省略set和get方法
}