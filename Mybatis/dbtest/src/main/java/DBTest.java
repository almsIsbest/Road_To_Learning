import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName dbtest
 * @Description TODO
 * @Author alms
 * @Data 2022/3/4 15:48
 **/
public class DBTest {
    private static DruidDataSource ddsGame = null;// 游戏库连接池

    private static String select = "select * from tennis_user_role  ";

    private static String updateRole = "UPDATE tennis_user_role SET total_play_count =LEAST((SELECT VALUE FROM  tennis_user_record WHERE user_id= ? AND TYPE=5),?) , total_win_count = LEAST((SELECT VALUE FROM  tennis_user_record WHERE user_id= ? AND TYPE=6),? ) WHERE user_id = ? AND role_id = ? ";

    public static int id;
    public static String email;
    public static String name;


    public static void main(String[] args) throws Exception {
        DbPool();
        CsvReaderInit.init();
        var userRoles = CsvReaderInit.getUserRoles();
        Collections.sort(userRoles);

        System.out.println("userRoleSize = " + userRoles.size());

        if (ddsGame.getConnection() != null) {
            System.out.println("data base connection success");
        }

        try (Connection conn = ddsGame.getConnection()) {
            int index = 0 ;
            while (index<userRoles.size()) {
                UserRole userRole = userRoles.get(index);
                if (userRole == null) {
                    break;
                }
                System.out.println(userRole);
                PreparedStatement ps = conn.prepareStatement(updateRole);
                ps.setInt(1, userRole.getUserId());
                ps.setInt(2, userRole.getAll_game());
                ps.setInt(3, userRole.getUserId());
                ps.setInt(4, userRole.getSuccess());
                ps.setInt(5, userRole.getUserId());
                ps.setInt(6, userRole.getRoleId());
                int rs= ps.executeUpdate();
                if(rs>0){
                    System.out.println("success user_id  "+ userRole.getUserId()+ " role_id"+ userRole.getRoleId());
                }else {
                    System.out.println("failed user_id   "+ userRole.getUserId()+" role_id"+ userRole.getRoleId());
                }
                ps.close();
                index++;
            }
//            while (rs.next()){
//                UserRole ur= new UserRole();
//                ur.setUserId(rs.getInt("user_id"));
//                ur.setRoleId(rs.getInt("role_id"));
//                ur.setAll_game(rs.getInt("total_play_count"));
//                ur.setSuccess(rs.getInt("total_win_count"));
//                System.out.println(ur.toString());
//            }


            //System.out.println("id " + id + "email " + email + "name " + name);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void DbPool() {
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            Document doc = saxBuilder.build(new File("configs/dbpool.xml"));
            Element root = doc.getRootElement();
            List<Element> poollist = root.getChildren("pool");
            for (var poolElement : poollist) {
                String name = poolElement.getAttributeValue("name");
                if (name.equals("game")) {
                    ddsGame = (DruidDataSource) DruidDataSourceFactory.createDataSource(getPropertiesMap(poolElement));
                    ddsGame.setName("game");
                }
            }

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    private static HashMap<String, String> getPropertiesMap(Element element) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        List<Element> list = element.getChildren("property");
        for (Element propertyElement : list) {
            map.put(propertyElement.getAttributeValue("name"), propertyElement.getAttributeValue("value"));
        }
        return map;
    }
}
