package BlockArrayLisy;

import lombok.SneakyThrows;

public class ThreadA extends Thread {
    Service service;
    int order;

    public ThreadA(Service service, int i) {
        this.service = service;
        this.order = i;

    }

    @SneakyThrows
    @Override
    public void run() {
        super.run();
        service.add(order);
    }
}
