package netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @ClassName NettyServerHandler
 * @Description 1.我们自定义一个handler需要继续 规定好的某个HandlerAdapter
 * 2这时我们自己定义一个handler，才能称为一个handler
 * @Author NettyServerHandler
 * @Data 2021/11/1 13:16
 **/
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    //读取数据实际（这里我们可以读取客户端发送的消息）
    /*
     * @Author alms
     * @Description
     * 1.ChannelHandlerContext ctx:上下文对象，含有 管道pipeline，通道channel，地址
     * 2.object msg：就是客户端发送的数据
     * @Date 13:20 2021/11/1
     * @Param [ctx, msg]
     * @return void
     **/
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server ctx =" +ctx);
        //将msg转成一个ByteBuffer
        //Bytebuf是Netty提供的，不是NIO的bytebuffer
        ByteBuf buf=(ByteBuf) msg;
        System.out.println("客户端发送消息是："+buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址"+ctx.channel().remoteAddress());
    }

    //数据读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        //将数据写入到缓冲，并刷新
        //一般讲，我们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端",CharsetUtil.UTF_8));
    }

    //处理异常，一般是需要关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
