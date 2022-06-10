package Add;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.print.attribute.standard.OrientationRequested;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Myrun {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        Thread[] threads = new Thread[10000];
        for (int i = 0; i < 10000; i++) {
            threads[i]=new ThreadA(service,i);

        }
        for (int i = 0; i < 10000; i++) {
            threads[i].start();
        }
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.getAndIncrement();
        Thread.sleep(1000);
        System.out.println( "  "+service.ser);
        System.out.println("order:"+ service.order);
    }
}
