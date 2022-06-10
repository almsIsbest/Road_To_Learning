package future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> future = new FutureTask<>(() -> {

            Thread.sleep(3000);
            return 22;
        });

        new Thread(future).start();
        System.out.println(future.get());
    }
}
