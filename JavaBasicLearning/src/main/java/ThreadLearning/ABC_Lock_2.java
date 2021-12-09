package ThreadLearning;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ABC_Lock_2
 * @Description TODO
 * @Author ABC_Lock_2
 * @Data 2021/12/8 17:02
 **/
public class ABC_Lock_2 {
    private static AtomicInteger atomicInteger=new AtomicInteger(0);

    static class ThreadA extends Thread{
        @Override
        public void run() {
            for (int i=0;i<10;i++){
                while(atomicInteger.get()%3==0){
                    System.out.println("a");
                    atomicInteger.incrementAndGet();

                }
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadB extends Thread{
        @Override
        public void run() {
            for (int i=0;i<10;i++){
                while (atomicInteger.get()%3==1){
                    System.out.println("b");
                    atomicInteger.incrementAndGet();

                }
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadC extends Thread{
        @Override
        public void run() {
            for (int i=0;i<10; i++){
                while(atomicInteger.get()%3==2){
                    System.out.println("c");
                    atomicInteger.incrementAndGet();
                }
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}
