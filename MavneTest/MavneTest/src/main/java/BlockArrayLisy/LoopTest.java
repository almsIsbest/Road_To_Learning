package BlockArrayLisy;

public class LoopTest {

    public static void main(String[] args) {

        first:
        {
            for (int i = 0; i < 10; i++) {
                for (int i1 = 0; i1 < 10; i1++) {
                    int c = i * i1;
                    System.out.println(c);
                    if (c == 18) {
                        break first;
                    }
                }
            }
        }

    }
}
