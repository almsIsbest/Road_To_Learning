package Serialize;

import reflect.Fruit;

import javax.print.attribute.standard.Fidelity;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class GenericClass {
    public static void main(String[] args) {
        ArrayList<Integer>list = new ArrayList<>();
        Fruit fruit = new Fruit(){};
        System.out.println(list.getClass().getGenericSuperclass());
        System.out.println(fruit.getClass());
        System.out.println(fruit.getClass().getGenericSuperclass().getClass().getGenericSuperclass());
    }

}
