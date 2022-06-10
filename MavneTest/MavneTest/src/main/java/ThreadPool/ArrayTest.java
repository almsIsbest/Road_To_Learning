package ThreadPool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayTest {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        ReentrantLock lock = new ReentrantLock();
        HashSet<String> hashSet = new HashSet<>();
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
        Callable<String> callable = () -> {
            hashSet.add(Thread.currentThread().getName());
            for (int i = 0; i < 10; i++) {
                Thread.sleep(50);
                list.add(i);
            }
            return "done";
        };
        for (int i = 0; i < 1000; i++) {
            completionService.submit(callable);
        }
        for (int i = 0; i < 1000; i++) {
            completionService.take();
        }
        executorService.shutdown();
//        for (int i = 0; i < 1000; i++) {
//            Thread.sleep(10);
//            list.add(i);
//        }
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(list.size());
        System.out.println(hashSet.size());

    }
}
