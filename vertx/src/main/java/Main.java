import io.vertx.core.Vertx;

/**
 * @ClassName Main
 * @Description TODO
 * @Author Main
 * @Data 2021/12/9 11:19
 **/
public class Main {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new MyFirstVerticle());
    }
}
