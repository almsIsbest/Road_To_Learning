import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class LoomTets {
    public static void main(String[] args) throws InterruptedException {

//        ReentrantLock lock = new ReentrantLock();
//        Thread thread1 = Thread.startVirtualThread(() -> {
//            lock.lock();
//            System.out.println("thread-1");
//            System.out.println(Thread.currentThread().isInterrupted());
//            lock.unlock();
//        });
//        thread1.setName("thread-1");
//        Thread thread2 = Thread.startVirtualThread(() -> {
//            lock.lock();
//            System.out.println("thread-2");
//            lock.unlock();
//        });
//        thread2.setName("thread-2");
//        Thread thread3 = Thread.startVirtualThread(() -> {
//            lock.lock();
//            System.out.println("thread-3");
//            lock.unlock();
//        });
//        thread3.setName("thread-3");
//        Thread.sleep(22222222);
//        thread1.start();
//        thread2.start();
//        thread3.start();
        AtomicInteger atomicInteger = new AtomicInteger();
        while (true){
            Thread.startVirtualThread(()->{
                System.out.println(atomicInteger.addAndGet(1));
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
