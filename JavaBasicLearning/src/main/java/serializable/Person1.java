package serializable;

import java.io.*;

/**
 * @ClassName Person1
 * @Description TODO
 * @Author Person1
 * @Data 2021/11/11 20:35
 **/
public class Person1 extends People implements Serializable {

    private static final long serialVersionUID=1l;

    String name;
    int age;

    public Person1(int num ,String name,int age){
        super(num);
        this.name=name;
        this.age=age;
    }

    public String toString(){
        return super.toString()+"\tname:"+name+"\tage:"+age;
    }

    public static void main(String[] args) throws IOException {

        File file=new File("out1.txt");

        FileOutputStream outputStream=null;
        try{
            outputStream=new FileOutputStream(file);
            ObjectOutputStream oos=new ObjectOutputStream(outputStream);
            try {
                Person1 person = new Person1(10, "tom", 22); //调用带参数的构造函数num=10,name = "tim",age =22
                System.out.println(person);
                oos.writeObject(person);                  //写出对象
                oos.flush();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    oos.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
                outputStream.close();
        }


        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(fis);
                try {
                    Person1 person1 = (Person1)ois.readObject();	//读出对象
                    System.out.println(person1);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    ois.close();
                } catch (IOException e) {
                    System.out.println("ois关闭失败："+e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("找不到文件："+e.getMessage());
        } finally{
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println("fis关闭失败："+e.getMessage());
            }
        }
    }
}
