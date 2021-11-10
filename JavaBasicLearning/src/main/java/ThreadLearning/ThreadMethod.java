package ThreadLearning;

/**
 * @ClassName ThreadMethod
 * @Description TODO
 * @Author ThreadMethod
 * @Data 2021/10/27 19:56
 **/

class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        HelloThread h1=new HelloThread();

        h1.setName("A");
        h1.start();

        for (int i=0;i<100;i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if (i==20){
                h1.join();
            }
        }
    }

}
