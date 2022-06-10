package Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class SortMain {
    public static void main(String[] args) {
        List<SortData> list = new ArrayList<>();
        list.add(new SortData(1, 1, 1));
        list.add(new SortData(1, 1, 2));
        list.add(new SortData(1, 2, 2));
        list.add(new SortData(1, 3, 2));
        list.add(new SortData(2, 1, 1));
        list.add(new SortData(2, 1, 2));
        list.add(new SortData(2, 2, 2));
        list.add(new SortData(2, 2, 3));
        list.add(new SortData(3, 1, 1));
        list.add(new SortData(3, 1, 2));
        list.add(new SortData(3, 1, 3));
        list.add(new SortData(3, 2, 2));
        list.sort((i1, i2) -> {
            if (i1.getFirst() != i2.getFirst()) {
                return i2.getFirst() - i1.first;
            } else {
                if (i1.getSecond() != i2.getSecond()) {
                    return i2.getSecond() - i1.getSecond();
                } else {
                    return i2.getThird() - i1.getThird();
                }

            }
        });
        System.out.println(calculate(1, 0, new int[]{1, 2, 3}, new int[]{1, 1, 2}));

    }

    public static int calculate(int k, int w, int[] profits, int[] capital) {
        TreeMap<Integer, PriorityQueue<Integer>> treeMap = new TreeMap<>();
        for (int i = 0; i < profits.length; i++) {
            var queue = treeMap.computeIfAbsent(capital[i], integer -> new PriorityQueue<>());
        }

        return w;
//        List<List<Integer>> list = new ArrayList<>();
//        for (int i = 0; i < profits.length; i++) {
//            List<Integer> subList = new ArrayList<>();
//            subList.add(profits[i]);
//            subList.add(capital[i]);
//            list.add(subList);
//        }
//        list.sort((i1, i2) -> {
//            if (!i1.get(0).equals(i2.get(0))) {
//                return i2.get(0) - i1.get(0);
//            } else {
//                return i1.get(1) - i2.get(1);
//            }
//        });
//        for (int i = 0; i < k; i++) {
//            List<Integer> max = new ArrayList<>();
//            max.add(0);
//            max.add(0);
//            for (List<Integer> integers : list) {
//                if (integers.get(1) <= w) {
//                    if (integers.get(0) > max.get(0)) {
//                        max = integers;
//                    }
//                }
//            }
//            list.remove(max);
//            w = w + max.get(0);
//
//
//        }

    }


    public static List<String> full(String[] words, int maxWidth) {
        return new ArrayList<>();
    }
}
