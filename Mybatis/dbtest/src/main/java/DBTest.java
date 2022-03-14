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

    private static  String select="select * from user where id =13  ";

    public static int id;
    public static String email;
    public static String name;


    public static void main(String[] args) throws SQLException {
        DbPool();
        if(ddsGame.getConnection()!=null){
            System.out.println("data base connection success");
        }
        try ( Connection conn= ddsGame.getConnection()){
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
                email = rs.getString(2);
                name = rs.getString(3);
                System.out.println("id "+id+"email "+ email +"name "+ name);
            }
            rs.close();
            ps.close();

            System.out.println("id "+id+"email "+ email +"name "+ name);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void DbPool(){
        SAXBuilder saxBuilder=new SAXBuilder();
        try {
            Document doc = saxBuilder.build(new File("configs/dbpool.xml"));
            Element root=doc.getRootElement();
            List<Element> poollist=root.getChildren("pool");
            for(var poolElement:poollist){
                String name=poolElement.getAttributeValue("name");
                if(name.equals("game")){
                ddsGame=(DruidDataSource) DruidDataSourceFactory.createDataSource(getPropertiesMap(poolElement));
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
