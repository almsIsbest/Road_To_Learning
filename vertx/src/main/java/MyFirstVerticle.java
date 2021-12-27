import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

/**
 * @ClassName MyFirstVerticle
 * @Description TODO
 * @Author MyFirstVerticle
 * @Data 2021/12/9 11:20
 **/
public class MyFirstVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        HttpServer httpServer = vertx.createHttpServer();
        Router router = Router.router(vertx);

        router.route("/index").handler(ctx->{
            HttpServerResponse response = ctx.response();
            response.putHeader("content-type","text/plain");

            response.end("hell world ");
        });

        httpServer.requestHandler(router).listen(8080);

    }
}
