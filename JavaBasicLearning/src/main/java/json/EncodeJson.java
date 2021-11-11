package json;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName EncodeJson
 * @Description TODO
 * @Author EncodeJson
 * @Data 2021/11/11 10:09
 **/
public class EncodeJson {
    public static void main(String[] args) {
        Group group=new Group();
        group.setId(0L);
        group.setName("admin");

        User guestUser=new User();
        guestUser.setId(2L);
        guestUser.setName("guest");

        User root=new User();
        root.setId(3L);
        root.setName("root");

        group.addUser(guestUser);
        group.addUser(root);

        String jsonString= JSON.toJSONString(group);
        System.out.println("jsonString"+jsonString);

        Group group1=JSON.parseObject(jsonString,Group.class);

        System.out.println(group1);
    }
}
