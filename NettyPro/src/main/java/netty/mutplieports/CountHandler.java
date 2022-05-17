package netty.mutplieports;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName CountHandler
 * @Description TODO
 * @Author alms
 * @Data 2022/5/17 11:37
 **/
public class CountHandler extends ChannelInboundHandlerAdapter {

    private AtomicInteger nConnection = new AtomicInteger();

    public CountHandler(){
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(()->{
            System.out.println("connections :" +nConnection.get());},0,2, TimeUnit.SECONDS
        );
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        nConnection.incrementAndGet();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        nConnection.decrementAndGet();
    }
}
