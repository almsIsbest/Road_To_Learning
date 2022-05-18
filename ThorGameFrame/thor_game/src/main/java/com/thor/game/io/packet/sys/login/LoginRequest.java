package com.thor.game.io.packet.sys.login;

import com.thor.game.io.packet.GameReadPacket;
import io.netty.buffer.ByteBuf;

/**
 * @ClassName LoginRequest
 * @Description
 * @Author alms
 * @Data 2022/5/18 12:09
 **/
public class LoginRequest extends GameReadPacket {
    public LoginRequest(int id, ByteBuf readBuf) {
        super(id, readBuf);
    }

    @Override
    public void process() throws Exception {

    }
}
