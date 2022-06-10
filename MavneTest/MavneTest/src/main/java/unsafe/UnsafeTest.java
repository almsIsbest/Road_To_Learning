package unsafe;

import io.netty.channel.Channel;
import reflect.Aman;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class UnsafeTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        Aman aman = new Aman("123",123,true);
//        System.out.println(unsafe.objectFieldOffset(aman.getClass().getDeclaredField("name")));
//        System.out.println(unsafe.objectFieldOffset(aman.getClass().getDeclaredField("age")));
//        System.out.println(unsafe.objectFieldOffset(aman.getClass().getDeclaredField("sex")));
        long address = unsafe.allocateMemory(8L);
        System.out.println(address);
        unsafe.setMemory(address,8L, (byte) 1);
        System.out.println(unsafe.getInt(address));
        unsafe.putInt(address,0x7fffffff);
        System.out.println(unsafe.getInt(address));
        unsafe.putInt(address+4,0x00000000);
        System.out.println(unsafe.getInt(address+4));
    }
}
