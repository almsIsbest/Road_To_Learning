package Func;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Hero {
    int age = 1;

    public static void main(String[] args) {
//        System.out.println(
//                (int) LocalDateTime.of(LocalDateTime.ofEpochSecond((int) (System.currentTimeMillis() / 1000), 0,
//                        ZoneOffset.ofHours(8)).toLocalDate(), LocalTime.MAX).toEpochSecond(ZoneOffset.ofHours(8)));
        long localTime = LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(7));




        System.out.println(localTime);

        System.out.println(
                LocalDateTime.ofEpochSecond(1630403242, 0, ZoneOffset.ofHours(8)).toEpochSecond(ZoneOffset.ofHours(7)));
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
