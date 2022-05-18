package com.thor.io.packet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;

/**
 * @ClassName ReadPacket
 * @Description {@link WritePacket }, ���Ǿ�����ͬ�ĸ�ʽ��һ��ֻ�ܶ���һ��ֻ��д
 * @Author alms
 * @Data 2022/5/18 10:56
 **/
public abstract class ReadPacket {
    private final int id ;
    private final ByteBuf readBuf;

    /**
     * 	�����յ�Э���channel,�ܹ�ֱ�ӽ��з��͵Ⱥ�channel��صĴ���
     */
    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }


    public ReadPacket(int id, ByteBuf readBuf) {
        this.id = id;
        this.readBuf = readBuf;
    }

    public int id() {
        return this.id;
    }

    public int readableBytes() {
        return this.readBuf.readableBytes();
    }

    public abstract void process() throws Exception;

    public final int readInt() {
        return this.readBuf.readIntLE();
    }

    public final int readUnsignedShort() {
        return this.readBuf.readUnsignedShortLE();
    }
}
