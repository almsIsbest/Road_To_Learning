package netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName Myserver
 * @Description TODO
 * @Author Myserver
 * @Data 2021/11/9 8:46
 **/
public class Myserver {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossgroup =new NioEventLoopGroup(1);
        EventLoopGroup workgroup = new NioEventLoopGroup();

        try{
            ServerBootstrap serverBootstrap=new ServerBootstrap();

            serverBootstrap.group(bossgroup,workgroup);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.handler(new LoggingHandler(LogLevel.INFO));
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline= ch.pipeline();

                    //因为基于http协议，使用http的编码和解码器
                    pipeline.addLast(new HttpServerCodec());

                    //是以块方式写，添加ChunkerWriterHandler处理器

                    pipeline.addLast(new ChunkedWriteHandler());

                    /*
                     * @Author alms
                     * @Description Http数据在传输过程是分段，HttpObjectAggregator，就是可以将多个段聚合
                     * 这就是为什么，当浏览器发送大量数据是，就会发出多次请求
                     * 这就是为什么，当浏览器发送大量数据是，就会发出多次请求
                     * @Date 8:58 2021/11/9
                     * @Param [ch]
                     * @return void
                     **/
                    pipeline.addLast(new HttpObjectAggregator(8192));

                    /*
                     * @Author alms
                     * @Description
                     * 1.对应的websocket，他的数据是以帧（frame）形式传播
                     * 2.可以看到WebSocketFrame 下面有六个子类
                     * 3.浏览器请求时ws://localhost:7000/hello 表示请求的url
                     * 4.WebSocketServerProtocolHandler 核心功能协议升级为ws协议，并保持长连接
                     * @Date 9:01 2021/11/9
                     * @Param [ch]
                     * @return void
                     **/

                    pipeline.addLast(new WebSocketServerProtocolHandler("/hello"));

                    //自定义的handler，处理业务逻辑
                    pipeline.addLast(new MyTextWebsSocketFrameHandler());
                }
            });
            ChannelFuture sync = serverBootstrap.bind(7000).sync();
            sync.channel().closeFuture().sync();
        }finally {
            bossgroup.shutdownGracefully();
            workgroup.shutdownGracefully();
        }

    }
}
