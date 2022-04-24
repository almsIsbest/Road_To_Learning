package ThreadLearning.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @ClassName BIockingQueueExample
 * @Description TODO
 * @Author alms
 * @Data 2022/4/21 11:35
 **/
public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(1024);

        Producer producer =new Producer(queue);
        Consumer consumer =new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
