public class MyThread extends Thread implements Runnable{
    int count = 5;
    @Override
    public void run() {
        super.run();
        System.out.println();
    }

    Thread A = new Thread(()->{
        count=6;
        count=9;
        System.out.println(count);
    });
}
