package reflect;

public class Apple extends Fruit {
    @Override
    public void show() {
        System.out.println("new show");
    }

    public void test() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        Apple apple = (Apple) new Fruit();
        apple.test();
    }
}
