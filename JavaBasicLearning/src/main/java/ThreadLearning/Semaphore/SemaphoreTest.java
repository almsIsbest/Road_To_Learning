package ThreadLearning.Semaphore;


import java.util.concurrent.Semaphore;

/**
 * @ClassName Semaphoretest
 * @Description Semaphore信号量
 * @Author Semaphoretest
 * @Data 2022/1/13 15:26
 **/
public class SemaphoreTest {
    public static void main(String[] args) {
    FooBar fooBar=new FooBar(5);
        Runnable foo=new Runnable() {
            @Override
            public void run() {
                System.out.println("foo");
            }
        };
        Runnable bar=new Runnable() {
            @Override
            public void run() {
                System.out.println("bar");
            }
        };

        new Thread(()-> {
            try {
                fooBar.foo(foo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                fooBar.bar(bar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
class FooBar {
    private int n;

    private Semaphore fooSema = new Semaphore(1);
    private Semaphore barSema = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooSema.acquire();//值为1的时候，能拿到，执行下面的操作
            printFoo.run();
            barSema.release();//释放许可给barSema这个信号量 barSema 的值+1
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barSema.acquire();//值为1的时候，能拿到，执行下面的操作
            printBar.run();
            fooSema.release();//释放许可给fooSema这个信号量 fooSema 的值+1
        }
    }
}
