package JSON;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class JsonTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        ArrayList<Integer>arrayList = new ArrayList<Integer>();
//        ArrayList<Integer> arrayList1 = new ArrayList<>() {
//        };
//        System.out.println(arrayList.getClass());
//        System.out.println(arrayList1.getClass());
//        ArrayList<Integer> list = new ArrayList<>();
//        System.out.println(list.getClass().toString());
//
//
//        System.out.println(list.getClass().getName());
//        System.out.println(list.getClass().getModule());
//        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
//        System.out.println(list.getClass().getSuperclass());
//        System.out.println(list.getClass().getGenericSuperclass());
//        System.out.println(Arrays.toString(list.getClass().getInterfaces()));
//        System.out.println(Arrays.toString(list.getClass().getGenericInterfaces()));
//        System.out.println(list.getClass().getClassLoader());
//        ArrayList<Integer> list1 = (ArrayList<Integer>) object;
        Object object = new ArrayList<Integer>();
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.toString());
        }
//        object.add(123);
        Method method = object.getClass().getMethod("add", Object.class);
        method.invoke(object, 2);
        Method getMethod = object.getClass().getMethod("get", int.class);
        System.out.println(getMethod.invoke(object, 0));

//        String s = " {\"herf\":\"213\",\"mailType\":\"1\",\"route\":\"/test/mailManager12\",\"forward\":\"提交\"," +
//                "\"ip\":\"1.202.246.19\",\"operationType\":\"1\",\"title\":\"123\",\"accessory\":\"[[\\\"2\\\",\\\"23\\\"],[\\\"3\\\",\\\"2323\\\"]]\",\"operation\":\"mailManager12\",\"operatorName\":\"root\",\"content\":\"22\"}\n";
//        HashMap<String, String> hashMap;
//        System.out.println(s);
//        hashMap = JSON.parseObject(s, new TypeReference<>() {
//        });
//        System.out.println(hashMap);
//        String ss = hashMap.get("accessory");
//        System.out.println(ss);
//        ArrayList<ArrayList<String>> list = JSON.parseObject(ss, new TypeReference<>() {
//        });
//        System.out.println(list);
//        int a = 1;
//        System.out.println(list.get(a));
//        System.out.println(hashMap.getClass().getGenericSuperclass().getTypeName());
    }
}
