package com.tennis.comm.utils.tools;

/**
 * @ClassName CsvColumn
 * @Description
 * @Author alms
 * @Data 2022/5/20 12:07
 **/
public class CsvColumn {

    private int index;
    private String name;
    private String numType;

    public CsvColumn(int index,String name){
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumType() {
        return numType;
    }

    public void setNumType(String numType) {
        this.numType = numType;
    }
}
