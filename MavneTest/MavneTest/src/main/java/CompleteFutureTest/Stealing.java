package CompleteFutureTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Stealing {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executor.execute(() -> {

                System.out.println(finalI );

            });
        }
    }
}
