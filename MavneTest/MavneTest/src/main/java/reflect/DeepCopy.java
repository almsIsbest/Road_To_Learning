package reflect;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public class DeepCopy {


    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchFieldException, NoSuchMethodException {

//        Field f = Unsafe.class.getDeclaredField("theUnsafe");
//        f.setAccessible(true);
//        Unsafe unsafe = (Unsafe) f.get(null);
//        Method m = Unsafe.class.getDeclaredMethod("compareAndSetObject", Object.class, long.class, Object.class,
//                Object.class);
//        System.out.println(m.getModifiers());
        Method m = StrictMath.class.getDeclaredMethod("sin", double.class);
        System.out.println(Modifier.toString(m.getModifiers()));
        Aman aman = new Aman();
        aman.setName("name");
        aman.setAge(123);
        aman.setSex(true);
        System.out.println(aman.getClass().getClassLoader());
        System.out.println(aman.getClass().getClassLoader().getParent());
        System.out.println(aman.getClass().getClassLoader().getParent().getParent());
        Field[] fields = aman.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
           // System.out.println(unsafe.objectFieldOffset(field));
        }
        Method[] methods = aman.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 2);
        hashMap.put(2, 3);

        HashMap<Integer, Integer> copyMap = new HashMap<>();


        //unsafe.copyMemory(hashMap,);
    }

    public static <T> T parseCsv(CopyTypeReference<T> typeReference, Object o) {
        System.out.println(typeReference.type);

        return null;
    }

}
