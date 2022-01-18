package com.difficulty.medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName FindMinDifference
 * @Description 539最小时间差
 * @Author FindMinDifference
 * @Data 2022/1/18 10:53
 **/
public class FindMinDifference {
    public static void main(String[] args) {
        List<String> time=new ArrayList<>();
        time.add("23:59");
        time.add("00:00");
        System.out.println(findMinDifference(time));
    }

    public static int  findMinDifference(List<String> timePoints){
        Collections.sort(timePoints);
        int ans=Integer.MAX_VALUE;
        int t0=getTime(timePoints.get(0));
        int pre=t0;
        for(int i=1;i<timePoints.size();i++){
            int temp=getTime(timePoints.get(i));
            ans=Math.min(ans,temp-pre);
            pre=temp;
        }
        ans=Math.min(ans,t0+1440-pre);
        return ans;
    }

    public static int getTime(String time){
        return (time.charAt(0)*10+time.charAt(1))*60+time.charAt(3)*10+time.charAt(4);
    }
}
