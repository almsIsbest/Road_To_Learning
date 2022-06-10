package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    public Lock lock;

    public MyService(boolean fair) {
        lock = new ReentrantLock(fair);
    }
    public void method(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
