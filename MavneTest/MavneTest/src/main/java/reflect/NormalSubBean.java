package reflect;

import java.util.ArrayList;

public class NormalSubBean {
    int subId;
    String subName;
    ArrayList<Integer> subList;

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public ArrayList<Integer> getSubList() {
        return subList;
    }

    public void setSubList(ArrayList<Integer> subList) {
        this.subList = subList;
    }
}
