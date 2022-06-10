package Thread;

import java.time.chrono.ThaiBuddhistChronology;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
class ThLocal extends ThreadLocal{
    @Override
    protected Object initialValue() {
        return System.nanoTime();
    }
}
public class TimeWait {
    public static void main(String[] args) throws InterruptedException {


        StringBuilder str = new StringBuilder("string");
        ThLocal thLocal = new ThLocal();

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(thLocal.get());
            }
        });
        thread.start();
        thread.join();
        for (int i = 0; i < 5; i++) {
            System.out.println(thLocal.get());
        }
        ThreadLocal<String>threadLocal = new ThreadLocal<>();
        threadLocal.set("23");
        threadLocal.set("112233");
        System.out.println(threadLocal);
    }
}
