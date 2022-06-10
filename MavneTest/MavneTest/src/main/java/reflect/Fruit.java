package reflect;

public class Fruit {


    protected Fruit(){
        System.out.println(getClass().getGenericSuperclass());
    }








    public void show(){
        System.out.println("show");
    }
}
