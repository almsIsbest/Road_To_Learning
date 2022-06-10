package reflect;

public class Aman {
    private String name;
    private int age;
    private boolean sex;

    public Aman() {

    }

    public Aman(boolean b) {
        System.out.println("public boolean");
    }

    private Aman(String name) {
        System.out.println("private name");
    }

    private Aman(int age) {
        System.out.println("private age");
    }

    public Aman(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Aman{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
