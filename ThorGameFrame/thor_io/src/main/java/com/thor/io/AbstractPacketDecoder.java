package com.thor.io;

import com.thor.utils.CommConStance;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @ClassName AbstractPacketDecoder
 * @Description Э�������
 * @Author alms
 * @Data 2022/4/29 17:08
 **/
public abstract class AbstractPacketDecoder extends ByteToMessageDecoder {

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
        if (dataLength < CommConStance.PACKET_ID_LENGTH) {
            invalidPacketSize(ctx.channel());
            return;
        }

        int packetId = in.readUnsignedShortLE();
        if(dataLength > maxPacketSize(packetId)){
            invalidPacketSize(ctx.channel());
            return;
        }

        if(in.readableBytes() < dataLength - 2){
            in.resetReaderIndex();
            return;
        }

        ByteBuf readBuf = PooledByteBufAllocator.DEFAULT.buffer(dataLength-2);
    }

    /**
     * @Author alms
     * @Description �����С���Եİ�
     * @Date 14:16 2022/5/9
     * @Param [channel] ����Channel
     * @return void
     **/
    public abstract void invalidPacketSize(Channel channel);

    /**
     * ��������
     * @param packetId Э��id
     * @return �����峤��
     */
    public abstract int maxPacketSize(int packetId);
}
