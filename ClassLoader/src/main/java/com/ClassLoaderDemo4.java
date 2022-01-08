package com;


/**
 * @ClassName ClassLoaderDemo4
 * @Description TODO
 * @Author ClassLoaderDemo4
 * @Data 2022/1/6 11:21
 **/
public class ClassLoaderDemo4 {
    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<1000;i++){
            Thread.sleep(10000);
            say();
        }
    }
    private static void say(){
        System.out.println("hello");
        System.out.println("helloreload");

    }
}
