package com.company;


import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


class Thread1 extends Thread {
    private String name;

    public Thread1(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程运行开始");
        for (int i = 0; i < 5; i++) {
            System.out.println("线程" + name + "运行: " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 线程运行结束");
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"主线程开始");
        Thread mth1=new Thread1("A");
        Thread mth2=new Thread1("B");
        mth1.start();
        mth2.start();
        try{
            mth1.join();
        }catch (Exception e){
            e.printStackTrace();
        }
       try{
           mth2.join();
       }catch (Exception e){
           e.printStackTrace();
       }
        System.out.println(Thread.currentThread().getName()+"主线程运行结束");
    }
}
