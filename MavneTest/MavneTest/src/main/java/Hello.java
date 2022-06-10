import java.util.ArrayList;

public class Hello {

    public void test() {
        int i = 8;
        while ((i -= 3) > 0) {
            System.out.println("i = " + i);
        }
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        Hello hello1 = new Hello();
        ArrayList<Hello> list = new ArrayList<>();
        list.add(hello);
        list.add(hello1);
        for (Hello hello2 : list) {

        }

    }
}
