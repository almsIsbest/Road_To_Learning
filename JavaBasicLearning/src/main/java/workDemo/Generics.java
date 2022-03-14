package workDemo;

/**
 * @ClassName workDemo.Generics
 * @Description 泛型类
 * @Author alms
 * @Data 2022/2/25 20:55
 **/
public class Generics <T>{
    private T var ;
    public T getVar(){
        return var;
    }

    public void setVar(T var){  // 设置的类型也由外部决定
        this.var = var ;
    }


    public <T> T getObject(Class<T> c) throws InstantiationException,IllegalAccessException{
        T t=c.newInstance();
        return t;
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Generics<String> p=new Generics<>();
        p.setVar("it");
        Object o=p.getObject(Class.forName("java.lang.String"));
        System.out.println(o.hashCode());
        System.out.println(p.getVar());
    }
}
