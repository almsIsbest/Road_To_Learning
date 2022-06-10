package BlockArrayLisy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class synList {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        List<Integer> normalList = new ArrayList<>();
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            service.submit(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
                    list.add(i1);
                    normalList.add(i1);
                }

            });
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(list.size());
        System.out.println(normalList.size());
    }
}
