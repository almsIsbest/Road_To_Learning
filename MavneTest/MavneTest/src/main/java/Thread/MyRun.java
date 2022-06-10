package Thread;

public class MyRun {
    public static void main(String[] args) throws InterruptedException {

        MyService myService = new MyService(false);
        MyThread[] myThreads1 = new MyThread[10];
        MyThread[] myThreads2 = new MyThread[10];
        for (int i = 0; i < myThreads1.length; i++) {
            myThreads1[i] = new MyThread(myService);
            myThreads1[i].setName("+++" + (i + 1));
        }
        for (int i = 0; i < myThreads1.length; i++) {
            Thread.sleep(5);
            myThreads1[i].start();
        }
        for (int i = 0; i < myThreads2.length; i++) {
            myThreads2[i] = new MyThread(myService);
            myThreads2[i].setName("---" + (i + 1));
        }
        Thread.sleep(500);
        for (int i = 0; i < myThreads2.length; i++) {
            Thread.sleep(5);
            myThreads2[i].start();
        }

    }
}
