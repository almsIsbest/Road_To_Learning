package HashMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConHashmap {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer, Integer> hashMap = new ConcurrentHashMap<>();
        ExecutorService service = Executors.newCachedThreadPool();

        service.submit(() -> {
            hashMap.put(1, 2);
        });
        service.submit(() -> {
            hashMap.put(2, 3);
        });
        Thread.sleep(20);
        var setentry = hashMap.entrySet();
        service.shutdown();
        System.out.println(setentry);

        System.out.println(setentry);


    }
}
