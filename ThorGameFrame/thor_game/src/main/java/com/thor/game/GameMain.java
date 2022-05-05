package com.thor.game;


import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName GameMain
 * @Description game����
 * @Author alms
 * @Data 2022/4/29 12:17
 **/
@Slf4j
public class GameMain {
    public static void main(String[] args) {
        if (!init() || !startServer() || !startGame()) {
            System.exit(0);
            return;
        }

        System.out.println("������������ ");

        Runtime.getRuntime().addShutdownHook(new ShutdownHook());
    }
    private static boolean init(){
        /**��ʼ��ȫ�ֱ��� ���ݿ����� ���ݿ�����ʼ��**/
        return false;
    }

    private static boolean startServer(){
        /**����������**/
        return false;
    }

    private static boolean startGame(){
        /**TODO**/
        return false;
    }
}
