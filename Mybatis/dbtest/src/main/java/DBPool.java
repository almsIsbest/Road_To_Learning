import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

public class DBPool {

	private static DruidDataSource ddsGame = null;// 游戏库连接池
	private static DruidDataSource ddsLog = null;// 日志库连接池
//	private static DruidDataSource ddsGlobalLog = null;//全局日志库连接池

	/**
	 * 中心服数据库的连接信息
	 */
	private static String globalUrl = null;
	private static String globalUser = null;
	private static String globalPwd = null;

	private static boolean isInited;

	static {
		isInited = false;
	}

	@SuppressWarnings("unchecked")
	public synchronized static boolean init(InputStream in) {
		if (isInited) {
			return true;
		}
		try {
			SAXBuilder sb = new SAXBuilder();
			Document doc = sb.build(in);
			Element root = doc.getRootElement();
			List<Element> poolList = root.getChildren("pool");
			for (Element poolElement : poolList) {
				String name = poolElement.getAttributeValue("name");
				if (name.equals("game")) {
					ddsGame = (DruidDataSource) DruidDataSourceFactory.createDataSource(getPropertiesMap(poolElement));
					ddsGame.setName("game");
				} else if (name.equals("log")) {
					ddsLog = (DruidDataSource) DruidDataSourceFactory.createDataSource(getPropertiesMap(poolElement));
					ddsLog.setName("log");
				} else if (name.equals("globalLog")) {
//					 ddsGlobalLog = (DruidDataSource)DruidDataSourceFactory.createDataSource(getPropertiesMap(poolElement)) ;
//					 ddsGlobalLog.setName("globalLog");
				} else if (name.equals("global")) {
					HashMap<String, String> globalMap = getPropertiesMap(poolElement);
					globalUrl = globalMap.get("url");
					globalUser = globalMap.get("username");
					globalPwd = globalMap.get("password");
				}
			}
			isInited = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean init(String fileName) {
		boolean b = false;
		try {
			FileInputStream in = new FileInputStream(fileName);
			b = init(in);
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

//	@SuppressWarnings("unchecked")
//	public static void initGlobalConfigs() {
//		try {
//			SAXBuilder sb = new SAXBuilder();
//			Document doc = sb.build(new File("configs/dbpool.xml"));
//			Element root = doc.getRootElement();
//			List<Element> poolList = root.getChildren("pool");
//			for (Element poolElement : poolList) {
//				String name = poolElement.getAttributeValue("name");
//				if (name.equals("global")) {
//					HashMap<String, String> globalMap = getPropertiesMap(poolElement);
//					globalUrl = globalMap.get("url");
//					globalUser = globalMap.get("username");
//					globalPwd = globalMap.get("password");
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	@SuppressWarnings("unchecked")
	private static HashMap<String, String> getPropertiesMap(Element element) throws Exception {
		HashMap<String, String> map = new HashMap<>();
		List<Element> list = element.getChildren("property");
		for (Element propertyElement : list) {
			map.put(propertyElement.getAttributeValue("name"), propertyElement.getAttributeValue("value"));
		}
		return map;
	}

	/**
	 * 获取一个游戏库的连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return ddsGame.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取一个日志库的连接
	 * 
	 * @return
	 */
	public static Connection getLogConnection() {
		try {
			return ddsLog.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeStatment(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean isInited() {
		return isInited;
	}

	/**
	 * 获取一个到中心服的连接
	 * 
	 * @return
	 */
//	public static Connection getGlobalConnection() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager.getConnection(globalUrl, globalUser, globalPwd);
//			return conn;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	/**
	 * 获取一个到中心服的连接
	 * 
	 * @return
	 */
//	public static Connection getLocalConnection() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager.getConnection(ddsGame.getUrl(), ddsGame.getUsername(),
//					ddsGame.getPassword());
//			return conn;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
}
