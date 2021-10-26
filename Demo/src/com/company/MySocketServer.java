package com.company;

import javax.swing.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class MySocketServer {
    public static void main(String[] args) throws Exception {
        int port=55533;
        ServerSocket serverSocket=new ServerSocket(port);

        //server将一直等待连接的到来
        System.out.println("server一直在等待");
        Socket socket=serverSocket.accept();

        //监听打开等待从socket中获取输入流，并建立缓冲区进行读取
        InputStream inputStream=socket.getInputStream();
        byte[] bytes=new byte[1024];
        int len;

        StringBuilder sb =new StringBuilder();

        while((len=inputStream.read(bytes))!=-1){
            sb.append(new String(bytes,0,len, StandardCharsets.UTF_8));
        }

        OutputStream outputStream=socket.getOutputStream();

        outputStream.write("hello,client".getBytes(StandardCharsets.UTF_8));
        System.out.println("get message from client :"+sb);

        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
