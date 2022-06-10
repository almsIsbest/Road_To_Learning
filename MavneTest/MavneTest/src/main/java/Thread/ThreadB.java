package Thread;

import lombok.SneakyThrows;

public class ThreadB extends Thread {


    @SneakyThrows
    @Override
    public void run() {
        System.out.println("start" + System.currentTimeMillis());
        Thread.sleep(5000);
        System.out.println("end" + System.currentTimeMillis());

    }
    public void bService(){
        System.out.println("bservice"+System.currentTimeMillis());
    }
}
