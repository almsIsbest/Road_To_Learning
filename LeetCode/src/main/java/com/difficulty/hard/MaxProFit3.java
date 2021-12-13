package com.difficulty.hard;

/**
 * @ClassName MaxProFit
 * @Description /给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * //
 * // 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * //
 * // 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @Author MaxProFit
 * @Data 2021/12/13 16:30
 **/
public class MaxProFit3 {
    public static void main(String[] args) {
        int[] prices=new int[]{3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int buy1=-prices[0];int sell1=0;
        int buy2=-prices[0]; int sell2=0;
        for(int i=1;i< prices.length;i++){
            buy1=Math.max(buy1,-prices[i]);
            sell1=Math.max(sell1,buy1+prices[i]);
            buy2=Math.max(buy2,sell1-prices[i]);
            sell2=Math.max(sell2,buy2+prices[i]);
        }
        return sell2;
    }

}
