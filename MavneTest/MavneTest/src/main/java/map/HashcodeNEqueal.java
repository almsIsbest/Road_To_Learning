package map;

import io.netty.util.internal.ResourcesUtil;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;

public class HashcodeNEqueal {
    static class ExceptionA extends Exception{

    }
    static class ExceptionB extends ExceptionA{

        public ExceptionB(String ssss) {
            super();
        }
    }

    public static void main(String[] args) {
        try {
            throw new ExceptionB("ssss");
        } catch (Exception exceptionA){
            System.out.println("exception A");
        }

        HashSet<Hero> set = new HashSet<>();
        Hero hero1 = new Hero(1, "123");
        Hero hero2 = new Hero(2, "321");
        Hero hero3 = new Hero(1, "321123");
        set.add(hero1);
        set.add(hero2);
        set.add(hero3);
        for (Hero hero : set) {
            System.out.println(hero);
        }


    }
}
