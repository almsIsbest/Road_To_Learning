package netty.simplehttp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

/**
 * @ClassName HttpRequestHandler
 * @Description TODO
 * @Author HttpRequestHandler
 * @Data 2021/12/14 15:32
 **/
public class HttpRequestHandler extends ChannelInboundHandlerAdapter {

    private static String url;
    private static ByteBuf buf;
    private static File file;
    private static  byte[] bytes;
    private static FileInputStream inputStream;

    static {
        try {
            url = ClassLoader.getSystemResource("static").toString().replace("file:/","") + "/test.html";
            file = new File(url);
            inputStream = new FileInputStream(file);
            bytes = new byte[inputStream.available()];
            buf = PooledByteBufAllocator.DEFAULT.buffer(bytes.length);
            inputStream.read(bytes);
            buf.writeBytes(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        //获取当前classPath
        handleFile(ctx, (FullHttpRequest)msg, file);
    }

    public void handleFile(ChannelHandlerContext ctx, FullHttpRequest msg, File file) throws Exception {
        String uri=msg.uri();
        if(uri.equals("/favicon.ico")){
            return;
        }
        HttpHeaders headers = getContentTypeHeader(file);
        //解决：使用一次buf后计数器减为0
//        buf.retain();
        System.out.println("buf "+ buf.refCnt()+" read index "+buf.readerIndex());
        HttpResponse response = new DefaultFullHttpResponse(msg.protocolVersion(), HttpResponseStatus.OK, buf.retain());

        response.headers().set(headers);
        ctx.write(response);

        ChannelFuture future = ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);

        future.addListener(ChannelFutureListener.CLOSE);
    }

    private HttpHeaders getContentTypeHeader(File file) {
        MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
        HttpHeaders headers = new DefaultHttpHeaders();
        String contentType = mimeTypesMap.getContentType(file);
        if (contentType.equals("text/plain")) {
            //由于文本在浏览器中会显示乱码，此处指定为utf-8编码
            contentType = "text/plain;charset=utf-8";
        }
        headers.set(HttpHeaderNames.CONTENT_TYPE, contentType);
        return headers;
    }

    @Override
    public void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
