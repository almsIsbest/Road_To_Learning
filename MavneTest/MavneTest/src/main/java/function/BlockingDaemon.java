package function;

public class BlockingDaemon {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("www");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Deamon");
        });
        //.setDaemon(true);
        thread.start();
        System.out.println("end it");
    }
}
