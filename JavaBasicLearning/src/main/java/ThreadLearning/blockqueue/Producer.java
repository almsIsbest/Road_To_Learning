package ThreadLearning.blockqueue;

import java.util.concurrent.BlockingQueue;

/**
 * @ClassName Producer
 * @Description TODO
 * @Author alms
 * @Data 2022/4/21 11:36
 **/
public class Producer implements Runnable {

    protected BlockingQueue queue =null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
