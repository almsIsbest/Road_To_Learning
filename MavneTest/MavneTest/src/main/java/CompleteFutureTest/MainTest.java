package CompleteFutureTest;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

@Slf4j
public class MainTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        //ArrayList<Integer> list = new ArrayList<>();
//        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
//        ReentrantLock lock = new ReentrantLock();
//        long now = System.currentTimeMillis();
////        ArrayList<CompletableFuture<Void>> list1 = IntStream.rangeClosed(1, 10000).mapToObj(n -> {
////            return CompletableFuture.runAsync(() -> {
////                list.add(n);
////            });
////                }).collect(list);
//        List<CompletableFuture<Boolean>> list1 = IntStream.rangeClosed(1, 100).mapToObj(m -> {
//
//            return CompletableFuture.supplyAsync(() -> list.add(m));
//        }).collect(Collectors.toList());
//        System.out.println(list.size());
//        System.out.println(System.currentTimeMillis() - now);
//        TimeUnit.SECONDS.sleep(3);
//        System.out.println(list.size());
//        System.out.println(list);

        ArrayList<Integer> list = new ArrayList<>();
        long total = 0;
        ArrayList<Future<Long>> list1 = new ArrayList<>();
        int[] ints = IntStream.rangeClosed(1, 10000).toArray();


        AtomicLong anoTotal = new AtomicLong();
        for (int i = 0; i < 500; i++) {
            int start = (i) * 20;
            int end = (i + 1) * 20;
            CompletableFuture.supplyAsync(() -> {
                long subTotal = 0;
                for (int i1 = start; i1 < end; i1++) {
                    subTotal += ints[i1];
                }
                return subTotal;

            }).thenAccept(anoTotal::addAndGet);
        }
        Thread.sleep(500);
        ;
        System.out.println("ano" + anoTotal);


        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 500; i++) {
            int start = (i) * 20;
            int end = (i + 1) * 20;
            list1.add(service.submit(() -> {
                long subTotal = 0;
                for (int i1 = start; i1 < end; i1++) {
                    subTotal += ints[i1];
                }
                return subTotal;
            }));
        }
        for (Future<Long> future : list1) {
            total += future.get();
        }
        service.shutdown();
        System.out.println(total);
//        OptionalInt a = IntStream.rangeClosed(1,50000).reduce((i, j)->(i+j)/2);
//        OptionalInt b = IntStream.rangeClosed(1,50000).parallel().reduce((i, j)->(i+j)/2);
//
//        System.out.println(a);
//        System.out.println(b);
        Instant now = Instant.now();
        int a = IntStream.rangeClosed(1, 50000).reduce(0, Integer::sum);
        Instant result = Instant.now();
        int b = IntStream.rangeClosed(1, 50000).parallel().reduce(0, Integer::sum);
        Instant end = Instant.now();
        System.out.println(a);
        System.out.println(b);
        System.out.println(now);
        System.out.println(result);
        System.out.println(end);
    }
}
