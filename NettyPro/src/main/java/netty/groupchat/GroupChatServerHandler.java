package netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;

/**
 * @ClassName GroupChatServerHandler
 * @Description TODO
 * @Author GroupChatServerHandler
 * @Data 2021/11/8 9:07
 **/
public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {


   //定义一个channel组
    //GlobalEventExecutor.INSTANCE 是全局的事件执行器，是一个单例
    private static ChannelGroup channelGroup=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf=new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //handlerAdded 表示连接建立，一旦连接，第一个被执行
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush("客户端进入聊天"+channel.remoteAddress()+"\n");
        channelGroup.add(channel);
    }

    //表示channel处于活动上线
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"上线了");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"离线了"
        );
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        channelGroup.writeAndFlush("客户单"+ctx.channel().remoteAddress()+"离开了\n");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
            Channel channel=ctx.channel();

            channelGroup.forEach(ch -> {
                if(ch!=channel){
                    ch.writeAndFlush("客户"+channel.remoteAddress()+msg);
                }else {
                    ch.writeAndFlush("自己说的"+msg);
                }
            });
    }
}
