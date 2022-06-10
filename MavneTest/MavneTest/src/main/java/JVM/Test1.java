package JVM;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(StaticTest.a);
        StaticTest.a=111111;
        Thread.sleep(2000);
        System.out.println(StaticTest.a);
    }
}
