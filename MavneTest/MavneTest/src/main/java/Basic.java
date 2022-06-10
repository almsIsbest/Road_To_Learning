import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class Basic {
    public static void test() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextInt() + 1);
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        BigDecimal bigDecimal = new BigDecimal(123.3467);
        HashMap<Integer, BigDecimal> hashMap = new HashMap<>();
        hashMap.put(123, new BigDecimal(2223));
        hashMap.put(234, new BigDecimal("111111111111111111111112.22332222222222222222"));
        System.out.println(JSON.toJSONString(hashMap, SerializerFeature.WriteNonStringKeyAsString));
    }

}
