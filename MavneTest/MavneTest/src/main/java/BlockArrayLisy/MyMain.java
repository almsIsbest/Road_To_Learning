package BlockArrayLisy;

public class MyMain {
    public static void main(String[] args) throws InterruptedException {
        Thread[]threads = new Thread[100];
        Service service = new Service();
        for (int i = 0; i < 100; i++) {
            threads[i]=new ThreadA(service,i);
        }
        for (int i = 0; i < 100; i++) {
            threads[i].start();

        }
        Thread.sleep(1000);
        System.out.println(service.linkedlist);
    }
}
