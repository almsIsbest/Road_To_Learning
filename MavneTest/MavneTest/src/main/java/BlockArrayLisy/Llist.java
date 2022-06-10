package BlockArrayLisy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Betta
 */
public class Llist {
    public static void main(String[] args) {
String  s = "user_id               \n" +
        "sync_id               \n" +
        "coins                 \n" +
        "timer_coin_reset_time \n" +
        "star                  \n" +
        "star_chest            \n" +
        "energy                \n" +
        "energy_start_time     \n" +
        "stage                 \n" +
        "stage_try_times       \n" +
        "prop                  ";
        List<String>list= Arrays.stream(s.split("\n")).map(String::trim).collect(Collectors.toList());
        System.out.println(list);
    }

    static int sssddd(List<Integer> list) {
        if (list.size() == 0) {
            return 1;
        }
        if (list.get(0) == 0) {
            return 0;
        }
        if (list.size() == 1) {
            return 1;
        }
        if (10 * list.get(0) + list.get(1) <= 26) {
            return sssddd(list.subList(2, list.size())) + sssddd(list.subList(1, list.size()));
        } else {
            return sssddd(list.subList(1, list.size()));
        }

    }

    static int cccc() {
        ArrayList<String> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            if (random.nextInt() % 2 == 0) {
                list.add("(");
            } else {
                list.add(")");
            }
        }
        System.out.println(list);
        int degree = 0;
        int left = 0;
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (degree == 0) {
                max = i - left;
                left = i;
            }
            if (degree < 0) {
                left = i + 1;
                degree = 0;
                continue;
            }
            if (list.get(i).equals("(")) {
                degree++;
            }
            if (list.get(i).equals(")")) {
                degree--;
            }


        }
        return max;
    }

    static int feibonaqi(int i) {
        if (i == 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        } else {
            return feibonaqi(i - 1) + feibonaqi(i - 2);
        }
    }

    static int taibonaqi(int i) {
        if (i == 0) {
            return 0;
        } else if (i == 1) {
            return 1;

        } else if (i == 2) {
            return 2;
        } else {
            return taibonaqi(i - 1) + feibonaqi(i - 2) + feibonaqi(i - 3);
        }
    }
}
