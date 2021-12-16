package netty.httpdowland;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedNioFile;
import io.netty.util.CharsetUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName HttpRequesthandler
 * @Description 请求的处理
 * @Author HttpRequesthandler
 * @Data 2021/12/14 11:54
 **/
public class HttpRequesthandler extends SimpleChannelInboundHandler<FullHttpRequest> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        //状态为1**的话，继续请求
        if (HttpUtil.is100ContinueExpected(request)) {
            ctx.writeAndFlush(new DefaultFullHttpResponse(
                    HttpVersion.HTTP_1_1, HttpResponseStatus.CONTINUE
            ));
        }

        if (!request.decoderResult().isSuccess()) {

            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST,
                    Unpooled.copiedBuffer("请求失败", CharsetUtil.UTF_8));

            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain;charset=UTF-8");
            ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
        }

        //这里设置了只允许GET请求
        if (request.method() != HttpMethod.GET) {

            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.FORBIDDEN);

            ByteBuf byteBuf = Unpooled.copiedBuffer("只允许GET请求", CharsetUtil.UTF_8);
            response.content().writeBytes(byteBuf);
            byteBuf.release();

            HttpUtil.setContentLength(response, response.content().readableBytes());
            ctx.channel().writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
        }


        //获取uri
        String uri = request.uri();
        //获取静态文件路径
        String path = String.valueOf(this.getClass().getResource("/static/")).replace("file:/", "") + "test.html";            //获取当前classPath


        File file = new File(path);

        //设置不支持favicon.ico文件
        if ("/favicon.ico".equals(uri)) {

            return;
        }

        //文件没有 设置为404
        if (!file.exists()) {

            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NOT_FOUND,
                    Unpooled.copiedBuffer("访问路径错误", CharsetUtil.UTF_8));

            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain;charset=UTF-8");
            ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
        }

        HttpResponse response = new DefaultFullHttpResponse(request.protocolVersion(), HttpResponseStatus.OK);

        //设置文件格式内容
        if (path.endsWith(".html")) {
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html;charset=ISO-8859-1");
        } else if (path.endsWith(".css")) {
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/css;charset=UTF-8");
        } else if (path.endsWith(".js")) {
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "application/x-javascript");
        }

        if (HttpUtil.isKeepAlive(request)) {
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, file.length());
            response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
        }
        ctx.write(response);

        RandomAccessFile ra = new RandomAccessFile(file, "r");

        System.out.println(ra);

        ctx.write(new DefaultFileRegion(ra.getChannel(), 0, ra.length()));


        ChannelFuture channelFuture = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);

        channelFuture.addListener(ChannelFutureListener.CLOSE);

    }
}
