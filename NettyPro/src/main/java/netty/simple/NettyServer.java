package netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.Future;

/**
 * @ClassName NettyServer
 * @Description TODO
 * @Author NettyServer
 * @Data 2021/11/1 12:09
 **/
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {

        //创建bossGroup和workGroup
        //1.创建两个线程组bossGroup和workGroup
        //2.bossGroup只是处理连接请求，workGrou是真正和客户端交互的业务处理
        //3.两个都是无限循环
        //4.bossGroup和workGroup 线程数默认是核数成2
        EventLoopGroup bossGroup=new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {

            //创建服务器的启动对象，配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();

            //使用链式编程来进行配置
            bootstrap.group(bossGroup, workGroup)//设置两个线程组
                    .channel(NioServerSocketChannel.class)//使用niosocketchannel作为服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG, 128)//线程队列得到连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true)//设置保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {//创建一个通道测试对象
                        //给pipeline设置处理器
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyServerHandler());

                        }
                    });//给我们的workGroup的eventloop对应的管道设置处理器

            System.out.println("-----服务器准备好");

            //绑定一个端口并且同步，生成一个channelFuture对象
            ChannelFuture cf = bootstrap.bind(6668).sync();

            //对关闭通道进行进行监听
            cf.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }
}
