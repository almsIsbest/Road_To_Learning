package com.difficulty.easy;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Foo
 * @Description 1114按序打印
 * @Author Foo
 * @Data 2022/1/12 18:37
 **/
public class Foo {
    AtomicInteger firstInteger=new AtomicInteger(0);
    AtomicInteger secondInteger=new AtomicInteger(0);
    AtomicInteger commonInteger=new AtomicInteger(0);
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        while(true) {
           if (commonInteger.get() % 3 == 0) {
                printFirst.run();
                commonInteger.incrementAndGet();
                break;
            }
        }
//        firstInteger.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(true) {
            if (commonInteger.get() % 3 == 1) {
                printSecond.run();
                commonInteger.incrementAndGet();
                break;
            }
        }
        // printSecond.run() outputs "second". Do not change or remove this line.

//        secondInteger.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (true) {
            if (commonInteger.get() % 3 == 2) {
                printThird.run();
                commonInteger.incrementAndGet();
                break;
            }
            // printThird.run() outputs "third". Do not change or remove this line.
        }
    }

    public static void main(String[] args) {
        Runnable first = new Runnable() {
            @Override
            public void run() {
                System.out.println("first");
            }
        };
        Runnable second = new Runnable() {
            @Override
            public void run() {
                System.out.println("second");
            }
        };
        Runnable third = new Runnable() {
            @Override
            public void run() {
                System.out.println("third");
            }
        };
        Foo foo =new Foo();
        new Thread(()-> {
            try {
                 foo.first(first);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                foo.second(second);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                foo.third(third);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
