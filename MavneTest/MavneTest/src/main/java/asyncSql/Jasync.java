package asyncSql;

import com.github.jasync.sql.db.Configuration;
import com.github.jasync.sql.db.Connection;
import com.github.jasync.sql.db.ConnectionPoolConfiguration;
import com.github.jasync.sql.db.RowData;
import com.github.jasync.sql.db.mysql.pool.MySQLConnectionFactory;
import com.github.jasync.sql.db.pool.ConnectionPool;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class Jasync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ConnectionPoolConfiguration poolConfiguration = new ConnectionPoolConfiguration(
                "cdb-jpp9dqkf.usw.cdb.myqcloud.com",
                23055,
                "fishing",
                "game"
        );

        Connection connection = new ConnectionPool<>(
                new MySQLConnectionFactory(new Configuration(
                        "game",
                        "cdb-jpp9dqkf.usw.cdb.myqcloud.com",
                        23055,
                        "Pxh130529disc-123",
                        "fishing"
                )), poolConfiguration);
        connection.connect().get();
        connection.sendPreparedStatement("select * from fishing_user").whenComplete((result, throwable) -> {
            System.out.println(result.getRowsAffected());

            for (RowData row : result.getRows()) {
                System.out.println(Arrays.toString(row.toArray()));
            }
        });

        System.out.println("????");
    }
}
