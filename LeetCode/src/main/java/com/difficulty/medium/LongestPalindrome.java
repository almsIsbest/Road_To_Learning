package com.difficulty.medium;

/**
 * @ClassName LongestPalinDrome
 * @Description 题5 给你一个字符串 s，找到 s 中最长的回文子串。
 * @Author alms
 * @Data 2022/7/11 20:37
 **/
/**输入：s = "babad"
 输出："bab"
 解释："aba" 同样是符合题意的答案。
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "badad";

        System.out.println(LongestPalindrome(s));
    }

    public static String LongestPalindrome(String s){
        int len = s.length();

        /**长度小于2 为空或者只有一个字符必定是回文**/
        if(len <2 ){
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];
        char[] str = s.toCharArray();
        for(int i = 0 ;i<len;i++){
            dp[0][i] = true;
            dp[i][0] = true;
        }

        for(int L = 2 ; L<= len ;L++){
            for(int i = 0;i<len ;i++){
                int j = L+i-1;
                if(j>=len){
                    break;
                }

                if(str[i]!=str[j]){
                    dp[i][j] = false;
                }else {
                    if(j-i<3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if(dp[i][j]&&j-i+1>maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }

        return s.substring(begin,begin+maxLen);
    }
}
