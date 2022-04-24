package ThreadLearning.blockqueue;

import java.util.concurrent.BlockingQueue;

/**
 * @ClassName Consumer
 * @Description TODO
 * @Author alms
 * @Data 2022/4/21 11:39
 **/
public class Consumer implements Runnable{

    private BlockingQueue queue =null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
