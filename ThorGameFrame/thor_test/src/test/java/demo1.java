import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import jdk.jfr.Unsigned;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * @ClassName demo1
 * @Description TODO
 * @Author alms
 * @Data 2022/5/9 15:04
 **/
public class demo1 {

    private static final int writeInt = 345;
    /**��С�˲���**/
    @Test
    public void test1(){
        ByteBuf buf = Unpooled.buffer(4,4);
        buf.writeInt(345);
        byte[] arr = new byte[4];
        buf.readBytes(arr);
        /**��˻���С�˶�**/
        System.out.println(Arrays.toString(arr));
        byte a = (byte) 0x345;
        System.out.println(Integer.toHexString(-1));
        System.out.println("int ת�� byte");
        byte[] b =intToByte4(writeInt);
        for(int i = 0 ;i<b.length;i++){
            System.out.println(b[i]);
        }
        System.out.println("long ת�� byte");
        b=longToByte8(345);
        for(int i = 0 ;i<b.length;i++){
            System.out.println(b[i]);
        }


        System.out.println("unsigned short ת�� byte");
        b = unsignedShortToByte2(345);
        for(int i = 0 ;i<b.length;i++){
            System.out.println(b[i]);
        }
    }
    /** int����ת����4�ֽڵ�byte����**/
    public static byte[] intToByte4(int i) {
        byte[] targets = new byte[4];
        targets[3] = (byte) (i & 0xFF);
        targets[2] = (byte) (i >> 8 & 0xFF);
        targets[1] = (byte) (i >> 16 & 0xFF);
        targets[0] = (byte) (i >> 24 & 0xFF);
        return targets;
    }

    /**long����ת����8�ֽڵ�byte����**/
    public static byte[] longToByte8(long lo){
        byte[] target = new byte[8];
        for(int i=0;i<8 ;i++){
            int offset = (target.length -1 -i) * 8;
            target[i] =(byte) ((lo>>offset)&0xFF);
        }
        return target;
    }

    public static byte[] unsignedShortToByte2(int s){
        byte[] target = new byte[2];
        target[0] = (byte) (s>>8 & 0xFF);
        target[1] = (byte) (s & 0xFF);
        return target;
    }
    /**
     * byte����ת��Ϊ�޷���short����
     *
     * @param bytes
     *            byte����
     * @return short����
     */
    public static int byte2ToUnsignedShort(byte[] bytes){
        return byte2ToUnsignedShort(bytes, 0);
    }

    /**
     * byte����ת��Ϊ�޷���short����
     *
     * @param bytes
     *            byte����
     * @param off
     *            ��ʼλ��
     * @return short����
     */
    public static int byte2ToUnsignedShort(byte[] bytes, int off) {
        int high = bytes[off];
        int low = bytes[off + 1];
        return (high << 8 & 0xFF00) | (low & 0xFF);
    }

    /**
     * byte����ת��Ϊint����
     *
     * @param bytes
     *            byte����
     * @param off
     *            ��ʼλ��
     * @return int����
     */
    public static int byte4ToInt(byte[] bytes, int off) {
        int b0 = bytes[off] & 0xFF;
        int b1 = bytes[off + 1] & 0xFF;
        int b2 = bytes[off + 2] & 0xFF;
        int b3 = bytes[off + 3] & 0xFF;
        return (b0 << 24) | (b1 << 16) | (b2 << 8) | b3;
    }

    @Test
    public void test2() throws IOException {
        int x = -32769 ;
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("dos.txt"));
        dos.writeInt(x);
        byte h = (byte) ((x>>>8) & 0xFF);
        System.out.println(Byte.toString(h));
        byte[] b = intToByte4(x);
        System.out.println(b[0]);
        System.out.println(Integer.toBinaryString(x));
//        DataInputStream dis = new DataInputStream(new FileInputStream("dos.txt"));
//
//        int s = dis.readUnsignedShort();
//        System.out.println(s);
//        System.out.println();
    }
}
