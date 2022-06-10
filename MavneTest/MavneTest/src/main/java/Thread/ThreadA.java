package Thread;

import lombok.SneakyThrows;

import java.sql.SQLOutput;

public class ThreadA extends Thread {
    private ThreadB b;

    public ThreadA(ThreadB b) {

        this.b = b;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (b) {
            b.start();
            b.join();
            System.out.println("哈？");
        }

    }
}
