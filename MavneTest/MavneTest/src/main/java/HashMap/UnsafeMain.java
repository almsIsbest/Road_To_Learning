package HashMap;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class UnsafeMain {

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "1");

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("1", "2");
        concurrentHashMap.put("2", "23");
        concurrentHashMap.put("1", "222");
        System.out.println(concurrentHashMap.get("1"));
    }
}
