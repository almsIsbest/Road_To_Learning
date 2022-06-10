package Thread;

public class ThreadC extends Thread {
    ThreadB b;

    public ThreadC(ThreadB b) {
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (b) {
            b.bService();
        }
    }
}
