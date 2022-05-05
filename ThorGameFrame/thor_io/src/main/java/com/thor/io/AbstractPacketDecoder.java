package com.thor.io;

import com.thor.utils.CommConStance;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @ClassName AbstractPacketDecoder
 * @Description 协议解析器
 * @Author alms
 * @Data 2022/4/29 17:08
 **/
public class AbstractPacketDecoder extends ByteToMessageDecoder {

    /**
     * @Author alms
     * @Description 协议解析方法，协议格式
     * @Date 17:09 2022/4/29
     * @Param [ctx, in, out]
     * @return void
     **/
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if(in.readableBytes() < CommConStance.PACKET_HEADER_LENGTH){
            return;
        }

        in.markReaderIndex();
        int dataLength = in.readIntLE();

        //数据包长度不对
        if (dataLength < CommConStance.PACKET_HEADER_LENGTH) {

        }
    }
}
