package map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Collectors;

public class CollectionTest implements Iterable<Integer>{

    ArrayList <Integer>list = new ArrayList<>();
    @Override
    public Iterator<Integer>iterator (){
        Collections.sort(list);
        final int[] order = {0};
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return order[0] <list.size()-1;
            }

            @Override
            public Integer next() {

                return list.get(order[0]++);
            }
        };
    }

    public void put(int i ){
        list.add(i);
    }



    public static void main(String[] args) {
        CollectionTest list = new CollectionTest();
        list.put(1);
        list.put(3);
        list.put(3123);
        list.put(2131);
        list.put(2132);
        list.put(3213);
        list.put(3213);
        list.put(1321);
        list.put(2312);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}
