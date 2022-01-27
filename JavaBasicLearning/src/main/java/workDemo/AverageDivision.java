package workDemo;

import java.util.ArrayList;

/**
 * @ClassName AverageDivision
 * @Description 平均划分 小于50 被划分到上一组 大于50 划分到新的一组
 * @Author AverageDivision
 * @Data 2022/1/18 11:44
 **/
public class AverageDivision {
    public static int group = 100;

    public static void main(String[] args) {
        int num1 = 1020;
        int num2 = 1080;
        averageDivision(num2).forEach(v-> System.out.println(v));
    }

    public static ArrayList<Integer> averageDivision(int num) {
        int i = num;
        ArrayList<Integer> nums = new ArrayList<>();
        while (i > 0) {
            int tmp = i - group;
            if (tmp <= 50) {
                nums.add(group + tmp);
                break;
            } else if (tmp > 50 && tmp < 100) {
                nums.add(group);
                nums.add(tmp);
                break;
            } else if (tmp >=100) {
                i = tmp;
                nums.add(group);
            }
        }
        return nums;
    }
}
