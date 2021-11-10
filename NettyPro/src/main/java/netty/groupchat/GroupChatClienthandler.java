package netty.groupchat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName GroupChatClienthandler
 * @Description TODO
 * @Author GroupChatClienthandler
 * @Data 2021/11/8 9:39
 **/
public class GroupChatClienthandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg.trim());
    }
}
