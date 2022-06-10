package factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FactoryMain {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        List<Date> list1 = new ArrayList<>();
        list.add(create(1));
        list.add(create(2));

        for (Object o : list) {
            IFactroy iFactroy = (IFactroy) o;
            iFactroy.run();
        }
        for (int i = 1; ; i++) {
            Date date = new Date();
            list1.add(date);
        }
    }

    static IFactroy create(int i) {
        if (i == 1) {
            return new FactoryImpl1();
        } else {
            return new FactoryImpl2();
        }
    }
}

class FactoryImpl1 extends IFactroy {
    @Override
    void run() {
        System.out.println("factoryImpl1");
    }
}

class FactoryImpl2 extends IFactroy {
    @Override
    void run() {
        System.out.println("factoryImpl2");
    }
}