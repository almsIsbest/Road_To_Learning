package com.difficulty.medium;

import java.util.concurrent.RunnableFuture;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName FooBar
 * @Description 1115交替打印
 * @Author FooBar
 * @Data 2022/1/12 20:39
 **/
public class FooBar {

    private int n;
    volatile  boolean check=false;
    Object lock=new Object();
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        synchronized (lock) {
            check=true;
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                lock.notify();
                lock.wait();
            }
            lock.notify();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        while(!check){

        }
        synchronized (lock) {
            for (int i = 0; i < n; i++) {

                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
//                check=false;
                lock.notify();
                lock.wait();
            }
            lock.notify();
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(5);
        Runnable foo = new Runnable() {
            @Override
            public void run() {
                System.out.println("foo");
            }
        };
        Runnable bar = new Runnable() {
            @Override
            public void run() {
                System.out.println("bar");
            }
        };

        new Thread(() -> {
            try {
                fooBar.foo(foo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.foo(bar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
