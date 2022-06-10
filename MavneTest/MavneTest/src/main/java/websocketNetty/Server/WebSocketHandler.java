package websocketNetty.Server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.WebSocketFrame;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebSocketHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        if (msg instanceof BinaryWebSocketFrame) {
            handleHttpRequest(ctx, (BinaryWebSocketFrame)msg);
        } else if (msg instanceof TextWebSocketFrame) {
            System.out.println(((TextWebSocketFrame) msg).text().length());
            ctx.writeAndFlush(new TextWebSocketFrame("123get:" + ((TextWebSocketFrame) msg).text()));

        } else {
            System.err.println("error type");
            System.out.println(msg.getClass());
        }
    }



    private void handleHttpRequest(ChannelHandlerContext ctx, BinaryWebSocketFrame msg) {

        ByteBuf byteBuf = msg.content();
        System.out.println("get");
        System.out.println(byteBuf.getInt(0));
        ctx.writeAndFlush(new TextWebSocketFrame("123"));
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof WebSocketServerProtocolHandler.HandshakeComplete) {
            var header = ((WebSocketServerProtocolHandler.HandshakeComplete)evt).requestHeaders();
            log.info("Handshake has completed");
            log.info("header is {}",header);
        }
        super.userEventTriggered(ctx, evt);
    }
}
