package workDemo;

import com.sun.jdi.ArrayReference;
import org.junit.Test;
import schedule.Scheduledemo;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Test02
 * @Description TODO
 * @Author alms
 * @Data 2022/4/2 14:33
 **/
public class Test02 {
    private Integer tmp ;
    private HashMap<Integer,Test02>  hashMap =new HashMap<>();


    @Test
    public void Test1(){
        ArrayList<Integer> list =new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(3);

        for ( var i:
             list) {
            System.out.println(i);
        }
        ArrayList<Integer> list1 = list ;
        Collections.sort(list1);

        System.out.println("list");
        for ( var i:
                list) {
            System.out.println(i);
        }

        System.out.println("list1");
        for ( var i:
                list1) {
            System.out.println(i);
        }
    }


    @Test
    public void Test02(){
        Integer i = 1;
        LinkedList<Integer> list= new LinkedList<>();

        if(i.equals(1)){
            System.out.println("success");
        }
    }

    @Test
    public void Test(){
        Test02 test02 = new Test02();

        System.out.println(test02.tmp!=null);
    }

    @Test
    public void Test2(){
        HashMap<Integer, ArrayList<Integer>> integerArrayListHashMap = new HashMap<Integer, ArrayList<Integer>>();

        ArrayList<Integer> list = new ArrayList<>(){{add(1);add(2);add(3);}};

        integerArrayListHashMap.put(1,list);
    }

    @Test
    public void Test3(){
        HashMap<Integer,Integer> tmp =new HashMap<>();
        tmp.get(null);
    }

    @Test
    public void Test4(){
        byte[] bytes =new byte[10];

        System.out.println(bytes[0]);
    }

    @Test
    public void Test5(){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
    }


    @Test
    public void test2() {
        List<Order> utilList = new ArrayList<>();  //备用List
        for (int i = 10; i < 13; i++) {
            Order order = new Order();
            order.setId(i);  //id值为10,11,12
            utilList.add(order);
        }

        List<Order> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Order order = new Order();
            order.setId(i);  //id值为0,1,2
            list.add(order);
            order = utilList.get(i);  //添加到list后，修改引用，指向备用List的元素
            System.out.println("order"+order.getId());
            System.out.println("list "+i+":"+list.get(i).getId());
        }
        for (int i = 0; i < list.size(); i++) {
            Order order = list.get(i);
            System.out.println(i + ":" + order.getId());
        }
    }


    @Test
    public void test6(){
//        HashMap<Integer,Integer> map = new HashMap<>();
//        map.put(1,1);
//        map.put(2,2);
//
//        ArrayList<Integer> list = new ArrayList<>();
//        list.addAll(map.keySet());
//        list.forEach(integer -> {
//            System.out.println(integer);
//        });
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.addAll(list);
//        System.out.println("清空数据");
//        list2.clear();
//        list.forEach(integer -> {
//            System.out.println(integer);
//        });
//
//        System.out.println("清空完成");
        Map<String, Integer> map = new TreeMap<>();
        map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3);
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        // apple, orange, pear

        HashMap<Integer,ArrayList<Integer>> map1 =new HashMap<>();
        map1.put(1,new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        map1.put(2,new ArrayList<>(Arrays.asList(2,3,4,5,6,7)));

        ArrayList<Integer> list = new ArrayList<>();

        list.addAll(map1.get(1));
        list.addAll(map1.get(2));

        list.forEach(k->{
            System.out.println(k);
        });

        ArrayList<Integer> list2 = new ArrayList<>(map1.get(1));

    }

    @Test
    public void test07(){
        int i = 0;
        outer:
        for(;true;){
            inner:
            for(;i<10;i++){
                prt("i = "+i);
                if(i==2){
                    prt("continue");
                    continue ;
                }
                if(i == 3){
                    prt("break");
                    i++;
                    break ;
                }
                if(i == 7){
                    prt("continue outer");
                    i++;
                    continue outer;
                }

                if(i == 8){
                    prt("break outer");
                    break outer;
                }

                for(int k = 0;k<5;k++){
                    if(k == 3){
                        prt("continue inner");
                        continue inner;
                    }
                }
            }

        }
    }

    @Test
    public void test8(){
       float w = (float)((32395-32388)/32395)* (float)0.5;
        System.out.printf("%f",w);
    }

    public void prt(String s){
        System.out.println(s);
    }
}
