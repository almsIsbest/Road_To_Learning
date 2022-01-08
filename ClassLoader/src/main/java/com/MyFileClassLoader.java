package com;



import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName MyFileClassLoader
 * @Description TODO
 * @Author MyFileClassLoader
 * @Data 2022/1/5 11:29
 **/
public class MyFileClassLoader extends ClassLoader {
    private String directory;//被加载类所在目录
    public MyFileClassLoader(String directory){
        this.directory=directory;
    }

    public MyFileClassLoader(String directory,ClassLoader parent){
        super(parent);
        this.directory=directory;
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //把类名转换成目录
        String file=directory+ File.separator+name.replace(".",File.separator)+".class";
        byte[] data=null;
        //构建输入流
        try {
            InputStream in=new FileInputStream(file);
            //构建字节输出流
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            byte[] buf=new byte[1024];
            int len=-1;
            while ((len=in.read(buf))!=-1){
                baos.write(buf,0,len);
            }
            data=baos.toByteArray();
            in.close();
            baos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name,data,0,data.length);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        MyFileClassLoader classLoader=new MyFileClassLoader("D:\\Github-alms\\Road_To_Learning\\ClassLoader\\target\\classes");
        Class<?> clazz = classLoader.findClass("com.MyFileClassLoader");
        System.out.println(clazz.getClassLoader());
        Object ob=clazz.getDeclaredConstructor(String.class).newInstance("D:\\Github-alms\\Road_To_Learning\\ClassLoader\\target\\classes");
        System.out.println(ob.getClass().getClassLoader());
    }
}
