package netty.httpdowland;

/**
 * @ClassName Application
 * @Description TODO
 * @Author Application
 * @Data 2021/12/14 12:08
 **/
public class Application {
    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer(8081);
        httpServer.start();
    }
}
