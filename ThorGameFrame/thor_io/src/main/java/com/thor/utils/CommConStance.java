package com.thor.utils;

/**
 * @ClassName CommConStance
 * @Description
 * @Author alms
 * @Data 2022/4/29 17:32
 **/
public class CommConStance {
    /**��ͷ����*/
    public static final int PACKET_HEADER_LENGTH = 6;

    /**Э��ų���*/
    public static final int PACKET_ID_LENGTH = 2;

    /**ÿ��������󳤶�*/
    public static final int Normal_MAX_PACKET_SIZE = (int)Short.MAX_VALUE * 2 - 100;
}
