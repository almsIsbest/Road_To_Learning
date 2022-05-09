package com.thor.io.tcp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @ClassName TcpServer
 * @Description tcp服务器基类
 * @Author alms
 * @Data 2022/4/29 15:08
 **/
public abstract  class TcpServer <D extends ByteToMessageDecoder,H extends ChannelInboundHandlerAdapter> {
    private EventLoopGroup bossGroup = null;
    private EventLoopGroup workerGroup = null;

    public boolean start(String host ,int port ,boolean openLog){
        try {
            stop();

            boolean epoll = Epoll.isAvailable();
            int bonds = epoll ? Runtime.getRuntime().availableProcessors() : 1;
            this.bossGroup = epoll ? new EpollEventLoopGroup(1) : new NioEventLoopGroup(1);
            this.workerGroup = epoll ? new EpollEventLoopGroup() : new NioEventLoopGroup();
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup,workerGroup)
                    .channel(epoll ? EpollServerSocketChannel.class: NioServerSocketChannel.class)
                    .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .option(ChannelOption.SO_REUSEADDR, true)
                    .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            if(openLog){
                bootstrap.handler(new LoggingHandler(LogLevel.INFO));
            }

            if (epoll) {
                //epoll环境下重用端口
                bootstrap.option(EpollChannelOption.SO_REUSEPORT, true);
            }

            bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast(createDecoder());
                    pipeline.addLast(createHandler());
                }
            });
            for (int i = 0; i < bonds; i++) {
                try {
                    if(host == null) {
                        bootstrap.bind(port).await();
                    }else{
                        bootstrap.bind(host,port).await();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 创建解析器
     * @return 各自的解析器
     */
    public abstract D createDecoder();

    public abstract H createHandler();

    public void stop() {
        if (this.bossGroup != null) {
            bossGroup.shutdownGracefully();
        }
        if (this.workerGroup != null) {
            workerGroup.shutdownGracefully();
        }
    }
}
