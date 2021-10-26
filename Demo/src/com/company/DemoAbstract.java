package com.company;

public abstract class DemoAbstract {
    public abstract void run();

    public static int run(int c){
        return c;
    }

    public static void main(String[] args) {
        DemoAbstract demoAbstract=new DemoAbstract() {
            @Override
            public void run() {
                System.out.println("hhhh");
            }
        };
        demoAbstract.run();
        System.out.println(run(5));
    }
}
