package Thread;

public class NativeDebug {
    public static void main(String[] args) {
        Thread thread1 = new Thread();
        Thread.currentThread().interrupt();
    }
}
