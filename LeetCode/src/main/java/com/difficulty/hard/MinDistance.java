package com.difficulty.hard;

/**
 * @ClassName MinDistance
 * @Description 72题 编辑距离
 * @Author MinDistance
 * @Data 2021/12/27 11:21
 **/
public class MinDistance {
    public static void main(String[] args) {
     String  word1 = "horse", word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2){
        int n=word1.length();
        int m=word2.length();

        if(n*m==0){
            return n+m;
        }
        int[][] dp=new int[n+1][m+1];

        for (int i=0;i<n+1;i++){
            dp[i][0]=i;
        }
        for (int j=0;j<m+1;j++){
            dp[0][j]=j;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                int left=dp[i-1][j]+1;
                int down=dp[i][j-1]+1;
                int down_left=dp[i-1][j-1];
                if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    down_left+=1;
                }
                dp[i][j]=Math.min(left,Math.min(down,down_left));
            }
        }
        return dp[n][m];
    }
}
