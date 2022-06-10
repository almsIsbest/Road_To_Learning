package map;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        LinkedHashMap<Integer,Integer>hashMap = new LinkedHashMap<>();
        hashMap.put(1,2);
        hashMap.put(123,321);
        hashMap.put(213,1231);
        hashMap.put(32131,123123);
        hashMap.put(12312,23122);
        hashMap.put(2131,21312);
        hashMap.put(23132,12321);
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey());
        }

    }
}
