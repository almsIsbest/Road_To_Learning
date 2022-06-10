package Thread;

class Service {
    private boolean isContinueRun = true;
    private String string = "123";
    private Object object=new Object();
    private int a =0;
     public void runMethod() {
        while (isContinueRun) {
            System.out.println(a++);
        }
        System.out.println("stop");
    }

    public void stopMethod() {
        isContinueRun = false;
    }
}

public class Sync {
    static boolean flag =false;
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        new Thread(() -> {
//            service.runMethod();
            flag=true;
        }).start();
        new Thread(() -> {
//            service.stopMethod();
            System.out.println(flag);
        }).start();
//        thread2.start();
//        thread1.start();
        System.out.println("start stop");
    }
}
