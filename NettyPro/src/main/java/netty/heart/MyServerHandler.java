package netty.heart;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * @ClassName MyServerHandler
 * @Description TODO
 * @Author MyServerHandler
 * @Data 2021/11/10 14:44
 **/
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * @Author alms
     * @Description
     * @Date 14:47 2021/11/10
     * @Param [ctx, evt]  evt 事件
     * @return void
     **/
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        if(evt instanceof IdleStateHandler){

            IdleStateEvent event=(IdleStateEvent) evt;
            String eventype="";
            switch (event.state()){
                case READER_IDLE:
                    eventype="读空闲";
                    break;
                case WRITER_IDLE:
                    eventype="写空闲";
                    break;
                case ALL_IDLE:
                    eventype="读写空闲";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress()+eventype);
            System.out.println("服务器做相应处理");
        }
    }
}
