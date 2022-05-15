package com.xiaocui.xiaocui_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xiaocui.xiaocui_server.mapper")
@SpringBootApplication
public class XiaocuiServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaocuiServerApplication.class, args);
    }



}
