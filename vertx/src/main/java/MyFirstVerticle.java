import io.vertx.core.AbstractVerticle;

/**
 * @ClassName MyFirstVerticle
 * @Description TODO
 * @Author MyFirstVerticle
 * @Data 2021/12/9 11:20
 **/
public class MyFirstVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        vertx.createHttpServer().requestHandler(req->{
            req.response().putHeader("content-type", "text/plain")
                    .end("Hello World!");
        }).listen(8080);
    }
}
