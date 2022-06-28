package generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName son
 * @Description
 * @Author alms
 * @Data 2022/6/23 15:54
 **/
public class son extends father<String,Integer>{

    public static ArrayList<son> list = new ArrayList<>();
    public static HashMap<Integer,son> map = new HashMap<>();


    public son(String name,Integer id) {
        super(name,id);
    }

    static <T extends Comparable<T>> T max(T x ,T y ,T c){
        T max =x ;
        if(y.compareTo(max)>0){
            max = y;
        }
        if (c.compareTo(max)>0){
            max = c;
        }
        return max;
    }

    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {

        var l1= new son("alms",2);
        list.add(l1);
        map.put(l1.getId(),l1);
        var l2= new son("aaaa",3);
        list.add(l2);
        map.put(l2.getId(),l2);
        System.out.println(map.get(2).getName());
        map.get(2).setName("hhhh");
        System.out.println(list.get(0).getName());
    }

}
