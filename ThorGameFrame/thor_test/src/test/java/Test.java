import sun.misc.Unsafe;

import java.util.Spliterator;

/**
 * @ClassName Test
 * @Description 系统大小端读写测试
 * @Author alms
 * @Data 2022/5/9 17:35
 **/
public class Test {
    public static void main(String[] args) {
        Unsafe unsafe = UnsafeInstance.reflectGetUnsafe();
        long a = unsafe.allocateMemory(8);
        try {
            unsafe.putLong(a ,0x0102030405060708L);
            byte b = unsafe.getByte(a);
            //存放此long类型数据，实际存放占8个字节，01,02,03，04,05,06,07,08
            //通过getByte方法获取刚才存放的long，取第一个字节
            //如果是大端，long类型顺序存放—》01,02,03,04,05,06,07,08  ，取第一位便是0x01
            //如果是小端，long类型顺序存放—》08,07,06,05,04,03,02,01  ，取第一位便是0x08
            switch (b){
                case 0x01:
                    System.out.println("大端");
                    break;
                case 0x08:
                    System.out.println("小端");
                    break;
                default:
                    assert false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
