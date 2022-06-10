package map;

import java.util.Comparator;
import java.util.Objects;

public class Hero{
    int age;
    String name;

    public Hero(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Hero() {
    }

    static void printr(){
        System.out.println(123);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
    //    @Override
//    public int compare(Hero o1, Hero o2) {
//        return o1.age - o2.age;
//    }

    //    @Override
//    public int compareTo(@NotNull Hero o) {
//        if (this.age > o.age) {
//            return 1;
//        } else {
//            return -1;
//        }
//    }
//}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return age == hero.age;
    }

    @Override
    public int hashCode() {
        return age;
    }

    static void testMethod ()throws RuntimeException{
        System.out.println("fangfa");
    }
}
