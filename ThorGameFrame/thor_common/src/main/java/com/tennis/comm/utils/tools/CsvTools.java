package com.tennis.comm.utils.tools;

import com.csvreader.CsvReader;

import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @ClassName CsvTools
 * @Description  CSV工具
 * @Author alms
 * @Data 2022/5/20 11:37
 **/
public class CsvTools {

    public static CsvReader getCsvReader(InputStream in) throws Exception{
        CsvReader reader = new CsvReader(in, Charset.forName("UTF-8"));
        return reader;
    }


    public static int getIntValue(CsvReader reader,int index) throws Exception{
        String s = reader.get(index).trim();
        if(s == null || s.trim().length() < 1) {
            return 0;
        }
        return Integer.parseInt(s);
    }

    public static float getFloatValue(CsvReader reader ,int index) throws Exception{
        String s = reader.get(index).trim();
        if(s == null || s.trim().length() < 1) {
            return 0f;
        }
        return Float.parseFloat(s);
    }


    public static int getIntValue(CsvReader reader,String titleName) throws Exception{
        String s = reader.get(titleName).trim();
        if(s == null || s.trim().length() < 1) {
            return 0;
        }
        return Integer.parseInt(s);
    }

    public static float getFloatValue(CsvReader reader ,String name) throws Exception{
        String s = reader.get(name).trim();
        if(s == null || s.trim().length() < 1) {
            return 0f;
        }
        return Float.parseFloat(s);
    }

}
