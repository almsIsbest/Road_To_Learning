package com.difficulty.easy;

/**
 * @ClassName Reverse
 * @Description 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * @Author Reverse
 * @Data 2021/12/13 14:46
 **/
public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    public static int reverse(int x) {
        int res=0;
        while (x!=0){
            int tmp=x%10;
            if(res>214748364||(res==214748364)&&tmp>7){
                return 0;
            }

            if(res<-214748364||(res==-214748364)&&tmp<-8){
                return 0;
            }
            res=res*10+tmp;
            x/=10;
        }
        return res;
    }
}
