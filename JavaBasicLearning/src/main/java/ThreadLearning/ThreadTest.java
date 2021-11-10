package ThreadLearning;

/**
 * @ClassName ThreadTest
 * @Description * 多线程创建，方法一：继承Thread类
 * * 1.创建一个类于Thread类的子类
 * * 2.重写Thread类的run（）方法
 * * 3.创建Thread类的子类的对象
 * * 4.通过此对象调用start（）启动
 * 例子：遍历100以内的所有的偶数
 * @Author alms
 * @Data 2021/10/27 17:52
 **/

//1. 创建一个继承于Thread类的子类
class MyThread extends Thread {



    @Override
    /**
     * @Author alms
     * @Description //TODO
     * @Date 17:59 2021/10/27
     * @Param []
     * @return void
     **/
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread t1=new MyThread();

        //4.运行此对象调用start（）
        t1.start();
    }
}
