package Sort;

interface MyInterface {
    void test();
}

public class OutAndIn {
    public int num = 5;

    public void display(int temp) {
        class Inner implements MyInterface{

            @Override
            public void test() {

            }
        }
    }

    public static void main(String[] args) {
        OutAndIn outAndIn = new OutAndIn();
        outAndIn.display(3);
    }
}
