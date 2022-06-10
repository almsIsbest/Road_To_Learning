package ThreadPool;

import BlockArrayLisy.ThreadA;
import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.*;

public class ClassA {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadFactory threadFactory = new ThreadFactory() {
            @SneakyThrows
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("name");
                return thread;
            }
        };
        RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            }
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(4), new ThreadPoolExecutor.AbortPolicy());
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 3;
            }
        };
        Runnable runnable = new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("start" + System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println("end" + System.currentTimeMillis());
            }
        };
        int iii;
        Future <Integer>future = executor.submit(()-> {
            System.out.println("adsad");
            return 3;

        });
        future.cancel(false);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        Thread.sleep(100);
        System.out.println(executor.getCorePoolSize());
        System.out.println(executor.getPoolSize());
        System.out.println(executor.getQueue().size());

    }

}
