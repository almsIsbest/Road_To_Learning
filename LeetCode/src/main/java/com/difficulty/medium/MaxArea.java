package com.difficulty.medium;

/**
 * @ClassName MaxArea
 * @Description TODO
 * @Author MaxArea
 * @Data 2022/1/12 17:32
 **/
public class MaxArea {
    public static void main(String[] args) {
        int[] height=new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
