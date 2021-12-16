package netty.httpdowland;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @ClassName HttpServerInitializer
 * @Description TODO
 * @Author HttpServerInitializer
 * @Data 2021/12/14 11:49
 **/
public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());//http 编解码
        pipeline.addLast("httpAggregator",new HttpObjectAggregator(65536));
        pipeline.addLast(new HttpRequesthandler());
    }
}
