package ThreadLearning.Semaphore;

import ThreadLearning.ThreadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName SemaphoreTestTwo
 * @Description TODO
 * @Author SemaphoreTestTwo
 * @Data 2022/1/13 20:58
 **/
public class SemaphoreTestTwo {
    private static final int COUNT=40;
    private static ExecutorService executors=Executors.newFixedThreadPool(COUNT);
    private static Semaphore semaphore=new Semaphore(10);

    public static void main(String[] args) {
        for(int i=0;i<COUNT;i++){
            executors.execute(new Task());
        }
    }

   static class Task implements Runnable{

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("IO");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

