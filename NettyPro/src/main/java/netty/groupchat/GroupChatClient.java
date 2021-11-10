package netty.groupchat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @ClassName GroupChatClient
 * @Description TODO
 * @Author GroupChatClient
 * @Data 2021/11/8 9:25
 **/
public class GroupChatClient {

    private final String host;
    private final int port;

    public GroupChatClient(String host,int  port){
        this.host=host;
        this.port=port;
    }

    public void run() throws InterruptedException {

       EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();

        try {


            bootstrap.group(group).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(new StringEncoder());
                            pipeline.addLast(new GroupChatClienthandler());
                        }
                    });
            ChannelFuture future = bootstrap.connect(host,port).sync();

            Channel channel= future.channel();

            System.out.println("------"+future.channel().localAddress()+"--------");

            //客户端需要输入信息

            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNextLine()){
                String msg =scanner.nextLine();

                channel.writeAndFlush(msg+"\r\n");
            }
        }finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new GroupChatClient("127.0.0.1",7777).run();
    }
}
