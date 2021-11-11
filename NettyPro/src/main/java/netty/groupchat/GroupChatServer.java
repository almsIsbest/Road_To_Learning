package netty.groupchat;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @ClassName GroupChatServer
 * @Description TODO
 * @Author GroupChatServer
 * @Data 2021/11/8 8:54
 **/
public class GroupChatServer {
    private int port;

    public GroupChatServer(int port){
        this.port=port;
    }

    public void run() throws InterruptedException {
        EventLoopGroup bossgroup = new NioEventLoopGroup();
        EventLoopGroup workgroup = new NioEventLoopGroup();
        try {

            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(bossgroup, workgroup).channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast("decode", new StringDecoder());
                            pipeline.addLast("encode", new StringEncoder());
                            pipeline.addLast(new GroupChatServerHandler());
                        }
                    });
            System.out.println("服务器启动");
            ChannelFuture future = bootstrap.bind(port).sync();
            future.channel().closeFuture().sync();
        }finally {
            bossgroup.shutdownGracefully();
            workgroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new GroupChatServer(7000).run();
    }

}
