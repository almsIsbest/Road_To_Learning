package Thread;

public class ValOutAct {
    int num;
    Object lock1 = new Object();
    Object lock2 = new Object();
    String string = new String();

    void assign(int a) throws InterruptedException {
        synchronized (this) {
            System.out.println(System.currentTimeMillis());

            System.out.println(a);
        }
    }

    synchronized void anotherAssign(int a) throws InterruptedException {

        System.out.println(System.currentTimeMillis());

        System.out.println(a);

    }
}
