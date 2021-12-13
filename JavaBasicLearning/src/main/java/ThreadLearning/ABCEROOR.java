package ThreadLearning;

/**
 * @ClassName ABC
 * @Description TODO
 * @Author ABC
 * @Data 2021/12/10 10:25
 **/


import java.util.concurrent.locks.Condition;

import java.util.concurrent.locks.ReentrantLock;



public class ABCEROOR {

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition A = lock.newCondition();

    private static Condition B = lock.newCondition();

    private static Condition C = lock.newCondition();



    private static int count = 0;

    private static Object object = new Object();



    static class ThreadA extends Thread {



        @Override

        public void run() {



            synchronized (object){

                System.out.println(Thread.currentThread().getName());

                for (int i = 0; i < 10; i++) {

                    while (count%3!=0){

                        object.notifyAll();

                        try {

                            object.wait();

                        } catch (InterruptedException e) {

                            e.printStackTrace();

                        }



                    }

                    System.out.println("A");

                    count++;

                    object.notifyAll();

                    try {

                        object.wait();

                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }

                    //object.notifyAll();

                }

            }

//            try {

//                lock.lock();

//                for (int i = 0; i < 10; i++) {

//                    while (count % 3 != 0) {//注意这里是不等于0，也就是说没轮到该线程执行，之前一直等待状态

////                        A.await(); //该线程A将会释放lock锁，构造成节点加入等待队列并进入等待状态

//                        object.wait();

//                    }

//                    System.out.print("A");

//                    count++;

////                    B.signal(); // A执行完唤醒B线程

//                    object.notifyAll();

//                }

//

//            } catch (InterruptedException e) {

//                e.printStackTrace();

//            } finally {

//                lock.unlock();

//            }

        }

    }



    static class ThreadB extends Thread {



        @Override

        public void run() {



            synchronized (object){

                System.out.println(Thread.currentThread().getName());

                for (int i = 0; i < 10; i++) {

                    while (count%3!=1){

                        object.notifyAll();

                        try {

                            object.wait();

                        } catch (InterruptedException e) {

                            e.printStackTrace();

                        }



                    }

                    System.out.println("B");

                    count++;

                    object.notifyAll();

                    try {

                        object.wait();

                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }

                    //object.notifyAll();

                }

            }

//            try {

//                lock.lock();

//                for (int i = 0; i < 10; i++) {

//                    while (count % 3 != 1)

//                        object.wait();

//                    //B.await();// B释放lock锁，当前面A线程执行后会通过B.signal()唤醒该线程

//                    System.out.print("B");

//                    count++;

//                    object.notifyAll();

//                    // C.signal();// B执行完唤醒C线程

//                }

//            } catch (InterruptedException e) {

//                e.printStackTrace();

//            } finally {

//                lock.unlock();

//            }

        }

    }



    static class ThreadC extends Thread {



        @Override

        public void run() {



            synchronized (object){

                System.out.println(Thread.currentThread().getName());

                for (int i = 0; i < 10; i++) {

                    while (count%3!=2){

                        object.notifyAll();

                        try {

                            object.wait();

                        } catch (InterruptedException e) {

                            e.printStackTrace();

                        }



                    }

                    System.out.println("C");

                    count++;

                    object.notifyAll();

                    try {

                        object.wait();

                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }



                }

            }

//            try {

//                lock.lock();

//                for (int i = 0; i < 10; i++) {

//                    while (count % 3 != 2)

//                        object.wait();

//                    //C.await();// C释放lock锁

//                    System.out.print("C");

//                    count++;

//                    object.notifyAll();

//                    // A.signal();// C执行完唤醒A线程

//                }

//            } catch (InterruptedException e) {

//                e.printStackTrace();

//            } finally {

//                lock.unlock();

//            }

        }

    }



    public static void main(String[] args) throws InterruptedException {

        new ThreadA().start();

        new ThreadB().start();

        new ThreadC().start();







    }



}
