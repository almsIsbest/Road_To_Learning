package com.thor.game.io.server;

import com.thor.io.AbstractPacketDecoder;
import com.thor.io.packet.ReadPacket;
import com.thor.utils.CommConStance;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;


/**
 * @ClassName GamePacketDecoder
 * @Description TODO
 * @Author alms
 * @Data 2022/4/29 17:06
 **/
@Slf4j
public class GamePacketDecoder extends AbstractPacketDecoder {

    @Override
    public void invalidPacketSize(Channel channel) {
        serverDropChannel(channel);
        log.info("packet size is invalid , drop client channel is {}",channel);
    }

    @Override
    public int maxPacketSize(int packetId) {
        return CommConStance.Normal_MAX_PACKET_SIZE;
    }

    @Override
    public ReadPacket createPacket(int id, ByteBuf readBuf) {
        return null;
    }

    @Override
    public void notExistPacket(Channel channel, int id) {
        serverDropChannel(channel);
        log.info("packet not exist,drop client,channel is {},id is {}", channel, id);
    }

    public void serverDropChannel(Channel channel){
        if(channel != null){
            channel.close();
        }
    }
}
