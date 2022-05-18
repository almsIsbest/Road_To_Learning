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
 * @Description 协议解析器
 * @Author alms
 * @Data 2022/4/29 17:08
 **/
@Slf4j
public abstract class AbstractPacketDecoder extends ByteToMessageDecoder {

    /**
     * @Author alms
     * @Description 协议解析方法，协议格式
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

        //数据包长度不对
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
     * @Description 处理大小不对的包
     * @Date 14:16 2022/5/9
     * @Param [channel] 连接Channel
     * @return void
     **/
    public abstract void invalidPacketSize(Channel channel);

    /**
     * 最大包长度
     * @param packetId 协议id
     * @return 最大包体长度
     */
    public abstract int maxPacketSize(int packetId);

    /**
     * 生成项目需要的包,每个项目可能不同,但是都继承于{@link ReadPacket}
     * @param id 协议id
     * @param readBuf 包体
     * @return 具体协议
     */
    public abstract ReadPacket createPacket(int id, ByteBuf readBuf);


    /**
     * 处理未定义的包
     * @param channel channel
     * @param id 协议id
     */
    public abstract void notExistPacket(Channel channel, int id);
}
