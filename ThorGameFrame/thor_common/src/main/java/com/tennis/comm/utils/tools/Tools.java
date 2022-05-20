package com.tennis.comm.utils.tools;

import java.util.ArrayList;

/**
 * @ClassName Tools
 * @Description
 * @Author alms
 * @Data 2022/5/20 15:52
 **/
public class Tools {

    /**
     * 把由外层,内层两个分隔符的字符串转换为int[] 的List
     * 如: 1,2,3;4,5,6;7,8,9
     * 其中 ";" 为外层分隔符 ","为内层分隔符
     * @param str
     * @param targ1 外层分隔符
     * @param targ2 内层分隔符
     * @return 转换成的int[] List
     */
    public static ArrayList<int[]> parseIntList(String str, String targ1, String targ2){
        if(str == null || str.trim().equals("")){
            return null;
        }
        ArrayList<int[]> list = new ArrayList<>();
        String[] tmp = str.split(targ1);
        for(int i = 0;i<tmp.length;i++){
            if(tmp[i].trim().length() < 1) {
                continue;
            }
            String[] tmp2 = tmp[i].split(targ2);
            int[] in = new int[tmp2.length];
            for(int j = 0;j<in.length;j++){
                in[j] = Integer.parseInt(tmp2[j]);
            }
            list.add(in);
        }
        return list;
    }

    /**
     * @param str
     * @param targ1 外层分隔符
     * @return 转换成的int[]
     */
    public static int[] parseIntArray(String str, String targ1){
        if(str == null || str.trim().equals("")){
            return null;
        }
        String[] tmp = str.split(targ1);
        int[] array = new int[tmp.length];
        for(int i = 0;i<tmp.length;i++){
            array[i] = Integer.parseInt(tmp[i]);
        }
        return array;
    }

}
