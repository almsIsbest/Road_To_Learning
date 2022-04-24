/**
 * @ClassName UserRole
 * @Description TODO
 * @Author alms
 * @Data 2022/3/29 16:26
 **/
public class UserRole implements Comparable<UserRole> {
    private int userId;
    private int roleId;
    private int success;
    private int all_game;

    public  UserRole (){

    }

    public UserRole(int userId, int roleId, int success, int all_game) {
        this.userId = userId;
        this.roleId = roleId;
        this.success = success;
        this.all_game = all_game;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getAll_game() {
        return all_game;
    }

    public void setAll_game(int all_game) {
        this.all_game = all_game;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                ", success=" + success +
                ", all_game=" + all_game +
                '}';
    }

    @Override
    public int compareTo(UserRole o) {
        if(this.userId==o.userId){
            return this.roleId - o.roleId;
        }else {
            return this.userId - o.userId;
        }
    }
}
