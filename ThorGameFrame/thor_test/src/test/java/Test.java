import sun.misc.Unsafe;

import java.util.Spliterator;

/**
 * @ClassName Test
 * @Description ϵͳ��С�˶�д����
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
            //��Ŵ�long�������ݣ�ʵ�ʴ��ռ8���ֽڣ�01,02,03��04,05,06,07,08
            //ͨ��getByte������ȡ�ղŴ�ŵ�long��ȡ��һ���ֽ�
            //����Ǵ�ˣ�long����˳���š���01,02,03,04,05,06,07,08  ��ȡ��һλ����0x01
            //�����С�ˣ�long����˳���š���08,07,06,05,04,03,02,01  ��ȡ��һλ����0x08
            switch (b){
                case 0x01:
                    System.out.println("���");
                    break;
                case 0x08:
                    System.out.println("С��");
                    break;
                default:
                    assert false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
