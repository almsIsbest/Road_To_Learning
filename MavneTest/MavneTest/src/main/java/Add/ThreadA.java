package Add;

public class ThreadA extends Thread {
    Service service;
    int cc =0;
    int i;
    public ThreadA(Service service,int i) {
        this.service = service;
        this.i=i;
    }

    @Override
    public void run() {

        super.run();
        service.add1(i);
    }

}
