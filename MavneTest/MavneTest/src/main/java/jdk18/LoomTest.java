package jdk18;

import java.util.concurrent.atomic.AtomicInteger;

public class LoomTest {
    public static void main(String[] args) {
//        ReentrantLock lock = new ReentrantLock();
//        Thread thread1 = new Thread(() -> {
//            lock.lock();
//            System.out.println("thread-1");
//            System.out.println(Thread.currentThread().isInterrupted());
//            lock.unlock();
//        });
//        thread1.setName("thread-1");
//        Thread thread2 = new Thread(() -> {
//            lock.lock();
//            System.out.println("thread-2");
//            lock.unlock();
//        });
//        thread2.setName("thread-2");
//        Thread thread3 = new Thread(() -> {
//            lock.lock();
//            System.out.println("thread-3");
//            lock.unlock();
//        });
//        thread3.setName("thread-3");
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
        AtomicInteger atomicInteger = new AtomicInteger();
        Object o = new Object();
//        while (true) {
//            new Thread(() -> {
//
//                atomicInteger.incrementAndGet();
//                System.out.println(atomicInteger.get());
////                        Thread.sleep(Integer.MAX_VALUE);
//
//            }).start();
//        }
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {

                atomicInteger.incrementAndGet();
                System.out.println(atomicInteger.get());
//                        Thread.sleep(Integer.MAX_VALUE);

            }).start();
        }
    }
}
