package urlClass;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @ClassName ClassLoader
 * @Description TODO
 * @Author ClassLoader
 * @Data 2022/1/5 10:35
 **/
public class ClassLoader {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        File file=new File("d:/");
        URI uri=file.toURI();
        URL url = uri.toURL();

        URLClassLoader classLoader=new URLClassLoader(new URL[]{url});
        System.out.println("父类加载器："+classLoader.getParent());

        Class clazz=classLoader.loadClass("urlClass.ClassLoader");
        System.out.println(classLoader.getClass());
        System.out.println(clazz.getDeclaredConstructor().newInstance());

    }
}
