package function;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.function.*;
import java.util.stream.Stream;

public class SupplierTest {

    static String test(Supplier<String> supplier) {
        return supplier.get();
    }

    static void consumerTest(Consumer<String> consumer) {
        consumer.accept("adsad");
    }

    static boolean predicate(String s, Predicate<String> predicate) {
        return predicate.test(s);
    }

    static String functionTest(Function<Integer, Boolean> function) {
        return String.valueOf(function.apply(102304405));
    }

    public static void main(String[] args) throws FileNotFoundException {

        String s = test(() -> "dsadsad");
        System.out.println(s);
        consumerTest(s1 -> System.out.println(s1.toUpperCase()));
        Consumer<String> consumer = (g) -> System.out.println(g.substring(1, 2));
        Consumer<String> con1 = (g) -> System.out.println(g.substring(2, 3));
        consumer.andThen(con1).accept("1234567");
        System.out.println(functionTest((a) -> {
            return a % 2 == 0;
        }));
        Function<String, Integer> function = String::length;
        Function<Integer, String> function1 = String::valueOf;
        Integer a = function.compose(function1).apply(123123);
        System.out.println(a);
        String string = function.andThen(function1).apply("213");
        System.out.println(string);





    }
}
