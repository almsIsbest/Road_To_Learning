package workDemo;

import java.util.*;

/**
 * @ClassName HashMapTest
 * @Description TODO
 * @Author alms
 * @Data 2022/3/7 18:52
 **/
public class HashMapTest {
    public static void main(String[] args) {
//        HashMap<Integer,Generics<Integer>> g=new HashMap<>();
//
//        Hashtable<Integer,Integer> hashtable=new Hashtable<>();
//        hashtable.put(1,1);

        People jack = new People("jack", 13);
        HashMap<People, Integer> hashMap = new HashMap<>();
        System.out.println(jack.hashCode());
        hashMap.put(jack,1);
        System.out.println(hashMap.get(new People("Jack", 12)));
//        System.out.println(hashtable.get(1));
    }
}

class People{
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return this.name.equals(((People)obj).name) && this.age== ((People)obj).age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}