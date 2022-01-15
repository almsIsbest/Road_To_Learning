package com.difficulty.medium;

/**
 * @ClassName IncreasingTriplet
 * @Description 334 递增的三元子序列
 * @Author IncreasingTriplet
 * @Data 2022/1/12 15:19
 **/
public class IncreasingTriplet {
    public static void main(String[] args) {
        int[] nums=new int[]{2,1,5,0,4,6};
        System.out.println(increasingTripletOne(nums));
    }

    //双向遍历
    public static boolean increasingTripletOne(int[] nums){
        int n =nums.length;
        if(n<3){
            return false;
        }
        int[] leftMin=new int[n];
        leftMin[0]=nums[0];
        for(int i=1;i<n;i++){
            leftMin[i]=Math.min(leftMin[i-1],nums[i]);
        }
        int[] rightMax=new int[n];
        rightMax[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],nums[i] );
        }

        for(int i=1;i<n-1;i++){
            if(nums[i]>leftMin[i-1]&&nums[i]<rightMax[i+1]){
                return true;
            }
        }
        return false;
    }

    public static boolean increasingTripletTwo(int[] nums){
        int n=nums.length;
        if(n<3){
            return false;
        }
        int first=nums[0],second=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            int num=nums[i];
            if(num>second){
                return true;
            }else if(num>first){
                second=num;
            }else {
                first=num;
            }
        }
        return false;
    }
}
