import sun.misc.Unsafe;

import java.io.File;
import java.lang.reflect.Field;

/**
 * @ClassName UnsafeInstance
 * @Description 系统大小端判断
 * @Author alms
 * @Data 2022/5/9 17:32
 **/
public class UnsafeInstance {
    public static Unsafe reflectGetUnsafe(){
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
