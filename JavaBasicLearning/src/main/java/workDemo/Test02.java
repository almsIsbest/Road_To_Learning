package workDemo;

import org.junit.Test;

import java.util.*;

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
}
