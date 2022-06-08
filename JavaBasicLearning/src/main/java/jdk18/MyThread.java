package jdk18;

public class MyThread extends Thread{
    public int i ;
    @Override
    public void run() {
        System.out.println("Thread"+i);
        while (true){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public MyThread(int i){
        this.i = i;
    }
}
