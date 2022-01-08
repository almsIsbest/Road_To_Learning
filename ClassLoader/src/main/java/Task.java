import java.io.File;
import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName Task
 * @Description TODO
 * @Author Task
 * @Data 2021/12/31 15:15
 **/
public class Task extends TimerTask {
    static String basePath = "D:\\Github-alms\\Road_To_Learning\\ClassLoader\\target\\classes";
    static File  files=new File(basePath);
    static File[] fs=files.listFiles();
    @Override
    public void run() {
        for(File file: fs){
            String filename=file.getName();
            if(filename.equals("HotswapClassLoader")){
                continue;
            }
            HotswapClassLoader cl = new HotswapClassLoader(
                    basePath, new String[]{filename.substring(0,filename.lastIndexOf("."))});

            try {
                // 通过我们自己实现的类加载器加载 Foo 类
                Class cls = cl.loadClass(filename.substring(0,filename.lastIndexOf(".")), true);
                if (cl.getName().equals("HotswapClassLoader")){
                    continue;
                }
                Object foo = cls.newInstance();
                Method[] methods= cls.getMethods();
                for(Method method:methods){
                    if(method.getName().equals("sayHello")){
                        method.invoke(foo, new Object[]{});
                    }
                }
//            Class clss=cll.loadClass("Footwo",true);
//            Object footwo=clss.newInstance();
//            Method method1=clss.getMethod("sayHello",new Class[]{});
//            method1.invoke(footwo,new Object[]{});

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new Task(), 0, 1000);
    }
}
