package com.thor.game;


import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName GameMain
 * @Description game启动
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

        System.out.println("服务器启动！ ");

        Runtime.getRuntime().addShutdownHook(new ShutdownHook());
    }
    private static boolean init(){
        /**初始化全局变量 数据库配置 数据库对象初始化**/
        return false;
    }

    private static boolean startServer(){
        /**启动服务器**/
        return false;
    }

    private static boolean startGame(){
        /**TODO**/
        return false;
    }
}
