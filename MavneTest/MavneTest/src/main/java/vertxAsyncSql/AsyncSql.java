package vertxAsyncSql;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.sqlclient.*;
import io.vertx.mysqlclient.MySQLConnectOptions;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class AsyncSql extends AbstractVerticle {
    long now = System.currentTimeMillis();
    public static void main(String[] args) {
        MySQLConnectOptions options = new MySQLConnectOptions()
                .setPort(23055)
                .setHost("cdb-jpp9dqkf.usw.cdb.myqcloud.com")
                .setDatabase("fishing")
                .setUser("game")
                .setPassword("Pxh130529disc-123");
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new AsyncSql(options));
    }
    private final SqlConnectOptions options;

    public AsyncSql(SqlConnectOptions options) {
        this.options = options;
    }

    @Override
    public void start() throws Exception {
        int core = Runtime.getRuntime().availableProcessors();
        var executor = new ThreadPoolExecutor(core, core, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        var executor2 = new ThreadPoolExecutor(core, core, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        AtomicInteger counter = new AtomicInteger();
        int max = 100;
        Pool pool = Pool.pool(vertx,options,new PoolOptions().setMaxSize(core));
        for (int i = 0; i < max; i++) {
            final int index = i+1;
            pool.query("select * from fishing_user").execute().onSuccess(rows -> {
                for (Row row : rows) {
//                    System.out.println(row.toJson());
                }
                int count = counter.addAndGet(1);

                System.out.println("execute"+index+" cost time is "+(System.currentTimeMillis() - now));

                if(count == max){
                    System.out.println("cost time is "+(System.currentTimeMillis() - now));
                }
            }).onFailure(Throwable::printStackTrace);
        }
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        executor2.execute(()->System.err.println("qwewqeqwe"));
    }
}
