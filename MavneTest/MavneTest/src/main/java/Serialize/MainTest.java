package Serialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.HashMap;

public class MainTest {

    public static void main(String[] args) {

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("2");
        list2.add("3");
        list2.add("4");

        ArrayList<Apps> list3 = new ArrayList<>();
        list3.add(new Apps(12, 23));
        list3.add(new Apps(23, 34));
        ArrayList<Apps> list4 = new ArrayList<>();
        list4.add(new Apps(12, 23));
        list4.add(new Apps(34, 45));
        Mobile m1 = new Mobile("motu", 123, list1, list4);
        Mobile m2 = new Mobile("nokia", 234, list1, list3);
        Mobile m3 = new Mobile("sony", 123, list1, list3);
        ArrayList<Mobile> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        HashMap<Integer, Mobile> hashMap = new HashMap<>();
        hashMap.put(1, m1);
        hashMap.put(2, m2);
        hashMap.put(3, m3);
        String s = JSON.toJSONString(hashMap);
        System.out.println(s);
        HashMap<Integer, Mobile> newHashmap = JSON.parseObject(s, new TypeReference<>() {
        });
        System.out.println(newHashmap);

    }
}
