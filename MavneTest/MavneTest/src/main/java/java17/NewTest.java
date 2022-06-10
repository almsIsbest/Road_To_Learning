package java17;

import java.util.ArrayList;
import java.util.List;

public class NewTest {
    public static void main(String[] args) {
//        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
//        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
//        Random random = new Random();
//        List<Double> list = new ArrayList<>();
//        double miu = 9.6;
//        double sigma = 2.1;
//        for (int i = 0; i < 10000; i++) {
//            list.add(sigma * random.nextGaussian() + miu);
//        }
//        Collections.sort(list);
//        System.out.println(JSON.toJSONString(list));
//        System.out.println(random);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        lists.add(list1);
        lists.add(list);
        System.out.println(list1.getClass());
    }
}
