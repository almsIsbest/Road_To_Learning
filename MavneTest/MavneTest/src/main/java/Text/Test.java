package Text;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println("max");
        ExecutorService e = Executors.newCachedThreadPool();
        for (int i = 0; i < 100000; i++) {
            e.execute(runnable);
        }
        e.shutdown();
    }
}
