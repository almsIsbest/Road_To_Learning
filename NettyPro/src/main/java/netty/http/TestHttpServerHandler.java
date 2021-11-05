package netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 * @ClassName TestHttpServerHandler
 * @Description
 * 1.SimpleChannelInboundHandler 是ChannelInboundHandlerAdapter子类
 * 2.httpobject 客户端和服务器相互通讯的数据被封装成httpObject
 * @Author TestHttpServerHandler
 * @Data 2021/11/1 18:27
 **/

public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    //读取客户端数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

        //判断msg是不是httprequest请求
        if (msg instanceof HttpRequest){

            System.out.println("pipeline hashcode "+ctx.pipeline().hashCode()+"TestHttpServerHandler hash="+this.hashCode());
            //获取到httpRequest
            HttpRequest httpRequest=(HttpRequest) msg;
            //获取uri
            URI uri = new URI(httpRequest.uri());

            if("/favicon.ico".equals(uri.getPath())){
                System.out.println("请求了 favicon.ico,不做响应");
                return;
            }

            System.out.println("msg 类型="+msg.getClass());
            System.out.println("客户端地址" +ctx.channel().remoteAddress());

            //回复信息给浏览器【http协议】

            ByteBuf content = Unpooled.copiedBuffer("hello,我是服务器",CharsetUtil.UTF_8);

            //构造一个http响应 ，即httpresponse
          FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                    HttpResponseStatus.OK, content);

          response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
          response.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());

          //将构建好的response
            ctx.writeAndFlush(response);

        }
    }
}
