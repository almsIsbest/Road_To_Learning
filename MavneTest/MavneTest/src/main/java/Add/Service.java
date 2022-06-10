package Add;

public class Service {
    int ser = 0;
    int order = 0;
    Object object = new Object();
    void add1(int i) {
        synchronized (object) {
            ser = i;
            order++;
            System.out.println(i);
            System.out.println("order" + order);
        }
    }
}
