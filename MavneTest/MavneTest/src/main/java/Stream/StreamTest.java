package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        list = list.stream().map(i -> i * i).collect(Collectors.toList());
        List<Integer> list1 = new Random().ints(1, 30).limit(20).boxed().collect(Collectors.toList());
        System.out.println(list1);
        int[] prices = {6, 12, 6, 23, 5, 28, 21, 27, 4, 18, 7, 15, 3, 27, 24, 13, 22, 20, 9, 17};
        int[][] ints = new int[prices.length][2];
        ints[0][0] = 0;
        ints[0][1] = -prices[0];
        int[][] intss = new int[prices.length][2];
        intss[0][0] = 0;
        intss[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            ints[i][0] = Math.max(ints[i - 1][0], ints[i - 1][1] + prices[i]);
            ints[i][1] = Math.max(ints[i - 1][1], ints[i - 1][0] - prices[i]);
        }
        Arrays.stream(ints).forEach(ints1 -> {
            System.out.println();
            Arrays.stream(ints1).forEach(System.out::print);
            System.out.println(" ");
        });
//        int[] ints1 = new int[10];
//        int weight = 50;
//        int[] w = {20, 10, 15, 30};
//        int[] v = {15, 10, 7, 25};
//        int[][] bugs = new int[4][50];
//        int[] bugss = new int[50];
//        for (int i = 0; i < 50; i++) {
//            bugs[0][i] = 0;
//            bugss[i] = 0;
//        }
//        for (int i = 1; i < 4; i++) {
//            for (int i1 = 49; i1 >= 0; i1--) {
//                bugss[i1] = Math.max(bugss[i1], bugss[i1 - w[i]] + v[i]);
//            }
//        }
//        Arrays.stream(bugss).boxed().forEach(System.out::println);
    }
}
