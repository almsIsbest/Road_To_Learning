import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetnSet {
    public GetnSet(int age, String name, boolean isMarried, boolean sex) {
        this.age = age;
        this.name = name;
        this.isMarried = isMarried;
        this.sex = sex;
    }

    int age;
    String name;
    boolean isMarried;
    boolean sex;

}
