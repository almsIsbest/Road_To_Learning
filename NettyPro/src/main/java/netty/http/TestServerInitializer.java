package netty.http;

import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @ClassName TestServerInitializer
 * @Description TODO
 * @Author TestServerInitializer
 * @Data 2021/11/1 18:28
 **/
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //向管道加入加入处理器
        //得到管道
        ChannelPipeline pipeline = ch.pipeline();

        //1.加入一个netty提供的httpServerCodec codec=》【coder -decoder】
        pipeline.addLast("MyHttpServerCodec",new HttpServerCodec());

        //2.加入一个自己的处理器
        pipeline.addLast("MyTestHttpServerHandler",new TestHttpServerHandler());
    }
}
