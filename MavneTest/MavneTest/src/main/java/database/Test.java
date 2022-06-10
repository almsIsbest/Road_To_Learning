package database;

import CompleteFutureTest.Stealing;

import java.sql.*;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC", "root", "newworld1.28");
        Statement statement = conn.createStatement();
        //ResultSet resultSet = statement.executeQuery("select * from pool_ai");
        boolean succeed = statement.execute("insert into language values ('212','22','2006-02-15 05:02:33')");
        System.out.println(succeed);
    }
}
