package com.tennis.comm.utils.tools;

import com.alibaba.fastjson.JSON;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName CsvLoader
 * @Description
 * @Author alms
 * @Data 2022/5/20 12:01
 **/
public class CsvLoader {
    public static String getCsvFileString(String fileName, InputStream in) throws Exception {
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        var reader = CsvTools.getCsvReader(in);

        try {
            int index = 0;
            int columns = 0;

            HashMap<Integer, CsvColumn> atomMap = new HashMap<>();

            while (reader.readRecord()) {
                index++;
                HashMap<String, Object> map = null;

                if(index ==1){
                    columns = reader.getColumnCount();
                }

                for (int i = 0; i < columns; i++) {
                    String colValue = reader.get(i).replace("\\p{C}", "");
                    //第一行
                    if(index == 1){
                        if(colValue == null || colValue.trim().length()<1){
                            throw new Exception("文件" + fileName + "第" + i + "列名为空");
                        }
                        CsvColumn csvColumn = new CsvColumn(i, colValue);
                        atomMap.put(i,csvColumn);
                    }

                    //第二行
                    else if (index ==2){
                        if (colValue == null || colValue.trim().length() < 1) {
                            throw new Exception("文件" + fileName + "第" + i + "列数据类型为空");
                        }
                        var atom = atomMap.get(i);
                        atom.setNumType(colValue);
                    }

                    //第三行
                    else if (index == 3) {

                    }

                    //余下
                    else {
                        if(map == null){
                            map = new HashMap<>();
                        }
                       var atom = atomMap.get(i);
                       Object o =calColumnValue(colValue,atom);
                       if(o!=null){
                           map.put(atom.getName(),o);
                       }
                    }

                }
                if(map!=null){
                    list.add(map);
                }
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return JSON.toJSONString(list);
    }

    /**
     * int,float,bool,string,intArr,floatArr,boolArr,stringArr,intArrArr
     * @param value
     * @param atom
     * @return
     */
    private static Object calColumnValue(String value , CsvColumn atom) throws Exception{
        switch (atom.getNumType()){
            case "long":
                if(value == null || value.trim().length() < 1){
                    return 0;
                }
                return Long.parseLong(value.trim());

            case "int":
                if(value == null || value.trim().length() < 1){
                    return 0;
                }
                return Integer.parseInt(value.trim());

            case "float":
                if(value == null || value.trim().length() < 1){
                    return 0f;
                }
                return Float.parseFloat(value.trim());

            case "bool":
                if(value == null || value.trim().length() < 1){
                    return false;
                }
                return Boolean.parseBoolean(value.trim());

            case "string":
                if(value == null || value.trim().length() < 1){
                    return "";
                }
                return value;

            case "intArr":
                if(value == null || value.trim().length() < 1){
                    return new ArrayList<>();
                }
                return Tools.parseIntArray(value,fsParam);

            case "floatArr":
                if(value == null || value.trim().length() < 1){
                    return new ArrayList<>();
                }
                String[] fs = value.split(fsParam);
                ArrayList<Float> fList = new ArrayList<>();
                for(int i=0;i<fs.length; i++){
                    fList.add(Float.parseFloat(fs[i]));
                }
                return fList;

            case "boolArr":
                if(value == null || value.trim().length() < 1){
                    return new boolean[0];
                }
                String[] bs = value.split(fsParam);
                ArrayList<Boolean> list = new ArrayList<>();
                for(int i=0;i<bs.length; i++){
                    list.add(Boolean.parseBoolean(bs[i]));
                }
                return list;

            case "stringArr":
                if(value == null || value.trim().length() < 1){
                    return new ArrayList<>();
                }
                return Arrays.stream(value.split(fsParam)).toArray();

            case "intArrArr":
                return Tools.parseIntList(value,fsParam,ssParam);

            case "mask":
                if(value == null || value.trim().length() <1){
                    throw new Exception("mask 字段为空,第"  + atom.getIndex()+"列");
                }
//                return value;
                return Tools.parseIntArray(value,ssParam);

            default:
                throw new Exception("类型错误，第" + atom.getIndex() + "列");
        }
    }

    public static final String fsParam = "&";
    public static final String ssParam = "\\|";
}
