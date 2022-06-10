package Thread;

import java.util.Vector;

public class TestVector {
    static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);

            }
            Thread remove = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    try {
                        vector.remove(i);
                    }catch (Exception e){
                        System.out.println(e.toString());
                        System.out.println("remove failed");
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                    }


                }

            });
            Thread get = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    try {
                        System.out.println(vector.get(i));
                    }catch (Exception e){
                        System.out.println(e.toString());
                        System.out.println("get failed");
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                    }

                }
            });

            remove.start();
            get.start();
            while (Thread.activeCount() > 40) {}
        }
    }
}
