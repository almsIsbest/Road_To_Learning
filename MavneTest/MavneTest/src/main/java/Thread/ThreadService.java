package Thread;

public class ThreadService {
    Object o;

    public ThreadService(Object o) {
        this.o = o;
    }

    void set() throws InterruptedException {
        synchronized (o) {
            if (ValueObject.arrayList.size() != 0) {
                o.wait();
            }
            try {
                ValueObject.arrayList.add(ValueObject.arrayList.size());
            } catch (Exception e) {
                System.out.println("error"+Thread.currentThread());
            }
            System.out.println(ValueObject.arrayList);
            System.out.println(System.nanoTime());
            System.out.println(Thread.currentThread());
            o.notify();
        }
    }

    void get() throws InterruptedException {
        synchronized (o) {
            if (ValueObject.arrayList.size() == 0) {
                o.wait();
            }
            try {
                ValueObject.arrayList.remove(ValueObject.arrayList.size() - 1);
            } catch (Exception e) {
                System.out.println(Thread.currentThread());
            }
            System.out.println(ValueObject.arrayList);
            System.out.println(System.nanoTime());
            System.out.println(Thread.currentThread());
            o.notify();
        }
    }
}