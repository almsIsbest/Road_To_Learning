package com.thor.game;


import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName GameMain
 * @Description game游戏启动服
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

        System.out.println("服务器启动成功");

        Runtime.getRuntime().addShutdownHook(new ShutdownHook());
    }
    private static boolean init(){
        /**初始化全局变量**/
        return false;
    }

    private static boolean startServer(){
        /**开启game服**/
        return false;
    }

    private static boolean startGame(){
        /**开启游戏**/
        return false;
    }
}
