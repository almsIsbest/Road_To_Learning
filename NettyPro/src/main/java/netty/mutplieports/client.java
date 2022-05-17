package netty.mutplieports;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.net.InetSocketAddress;

/**
 * @ClassName client
 * @Description TODO
 * @Author alms
 * @Data 2022/5/17 11:42
 **/
public class client {
    private EventLoopGroup eventLoopGroup =new NioEventLoopGroup();
    private Bootstrap bootstrap = new Bootstrap();
    private int startPort ;
    private int endPort;
    private String serverHost;
    private ChannelFuture[] channelFutures = null;

    public client(int startPort, int endPort, String serverHost) {
        this.startPort = startPort;
        this.endPort = endPort;
        this.serverHost = serverHost;
    }

    public static void main(String[] args) throws Exception {
        client client = new client(6000, 8000, "127.0.0.1");
        client.start();
    }



    public void start() throws Exception {
        bootstrap.group(eventLoopGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_REUSEADDR, true);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) {
                ch.pipeline().addLast(new ClientHandler());
            }
        });

        if (channelFutures == null) {
            channelFutures = new ChannelFuture[endPort - startPort + 1];
        }

        //同时连接多个端口
        for (int i = startPort; i <= endPort; i++) {
            ChannelFuture channelFuture = bootstrap.connect(new InetSocketAddress(serverHost,i));
            int port = i;
            channelFutures[i - startPort] = channelFuture;
            channelFuture.addListener(new GenericFutureListener<Future<? super Void>>() {
                @Override
                public void operationComplete(Future<? super Void> future) throws Exception {
                    if (future.isSuccess()) {
                        System.out.println("connect success port : " + port);
                    } else {
                        System.out.println("connect failed port : " + port);
                    }
                }
            });
            Channel channel = channelFuture.channel();
            channel.closeFuture().addListener(new GenericFutureListener<Future<? super Void>>() {
                @Override
                public void operationComplete(Future<? super Void> future) throws Exception {
                    channel.close();
                }
            });
        }
    }


    public void stop(){
        eventLoopGroup.shutdownGracefully();
        System.out.println("stop");
    }


    public void closeChannel(int port) {
        int i = port - startPort;
        if (0 <= i && i <= channelFutures.length) {
            if (channelFutures != null) {
                channelFutures[i].channel().close();
            }
            System.out.println("stoped " + port);
        }

    }

}
