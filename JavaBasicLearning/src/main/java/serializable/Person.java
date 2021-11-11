package serializable;

import java.io.*;

/**
 * @ClassName Person
 * @Description TODO
 * @Author Person
 * @Data 2021/11/11 11:17
 **/
public class Person implements Serializable {
    private static final long seriaVersionUID=1L; //

    String name;
    int age;

    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        File file=new File("file"+File.separator+"out.txt");

        FileOutputStream fos=null;
        try{
            fos=new FileOutputStream(file);
            ObjectOutputStream oos=null;
            try{
                oos=new ObjectOutputStream(fos);
                Person person = new Person("tom", 22);
                System.out.println(person);
                oos.writeObject(person);			//写入对象
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    oos.close();
                } catch (IOException e) {
                    System.out.println("oos关闭失败");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("找不到文件："+e.getMessage());
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                System.out.println("fos关闭失败"+e.getMessage());
            }
        }
    }
}
