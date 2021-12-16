package com.difficulty.medium;

/**
 * @ClassName Jump_2
 * @Description //给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * //
 * // 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * //
 * // 判断你是否能够到达最后一个下标。
 * @Author Jump_2
 * @Data 2021/12/16 14:57
 **/
public class Jump_2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.printf("steps = %d", jump2(nums));
        jump2_second(nums);
    }

    public static int jump2(int[] nums) {
        int pos = nums.length - 1;
        int steps = 0;

        while (pos > 0) {
            for (int i = 0; i < pos; i++) {
                if (nums[i] + i >= pos) {
                    steps++;
                    pos = i;
                    break;
                }
            }
        }
        return steps;
    }


    public static int jump2_second(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

}
