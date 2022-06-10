package Lock;

import java.util.concurrent.locks.ReentrantLock;

class ServiceLock{
    public ReentrantLock lock = new ReentrantLock();
    public void method(){
        if(lock.tryLock()){
            System.out.println(Thread.currentThread().getName()+"suo");
        }else {
            System.out.println(Thread.currentThread().getName()+"meisuo");
        }
    }
}
public class TryLockTest {
    public static void main(String[] args) throws InterruptedException {
        ServiceLock serviceLock = new ServiceLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                serviceLock.method();
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.setName("1");
        thread1.start();
        Thread.sleep(1000);
        Thread thread2 = new Thread(runnable);
        thread2.setName("2");
        Thread.sleep(1000);
        thread2.start();

        Thread thread3 = new Thread(runnable);
        thread3.setName("3");
        thread3.start();
    }
}
