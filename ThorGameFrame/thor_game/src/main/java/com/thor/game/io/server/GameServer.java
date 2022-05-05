package com.thor.game.io.server;

import com.thor.io.tcp.TcpServer;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * @ClassName GameServer
 * @Description TODO
 * @Author alms
 * @Data 2022/4/29 17:03
 **/
public class GameServer extends TcpServer<> {
    private static final GameServer gameServer = new GameServer();


    @Override
    public ByteToMessageDecoder createDecoder() {
        return null;
    }

    @Override
    public ChannelInboundHandlerAdapter createHandler() {
        return null;
    }
}
