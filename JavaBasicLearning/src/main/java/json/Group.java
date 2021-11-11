package json;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Group
 * @Description TODO
 * @Author Group
 * @Data 2021/11/11 10:08
 **/
public class Group {
    private long id;
    private String name;
    private List<User> users=new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user){
        users.add(user);
    }
}
