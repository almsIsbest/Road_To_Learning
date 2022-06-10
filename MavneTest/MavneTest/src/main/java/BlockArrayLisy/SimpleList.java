package BlockArrayLisy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleList {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                for (Iterator<Integer> integerIterator = list.iterator(); integerIterator.hasNext(); ) {
                    i++;
                    integerIterator.next();
                    integerIterator.remove();
                    if (i == 10) {
                        break;
                    }
                }
            }
        };
        for (int i = 0; i < 10; i++) {
            executorService.submit(r);
        }
        Thread.sleep(1500);
        executorService.shutdown();

        System.out.println(list.size());
        System.out.println(list);
    }
}
