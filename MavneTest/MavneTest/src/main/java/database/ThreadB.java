package database;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ThreadB implements Callable<Float> {
    Float min = Float.MAX_VALUE;
    ArrayList<Float> arrayList;
    int round;

    public ThreadB(ArrayList<Float> arrayList, int round,float K) {
        this.arrayList = arrayList;
        this.round = round;
    }

    @Override
    public Float call() throws Exception {
        if (round * 300000 > arrayList.size()) {

            for (int i = (round - 1) * 300000; i < arrayList.size(); i++) {
                if (arrayList.get(i) < min) {
                    min = arrayList.get(i);
                }
            }
        } else {
            System.out.println(Thread.currentThread().getName());
            for (int i = (round - 1) * 300000; i < round * 300000; i++) {
                if (arrayList.get(i) < min) {
                    min = arrayList.get(i);
                }
            }
        }
        return min;
    }
}
