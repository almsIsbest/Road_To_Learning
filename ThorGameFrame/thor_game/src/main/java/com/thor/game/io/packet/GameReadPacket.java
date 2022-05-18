package com.thor.game.io.packet;

import com.thor.io.packet.ReadPacket;
import io.netty.buffer.ByteBuf;

/**
 * @ClassName GameReadPacket
 * @Description
 * @Author alms
 * @Data 2022/5/18 12:02
 **/
public abstract class GameReadPacket extends ReadPacket {
    public GameReadPacket(int id, ByteBuf readBuf) {
        super(id, readBuf);
    }
}
