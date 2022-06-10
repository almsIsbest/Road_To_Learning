package lambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerMain {
    public static void useConsumer(Supplier<String>supplier){
        supplier.get();
    }

}
