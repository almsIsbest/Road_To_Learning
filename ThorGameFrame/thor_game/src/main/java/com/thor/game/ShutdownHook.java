package com.thor.game;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName ShutdownHook
 * @Description ·þÎñÆ÷¹Ø±Õhook
 * @Author alms
 * @Data 2022/4/29 14:46
 **/
@Slf4j
public class ShutdownHook extends Thread {

    @Override
    public void run() {
        try {
            log.info("server is shutdown...");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
