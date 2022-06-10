import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonTest {


    public static void main(String[] args) throws JsonProcessingException {

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "2");
        hashMap.put(2, "2");
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(hashMap);
        System.out.println(s);
        String fastjson = JSON.toJSONString(hashMap, SerializerFeature.WriteNonStringKeyAsString);
        System.out.println(fastjson);


        ArrayList<Integer>list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(JSON.toJSONString(list));

    }
}
