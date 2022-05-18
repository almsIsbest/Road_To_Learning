package com.thor.game.io.packet;

import com.tennis.comm.io.PacketId;
import com.thor.game.io.packet.sys.login.LoginRequest;
import io.netty.buffer.ByteBuf;

/**
 * @ClassName GamePacketFactory
 * @Description 游戏服协议生成类
 * 之所以采用switch的方式每次实例化新对象是因为此方式的效率远高于class.forName
 * 配置的方式,哪怕缓存class也是如此
 * 而且方便检查代码.同时,每次生成新的协议对象保证了系统自动进行内存释放
 * @Author alms
 * @Data 2022/5/18 12:02
 **/
public class GamePacketFactory {

    public static GameReadPacket createPacked(int packetId , ByteBuf readBuf){
        switch (packetId){
            case PacketId.LogIn:
                return new LoginRequest(packetId,readBuf);
            default:
                return null;
        }
    }
}
