package jdk18;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo1 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        while (true){
            new MyThread(atomicInteger.getAndIncrement()).start();
        }
    }
}
