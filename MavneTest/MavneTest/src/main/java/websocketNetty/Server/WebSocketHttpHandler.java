package websocketNetty.Server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;

import javax.crypto.MacSpi;

public class WebSocketHttpHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);

        if(msg instanceof FullHttpRequest){
            var request = (FullHttpRequest)msg;
            System.out.println(request.headers());
        }
    }
}
