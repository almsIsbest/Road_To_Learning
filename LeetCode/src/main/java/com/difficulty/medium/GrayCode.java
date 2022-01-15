package com.difficulty.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName GrayCode
 * @Description 格雷编码
 * @Author GrayCode
 * @Data 2022/1/11 14:55
 **/
public class GrayCode {
    public static void main(String[] args) {
        grayCodeTwo(2);
    }

    public static List<Integer> grayCode1(int n){
        ArrayList<String> prev = new ArrayList<>();
        prev.add("0");
        prev.add("1");
        for (int i = 0; i < n - 1; i++) {
            ArrayList<String> temp = new ArrayList<>();
            for (String s : prev) {
                temp.add("0" + s);
            }
            Collections.reverse(prev);
            for (String s : prev) {
                temp.add("1" + s);
            }
            prev = temp;
        }
        ArrayList<Integer> result =
                prev.stream().map(i -> Integer.parseInt(i,2)).collect(Collectors.toCollection(ArrayList::new));
        return result;
    }

    public static List<Integer> grayCodeTwo(int n){
        List<Integer> ret=new ArrayList<>();
        ret.add(0);
        for(int i=1;i<=n;i++){
            int m=ret.size();
            for(int j=m-1;j>=0;j--){
                ret.add(ret.get(j)|(1<<(i-1)));
            }
        }
        return ret;
    }
}
