package Thread;

public class SimpleSync {


    volatile static Integer a = 0;

    public static void main(String[] args) throws InterruptedException {
        SimpleSync simpleSync = new SimpleSync();

        System.out.println("first" + ThisEscape.j);
        synchronized (simpleSync) {
            new Thread(() -> {
                for (int i = 0; i < 20; i++) {
                    a++;
                }
            }).start();
        }

        synchronized (simpleSync) {

            new Thread(()->{
                for (int i = 0; i < 100; i++) {
                    a++;
                }
            }).start();
        }
        System.out.println("endbefore" + a);
//        new Thread(() -> {
//            for (int i = 0; i < 100000; i++) {
//                ThisEscape.j++;
//            }
//        }).start();

        Thread.sleep(1000);
        System.out.println("end" + a);
    }
}