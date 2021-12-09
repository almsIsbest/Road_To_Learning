package ThreadLearning;

/**
 * @ClassName ThreadExchange
 * @Description 三个线程轮流打印字符a,b,c
 * @Author ThreadExchange
 * @Data 2021/12/8 16:21
 **/
public class ThreadExchange implements Runnable{
    public String name;
    public Object prev;
    public Object self;

    public ThreadExchange(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count=10;
        while (count>0){
            synchronized (prev){
                synchronized (self){
                    System.out.println(name);
                    count--;
                    self.notifyAll();
                }
                try {
                    if(count==0){
                        prev.notifyAll();
                    }else {
                        prev.wait();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a=new Object();
        Object b=new Object();
        Object c=new Object();
        Object d=new Object();

        ThreadExchange threadA=new ThreadExchange("A",d,a);
        ThreadExchange threadB=new ThreadExchange("B",a,b);

        ThreadExchange threadC=new ThreadExchange("C",b,c);
        ThreadExchange threadD=new ThreadExchange("D",c,d);

        new Thread(threadA).start();
        new Thread(threadB).start();
        new Thread(threadC).start();

        new Thread(threadD).start();

    }
}
