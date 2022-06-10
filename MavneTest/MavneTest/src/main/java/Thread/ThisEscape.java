package Thread;

import java.lang.ref.PhantomReference;

public class ThisEscape {
    final int i;
    static int j = 0;
    static ThisEscape thisEscape;
    Escaple thread;
    public ThisEscape() {

        i = 1;
        j = 1;
        thisEscape = new ThisEscape();
        thread = new Escaple();

    }

    public static void main(String[] args) {
        ThisEscape th = thisEscape;
        th.thread.run();
    }
    private class Escaple {
        void run(){
            System.out.println(i);
            System.out.println(j);
        }
    }
}
