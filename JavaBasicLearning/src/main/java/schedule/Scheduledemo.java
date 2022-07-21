package schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Scheduledemo
 * @Description TODO
 * @Author Scheduledemo
 * @Data 2021/11/26 18:35
 **/
public class Scheduledemo {
    public static void main(String[] args) {
//        ScheduledExecutorService res= Executors.newScheduledThreadPool(1);
//
//        Runnable task2=()-> System.out.println("Running task2");
//
//        ScheduledFuture<?> result=res.schedule(task2,5, TimeUnit.SECONDS);
//        if(result!=null&&result.isCancelled()){
//            System.out.println("已经取消");
//        }

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("rrrr");
                return;
            }
        },0,1, TimeUnit.SECONDS);
    }

}
