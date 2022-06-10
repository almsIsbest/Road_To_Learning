package reflect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class NormalBean {
    int id;
    HashSet<String>childrenNames;
    HashMap<String,Integer>nameAndAge;
    NormalSubBean normalSubBean;
    boolean sex;
    float size ;
    String name;
    ArrayList<Integer>childrenAges ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getChildrenAges() {
        return childrenAges;
    }

    public void setChildrenAges(ArrayList<Integer> childrenAges) {
        this.childrenAges = childrenAges;
    }

    public HashSet<String> getChildrenNames() {
        return childrenNames;
    }

    public void setChildrenNames(HashSet<String> childrenNames) {
        this.childrenNames = childrenNames;
    }

    public HashMap<String, Integer> getNameAndAge() {
        return nameAndAge;
    }

    public void setNameAndAge(HashMap<String, Integer> nameAndAge) {
        this.nameAndAge = nameAndAge;
    }

    public NormalSubBean getNormalSubBean() {
        return normalSubBean;
    }

    public void setNormalSubBean(NormalSubBean normalSubBean) {
        this.normalSubBean = normalSubBean;
    }
}
