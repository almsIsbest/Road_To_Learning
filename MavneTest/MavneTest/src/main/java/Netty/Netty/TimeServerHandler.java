package Netty.Netty;

import io.netty.channel.ChannelHandlerAdapter;

public class TimeServerHandler extends ChannelHandlerAdapter {
    public static void main(String[] args) {
        TimeServerHandler timeServerHandler = new TimeServerHandler();
        System.out.println(timeServerHandler.test());
    }

    public int test() {
        int result;
        if ((result = returnOne()) != 1) {
            return result;
        }
        if ((result = returnTwo()) != 1) {
            return result;
        }
        return result;

    }

    public int returnOne() {
        return 1;
    }

    public int returnTwo() {
        return 2;

    }

    public int returnThree() {
        return 3;
    }

}
