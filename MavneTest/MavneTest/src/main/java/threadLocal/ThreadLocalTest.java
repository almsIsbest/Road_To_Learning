package threadLocal;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {
    static int int1 = 0;
    static ArrayList<Integer> list = new ArrayList<>();
    static ThreadLocal<String> local = new ThreadLocal<>();
    static ThreadLocal<String> anotherLocal = new ThreadLocal<>();
    static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        inheritableThreadLocal.set("main");
        Thread thread1 = new Thread(() -> {
//            for (int i = 0; i < 10000000; i++) {
//                int1++;
//                list.add(i);
//            }
            local.set("ccc");
            anotherLocal.set("anoccc");
            inheritableThreadLocal.set("thread1");
            System.out.println(Thread.currentThread().getName() + inheritableThreadLocal.get());
        });
        thread1.setName("Thread1");
        Thread thread2 = new Thread(() -> {
//            for (int i = 0; i < 10000000; i++) {
//                int1++;
//                list.add(i);
//            }
            anotherLocal.set("anoDDD");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + local.get());
        });
        ExecutorService service  = Executors.newCachedThreadPool();
        service.execute(()->{
            System.out.println("s");
        });
        thread2.setName("Thread2");
        thread1.start();
        thread2.start();
        System.out.println(Thread.currentThread().getName() + inheritableThreadLocal.get());
        Thread.sleep(2000);

    }
}
