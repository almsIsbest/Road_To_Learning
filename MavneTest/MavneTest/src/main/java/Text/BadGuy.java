package Text;

import java.util.ArrayList;

public class BadGuy {
    int a;
    int b;
    ArrayList<ball[]> arrayList;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public ArrayList<ball[]> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<ball[]> arrayList) {
        this.arrayList = arrayList;
    }

    public BadGuy(int a, int b, ArrayList<ball[]> arrayList) {
        this.a = a;
        this.b = b;
        this.arrayList = arrayList;
    }
}
