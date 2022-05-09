package com.thor.game.io.server;

import com.thor.io.AbstractPacketDecoder;
import io.netty.channel.Channel;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * @ClassName GamePacketDecoder
 * @Description TODO
 * @Author alms
 * @Data 2022/4/29 17:06
 **/
public class GamePacketDecoder extends AbstractPacketDecoder {

    @Override
    public void invalidPacketSize(Channel channel) {

    }

    @Override
    public int maxPacketSize(int packetId) {
        return 0;
    }
}
