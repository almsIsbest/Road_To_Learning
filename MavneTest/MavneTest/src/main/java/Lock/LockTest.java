package Lock;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread thread1 = new Thread(() -> {
            lock.lock();
            System.out.println("thread-1");
            System.out.println(Thread.currentThread().isInterrupted());
            lock.unlock();
        });
        thread1.setName("thread-1");
        Thread thread2 = new Thread(() -> {
            lock.lock();
            System.out.println("thread-2");
            lock.unlock();
        });
        thread2.setName("thread-2");
        Thread thread3 = new Thread(() -> {
            lock.lock();
            System.out.println("thread-3");
            lock.unlock();
        });
        thread3.setName("thread-3");
       // thread1.start();
        for (int i = 0; i < 5; i++) {
            thread1.start();
            thread2.start();
            thread3.start();
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        }
    }
}


