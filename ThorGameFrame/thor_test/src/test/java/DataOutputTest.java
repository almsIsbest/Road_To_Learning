import java.io.*;

/**
 * @ClassName DataoutputTest
 * @Description TODO
 * @Author alms
 * @Data 2022/5/10 11:37
 **/
public class DataOutputTest {
    public static void main(String[] args) throws IOException {

        DataInputStream in = new DataInputStream(new FileInputStream("ThorGameFrame/thor_test/test.txt"));
        DataOutputStream out = new DataOutputStream(new  FileOutputStream("test1.txt"));
        BufferedReader d  = new BufferedReader(new InputStreamReader(in));

        String count;
        while((count = d.readLine()) != null){
            String u = count.toUpperCase();
            System.out.println(u);
            out.writeBytes(u + "  ,");
        }
        d.close();
        out.close();
    }
}
