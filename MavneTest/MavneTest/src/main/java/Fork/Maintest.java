package Fork;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Maintest {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    list.add(i);
                }
            }
        };

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10000; i++) {
            service.submit(runnable);
        }
        service.shutdown();
        TimeUnit.SECONDS.sleep(2);
        System.out.println(list);
        System.out.println(list.size());
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(runnable);

    }
}
