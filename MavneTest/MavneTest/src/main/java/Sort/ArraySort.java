package Sort;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

public class ArraySort {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(random.nextInt());
        }
        int min = Integer.MIN_VALUE;
        long start = System.currentTimeMillis();
//        for (int i = 0; i < arrayList.size(); i++) {
//            Thread.sleep(10);
//            if (arrayList.get(i) > min) {
//                min = arrayList.get(i);
//            }
//        }
        ExecutorService executorService = Executors.newCachedThreadPool();

        ArrayList<Future<Integer>> futureArrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Future<Integer> futureTask = executorService.submit(() -> {
                        int min1 = Integer.MIN_VALUE;
                        for (int i1 = finalI * 200; i1 < (finalI + 1) * 200; i1++) {
                            Thread.sleep(10);
                            if (arrayList.get(i1) > min1) {
                                min1 = arrayList.get(i1);
                            }
                        }
                        return min1;
                    }
            );
            futureArrayList.add(futureTask);
        }
        executorService.shutdown();
        for (Future<Integer> future : futureArrayList) {
            while (true) {
                if (future.isDone()) {
                    if (future.get() > min) {
                        min = future.get();
                        break;
                    }
                    break;
                }
            }
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(min);

    }
}
