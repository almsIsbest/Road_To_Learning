import java.util.Map;
import java.util.Timer;
import java.util.concurrent.*;

public class Another {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long time = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer>future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("before sleep");
                Thread.sleep(3000);
                System.out.println("after sleep");
                return 100;
            }
        });
        System.out.println("before future");
        System.out.println(future.get());
        System.out.println("after future");
        System.out.println(System.currentTimeMillis()-time);
    }
    public static int syn() throws InterruptedException {
        Thread.sleep(3000);
        return 100;

    }

}
