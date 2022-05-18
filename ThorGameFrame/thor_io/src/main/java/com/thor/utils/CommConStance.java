package com.thor.utils;

/**
 * @ClassName CommConStance
 * @Description
 * @Author alms
 * @Data 2022/4/29 17:32
 **/
public class CommConStance {
    /**包头长度*/
    public static final int PACKET_HEADER_LENGTH = 6;

    /**协议号长度*/
    public static final int PACKET_ID_LENGTH = 2;

    /**每个包的最大长度*/
    public static final int Normal_MAX_PACKET_SIZE = (int)Short.MAX_VALUE * 2 - 100;
}
