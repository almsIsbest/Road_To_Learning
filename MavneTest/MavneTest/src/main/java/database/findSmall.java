package database;

import java.sql.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.IntToDoubleFunction;

public class findSmall {

    public static final String FIND ="select user_id from pool_user where facebook_id in (?)";
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ExecutionException, InterruptedException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://cdb-5rliz1wf.usw.cdb.myqcloud.com:18111/pool?serverTimezone=UTC", "game", "Pool-Sandbox-Game");

        PreparedStatement preparedStatement = conn.prepareStatement(FIND);
        Array array = preparedStatement.getConnection().createArrayOf("VARCHAR",new Object[]{"205787707612377",
                "772034790189387","973311373194664"});
        preparedStatement.setArray(1,array);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("user_id"));

        }


    }
}
