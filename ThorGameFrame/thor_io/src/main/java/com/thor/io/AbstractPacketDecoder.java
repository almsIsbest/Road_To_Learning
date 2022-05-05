package com.thor.io;

import com.thor.utils.CommConStance;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @ClassName AbstractPacketDecoder
 * @Description Э�������
 * @Author alms
 * @Data 2022/4/29 17:08
 **/
public class AbstractPacketDecoder extends ByteToMessageDecoder {

    /**
     * @Author alms
     * @Description Э�����������Э���ʽ
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

        //���ݰ����Ȳ���
        if (dataLength < CommConStance.PACKET_HEADER_LENGTH) {

        }
    }
}
