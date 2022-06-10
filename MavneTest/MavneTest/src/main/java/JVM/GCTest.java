package JVM;

import java.util.ArrayList;
import java.util.List;

public class GCTest {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new ArrayList<>();
        while (true) {
            list.add(Integer.MAX_VALUE);
        }
    }
}
