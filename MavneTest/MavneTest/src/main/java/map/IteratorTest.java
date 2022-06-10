package map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class IteratorTest implements Iterator {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(new Random().nextInt(100));
        }
        System.out.println(list);
        list.sort((i1,i2)->{
            System.out.println(i1);
            System.out.println(i2);
            System.out.println("``````````````````````````````");
            return i1-i2;
        });
        System.out.println(list);
    }
}
