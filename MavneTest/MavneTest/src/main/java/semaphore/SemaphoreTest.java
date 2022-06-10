package semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
   static Semaphore semaphoreA = new Semaphore(10);


    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.execute(()->{
                try {
                    semaphoreA.acquire(3);
                    System.out.println("get one");
                    semaphoreA.release();
                    System.out.println(semaphoreA.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }

    }
}
