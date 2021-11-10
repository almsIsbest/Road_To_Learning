package netty.heart;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName MyServer
 * @Description 心跳检测
 * @Author MyServer
 * @Data 2021/11/10 14:26
 **/
public class MyServer {

    public static void main(String[] args) throws Exception{

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap=new ServerBootstrap();

            bootstrap.group(bossGroup,workGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline=ch.pipeline();
                            //处理空闲状态的处理器
                            //readerIdleTime,表示多长时间没有读了，就会发送一个心跳检测是否连接
                            // long writerIdleTime,  表示多长时间没有写了，就会发送一个心跳检测是否连接
                            // long allIdleTime, 表示多长时间没有读写了，就会发送一个心跳检测是否连接
                            //当IdleStateHandler触发后，就会传递给管道的下一个handler去处理通过调用触发下一个handler的userEventTiggered
                            pipeline.addLast(new IdleStateHandler(3,5,7, TimeUnit.SECONDS));
                            //加入自定义处理空间进一步处理的handler
                            pipeline.addLast(new MyServerHandler());
                        }
                    });
            ChannelFuture future=bootstrap.bind(7777).sync();
            future.channel().closeFuture().sync();

        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }
}
