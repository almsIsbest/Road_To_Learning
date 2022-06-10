package JVM;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashIter {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(11,"11");
        hashMap.put(22,"22");
        hashMap.put(33,"33");
        hashMap.put(111,"111");
        for(var entry:hashMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
