package BlockArrayLisy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Service {
//    ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(100);
//    int a = 0;
//    public Service() throws InterruptedException {
//        arrayBlockingQueue.put(0);
//    }
//     void add(int i) throws InterruptedException {
//        arrayBlockingQueue.put(arrayBlockingQueue.peek()+1);
//        arrayBlockingQueue.poll();
//        System.out.println("a" + a);
//        a++;
//    }
    Queue<Integer>linkedlist = new LinkedList<>();
    int a = 0;
    public Service(){
        linkedlist.add(0);
        System.out.println(linkedlist);
    }
    void add(int i){
        linkedlist.add(a+1);
        linkedlist.offer(a);
        linkedlist.poll();
        linkedlist.remove();
        System.out.println("a"+a);
        a++;
    }
}
