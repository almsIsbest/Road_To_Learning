package netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @ClassName TestServer
 * @Description TODO
 * @Author TestServer
 * @Data 2021/11/1 18:27
 **/
public class TestServer {
    public static void main(String[] args) throws  Exception{
        EventLoopGroup bossGroup=new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {

            ServerBootstrap bootstrap=new ServerBootstrap();

            bootstrap.group(bossGroup,workGroup).channel(NioServerSocketChannel.class).childHandler(new TestServerInitializer());

            ChannelFuture channelFuture = bootstrap.bind(6668).sync();

            channelFuture.channel().closeFuture().sync();

        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
