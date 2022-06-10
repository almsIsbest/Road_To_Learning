package JVM;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(StaticTest.a);
        StaticTest.a=222222222;

        Thread.sleep(5000);
        System.out.println(StaticTest.a);
    }
}
