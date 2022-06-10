package map;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class MapTest<k, v> implements Iterable<Map.Entry<k,v>> {

    HashMap<k, v> hashMap = new HashMap<>();

    @Override
    @NotNull

    public Iterator<Map.Entry<k, v>> iterator() {
        ArrayList<Map.Entry<k, v>> list = new ArrayList<>(hashMap.entrySet());
        list.sort((k1, k2) -> {
            return ((Comparable) k1.getKey()).compareTo(k2.getKey());

        });
        return new Iterator<>() {
            int order = 0;


            @Override
            public boolean hasNext() {
                return order < list.size();
            }

            @Override
            public Map.Entry<k, v> next() {
                return list.get(order++);
            }
        };
    }

    public void put(k i, v j) {
        hashMap.put(i, j);
    }

    public static void main(String[] args) {
        MapTest<Integer, Integer> mapTest = new MapTest<>();
        mapTest.put(2, 3);
        mapTest.put(123, 321);
        mapTest.put(321, 321);
        mapTest.put(213, 321);
        mapTest.put(312, 321);
        mapTest.put(132, 321);
        mapTest.put(121, 321);
        TreeMap<Integer,Integer>map = new TreeMap<>();
        for (var iterator = mapTest.iterator(); iterator.hasNext(); ) {
            var entry = iterator.next();
            System.out.println(entry.getKey());

        }
//        Queue<Integer>queue = new ArrayDeque<>();
//        Queue<Integer>queue1 = new LinkedList<>();
//        Hero hero1 = new Hero();
//        Hero hero2 = new Hero();
//        MapTest<Hero,Integer>mapTest = new MapTest<>();
//        mapTest.put(hero1,123);
//        mapTest.put(hero2,2321);
//        for (Map.Entry<Hero, Integer> entry : mapTest) {
//            System.out.println(entry.getKey());
//        }

    }
}

