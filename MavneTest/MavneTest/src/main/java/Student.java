import com.alibaba.fastjson.JSON;

import java.util.*;

public class Student extends Person {

    private int age;
    private boolean sex;
    private static int test = 3;

    public Student(String name, int age, boolean sex) {
        super(name);
        this.age = age;
        this.sex = sex;
    }

    public Student(String name) {
        super(name);
    }


    public int getAge() {
        return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public boolean isSex() {
        return sex;
    }

    public Student setSex(boolean sex) {
        this.sex = sex;
        return this;
    }

    public static int getTest() {
        return test;
    }

    public static void setTest(int test) {
        Student.test = test;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", sex=" + sex +
                '}';
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("person name"));
        list.add(new Student("person name", 13, true));

        var var1 = list.get(0);
       var var2 =list.get(1);
        System.out.println(var1.getClass());
        System.out.println(var2.getClass());
        System.out.println(Arrays.toString(var2.getClass().getDeclaredMethods()));
        System.out.println(JSON.toJSONString(list));
        System.out.println(var1);
        System.out.println(JSON.toJSONString(var2));
        System.out.println(var2);

//        LinkedList<Integer> linkedList = new LinkedList<>();
//        System.out.println(linkedList.getClass());
//        List<Integer>linkedList1 = new LinkedList<>();
//        System.out.println(linkedList1.getClass());
//        linkedList = (LinkedList<Integer>) linkedList1;
//        linkedList.getFirst();




    }


}

