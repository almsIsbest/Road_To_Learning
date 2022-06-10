package JSON;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;

public class ToString {


    int id;
    String name;

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        System.out.println(JSON.toJSONString(hashMap, SerializerFeature.WriteNonStringKeyAsString));
        int a = 1 > 0 ? 2 : 23;
    }
}
