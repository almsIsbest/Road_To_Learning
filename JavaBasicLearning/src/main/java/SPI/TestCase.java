package SPI;

import java.sql.DriverManager;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @ClassName TestCase
 * @Description TODO
 * @Author alms
 * @Data 2022/3/16 18:44
 **/
public class TestCase {
    public static void main(String[] args) {
        ServiceLoader<Search> s=ServiceLoader.load(Search.class);
        Iterator<Search> iterator=s.iterator();
        while (iterator.hasNext()) {
            Search search = iterator.next();
            search.searchDoc("hello world");
        }

    }
}
