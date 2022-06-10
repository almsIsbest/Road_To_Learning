public class NoLock {
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 50; i++) {
                        System.out.println("A:" + i);
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 0; i < 50; i++) {
                        System.out.println("b:" + i);
                    }
                }
            }
        }).start();
    }
}
