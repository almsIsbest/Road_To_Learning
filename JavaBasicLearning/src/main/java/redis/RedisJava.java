package redis;

import java.util.Scanner;

/**
 * @ClassName RedisJava
 * @Description TODO
 * @Author alms
 * @Data 2022/3/18 21:24
 **/
public class RedisJava {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Please enter a string");
        while (scanner.hasNext()){
            RedisPool.getJedis().set("name",scanner.next());
            System.out.println(RedisPool.getJedis().get("name"));
        }


    }
}
