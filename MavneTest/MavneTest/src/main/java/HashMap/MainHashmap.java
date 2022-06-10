package HashMap;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainHashmap {

    public static void main(String[] args) throws InterruptedException {
        //ConcurrentHashMap<Integer,String>hashMap = new ConcurrentHashMap<>();
        HashMap<Integer, String> hashMap = new HashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            executorService.execute(() -> {
                hashMap.put(finalI, String.valueOf(finalI));
            });
        }
        executorService.shutdown();
        Thread.sleep(1000);
        System.out.println(hashMap.size());
        System.out.println(hashMap);

        hashMap.forEach((k,v)->{
            hashMap.remove(k);
        });
        System.out.println(hashMap.size());
        System.out.println(hashMap);

    }
}
