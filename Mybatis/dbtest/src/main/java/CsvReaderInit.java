import com.csvreader.CsvReader;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName CsvReaderInit
 * @Description TODO
 * @Author alms
 * @Data 2022/3/29 15:36
 **/
public class CsvReaderInit {
    private static ArrayList<UserRole> userRoles= new ArrayList<>();
    public static void init () throws Exception{
        userRoles.clear();
        File file = new File("configs/test_role_player_count.csv");
        InputStream inputStream = new FileInputStream(file);
        List<String[]> list = read(inputStream,"GBK");
        for (var str:
             list) {
            userRoles.add(new UserRole(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2]),Integer.parseInt(str[3])));
        }
    }

    public static List<String[]> read(InputStream inputStream, String code) throws Exception{
        //1. 存储csv文件中的内容
        List<String[]> csvList = new ArrayList<String[]>();

        //2. 创建CsvReader
        CsvReader reader = new CsvReader(inputStream, ',', Charset.forName(code));

        //3. 跳过表头,如果需要表头的话，不要写这句
        reader.readHeaders();

        //4.逐行读入除表头的数据
        while(reader.readRecord()){
            csvList.add(reader.getValues());
        }

        //5. 释放资源
        reader.close();
        return csvList;
    }

    public static ArrayList<UserRole> getUserRoles() {
        return userRoles;
    }

    public static void setUserRoles(ArrayList<UserRole> userRoles) {
        CsvReaderInit.userRoles = userRoles;
    }
}
