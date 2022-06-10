package database;

import java.util.ArrayList;

public class ThreadA extends Thread {
    ArrayList<?> arrayList;
    int round;

    public ThreadA(ArrayList<?> arrayList, int round) {
        this.arrayList = arrayList;
        this.round = round;
    }

    @Override
    public void run() {
        super.run();
        synchronized (arrayList) {
            for (int i = (round - 1) * 5; i < round * 5; i++) {
                System.out.println(this.getName() + " " + arrayList.get(i));
            }
        }
    }
}
