package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName reflectio02
 * @Description 获取类成员变量 getfields（）
 * @Author alms
 * @Data 2022/3/16 10:45
 **/
public class reflection02 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Dog> dog = Dog.class;
        //类名打印
        System.out.println("类名打印");
        System.out.println(dog.getName());
        System.out.println(dog.getSimpleName());
        System.out.println(dog.getCanonicalName());
        //接口
        System.out.println("接口");
        System.out.println(dog.isInterface());
        for(Class iI:dog.getInterfaces()){
            System.out.println(iI);
        }

        //父类
        System.out.println("父类" );
        System.out.println(dog.getSuperclass());

        //创建对象
        System.out.println("创建对象");
        Dog d=dog.getDeclaredConstructor().newInstance();

        System.out.println("属于那个类"+d.getClass());

        //字段
        System.out.println("包括父亲的公共字段");
        for(Field f:dog.getFields()){
            System.out.println(f.getName());
        }

        System.out.println("只有自己类声明的字段包括私有字段" );
        for (Field f:dog.getDeclaredFields()){
            System.out.println(f.getName());
        }
    }
}
class Cell {
    public int mCellPublic;
}

class Animal extends Cell {
    private int mAnimalPrivate;
    protected int mAnimalProtected;
    int mAnimalDefault;
    public int mAnimalPublic;
    private static int sAnimalPrivate;
    protected static int sAnimalProtected;
    static int sAnimalDefault;
    public static int sAnimalPublic;
}

interface I1 {
}
interface I2 {
}

class Dog extends Animal implements I1, I2 {
    private int mDogPrivate;
    public int mDogPublic;
    protected int mDogProtected;
    private int mDogDefault;
    private static int sDogPrivate;
    protected static int sDogProtected;
    static int sDogDefault;
    public static int sDogPublic;
}