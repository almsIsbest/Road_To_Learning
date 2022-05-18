package com.thor.game.io.packet;

import com.tennis.comm.io.PacketId;
import com.thor.game.io.packet.sys.login.LoginRequest;
import io.netty.buffer.ByteBuf;

/**
 * @ClassName GamePacketFactory
 * @Description ��Ϸ��Э��������
 * ֮���Բ���switch�ķ�ʽÿ��ʵ�����¶�������Ϊ�˷�ʽ��Ч��Զ����class.forName
 * ���õķ�ʽ,���»���classҲ�����
 * ���ҷ��������.ͬʱ,ÿ�������µ�Э�����֤��ϵͳ�Զ������ڴ��ͷ�
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
