package Thread;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

class Thr extends Thread {
    Object object = new Object();

    @SneakyThrows
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {

            System.out.println(i);
            if (i == 30) {
                try {
                    System.out.println(System.currentTimeMillis());
                    Thread.currentThread().interrupt();
                    Thread.sleep(500);
                    System.out.println(System.currentTimeMillis());
                } catch (Exception e) {
                    System.out.println(System.currentTimeMillis());
                    System.out.println(" come in exception");
                    e.printStackTrace();
                    Thread.sleep(500);
                    System.out.println("mowei");
                    System.out.println(System.currentTimeMillis());
                }
            }
        }
    }
}

public class InterruptTets {
    public static void main(String[] args) {
        Thr thr = new Thr();
        thr.start();

    }
}
