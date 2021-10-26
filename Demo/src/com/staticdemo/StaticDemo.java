package com.staticdemo;


class TestStaic{
    public static final String INIT = "init";
    static {
        System.out.println("------TestStaic----");
    }
}

public class StaticDemo {
    public static final int i=6;
    static {
        System.out.println("static运行");
    }
    public static void main(String[] args) {
        System.out.println(TestStaic.INIT);
    }
}
