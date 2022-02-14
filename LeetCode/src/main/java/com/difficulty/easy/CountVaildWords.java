package com.difficulty.easy;

import java.util.regex.Pattern;

/**
 * @ClassName CountVaildWords
 * @Description 2047句子中的有效单词数
 * @Author CountVaildWords
 * @Data 2022/1/27 11:43
 **/
public class CountVaildWords {
    public static final String exp="([a-z]+(-[a-z]+)?)?[.,!]?";

    public static void main(String[] args) {
        System.out.println(countValidWords("cat and  dog"));
    }
    public static int countValidWords(String sentence) {
        String[] s=sentence.split(" ");
        int size=0;
        for(var i:s){
            if(isVaild(i)&&!"".equals(i)){
                size++;
            }
        }
        return size;
    }

    public static boolean isVaild(String word){
        return word.matches(exp);
    }
}
