package Error;

import java.util.LinkedList;
import java.util.Queue;

public class ErrorStd {

    public static void main(String[] args) throws InterruptedException {
        Queue<Integer>queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);


        LinkedList<Integer>list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.add(0,4);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
