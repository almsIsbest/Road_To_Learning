package stringTest;

import java.util.Random;

public class StringBuildTest {
    public static void main(String[] args) {
        byte[] bytes = new byte[31];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i]=(byte) new Random().nextInt(128);
        }
        String s = "qwe";
        System.out.println(s);
        s=s+new String(bytes);
        System.out.println(s);
        s+="123";
        System.out.println(s);
    }
}
