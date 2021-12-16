package netty.httpdowland;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;

/**
 * @ClassName HttpServer
 * @Description TODO
 * @Author HttpServer
 * @Data 2021/12/14 11:43
 **/
public class HttpServer {
    int port;

    public HttpServer(int port) {
        this.port = port;
    }

    public void start(){
        ServerBootstrap bootstrap = new ServerBootstrap();
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup work = new NioEventLoopGroup();
        bootstrap.group(boss,work)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .option(ChannelOption.SO_BACKLOG,512)
                .channel(NioServerSocketChannel.class)
                .childHandler(new HttpServerInitializer());

        try {
            ChannelFuture future = bootstrap.bind(new InetSocketAddress(port)).sync();
            System.out.println(" server start up on port : " + port);
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }
}
