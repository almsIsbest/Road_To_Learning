package com.thor.io;

import com.thor.io.packet.ReadPacket;
import com.thor.utils.CommConStance;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @ClassName AbstractPacketDecoder
 * @Description Э�������
 * @Author alms
 * @Data 2022/4/29 17:08
 **/
@Slf4j
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
        log.info("decoding");
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
        in.readBytes(readBuf);

        ReadPacket mp = createPacket(packetId,readBuf);
        if(mp != null){
            out.add(mp);
        }else {
            readBuf.release();
            notExistPacket(ctx.channel(), packetId);
        }
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

    /**
     * ������Ŀ��Ҫ�İ�,ÿ����Ŀ���ܲ�ͬ,���Ƕ��̳���{@link ReadPacket}
     * @param id Э��id
     * @param readBuf ����
     * @return ����Э��
     */
    public abstract ReadPacket createPacket(int id, ByteBuf readBuf);


    /**
     * ����δ����İ�
     * @param channel channel
     * @param id Э��id
     */
    public abstract void notExistPacket(Channel channel, int id);
}
