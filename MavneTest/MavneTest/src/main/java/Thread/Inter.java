package Thread;

public class Inter extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            if(i==50){
                Thread.currentThread().interrupt();
            }

        }
    }
}
