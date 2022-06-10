package Sort;

import java.util.ArrayList;
import java.util.List;

class ThreadA extends Thread {
   volatile boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public ThreadA setFlag(boolean flag) {
        this.flag = flag;
        return this;
    }

    @Override
    public void run() {
        super.run();
        while (flag) {
        }
        System.out.println(flag + "结束");
    }
}

public class TestSort {
    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        threadA.start();
        Thread.sleep(1000);
        threadA.setFlag(false);
        System.out.println("fuzhiwanbi");

    }
}
