package com.company;

public class StaticTest {
    public static StaticInit staticInit=new StaticInit();
    public static void main(String[] args) {
        Thread th1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第一次初始化");
                System.out.println(staticInit.init());


            }
        });

        th1.start();

        Thread th2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第二次初始化");
                System.out.println(staticInit.init());
            }
        });

        th2.start();
    }
}
