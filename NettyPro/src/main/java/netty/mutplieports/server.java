package netty.mutplieports;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * @ClassName server
 * @Description TODO
 * @Author alms
 * @Data 2022/5/17 11:21
 **/
public class server {
    private EventLoopGroup bossGroup = new NioEventLoopGroup();
    private EventLoopGroup workGroup = new NioEventLoopGroup();

    private ServerBootstrap bootstrap = new ServerBootstrap();
    private ChannelFuture[] channelFutures = null;
    private int beginPort = 0;
    private int endPort = 0;

    public server(int beginPort, int endPort){
        this.beginPort=beginPort;
        this.endPort = endPort;
    }

    public static void main(String[] args) {
        server server = new server(6000, 8000);
        server.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        server.stopServerChannel(6000);

    }


    public void start(){
        System.out.println("server starting");
        bootstrap.group(bossGroup,workGroup)
                .channel(NioServerSocketChannel.class)
                .childOption(ChannelOption.SO_REUSEADDR,true)
                .childHandler(new ChannelInitializer<>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ch.pipeline().addLast(new CountHandler());
                    }
                });

        if(channelFutures ==null){
            channelFutures = new ChannelFuture[endPort-beginPort+1];
        }

        for(int i= beginPort ;i<=endPort;i++){
            final int port = i;
            ChannelFuture channelFuture = bootstrap.bind(port);
            channelFutures[i-beginPort] = channelFuture;
            channelFuture.addListener(new GenericFutureListener<Future<? super Void>>() {
                @Override
                public void operationComplete(Future<? super Void> future) throws Exception {
                    if (future.isSuccess()) {
                        System.out.println("Started success,port:" + port);
                    } else {
                        System.out.println("Started Failed,port:" + port);
                    }

                }
            });
        }
        for (int i = 0; i <= endPort - beginPort; i++) {
            final Channel channel = channelFutures[i].channel();
            int index = i;
            channel.closeFuture().addListener(new GenericFutureListener<Future<? super Void>>() {
                @Override
                public void operationComplete(Future<? super Void> future) {
                    System.out.println("channel close !");
                    channel.close();
                    channelFutures[index] = null;
                }
            });
        }
    }


    public void stopAll(){
        bossGroup.shutdownGracefully();
        workGroup.shutdownGracefully();
        System.out.println("stoped");
    }

    //关闭单个端口的NioServerSocketChannel
    public void stopServerChannel(int port) {
        int i = port - beginPort;
        if (0 <= i && i <= channelFutures.length) {
            if (channelFutures != null) {
                channelFutures[i].channel().close();
            }
            System.out.println("stoped " + port);
        }
    }

}
