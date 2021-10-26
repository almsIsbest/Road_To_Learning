package com.company;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketClient  {
    public static void main(String[] args) throws Exception {
        String host="127.0.0.1";
        int port =55533;

        //与服务器建立连接
        Socket socket=new Socket(host,port);

        //建立连接后获得输出流
        OutputStream outputStream=socket.getOutputStream();

        String message="您好 ，服务器";

        socket.getOutputStream().write(message.getBytes(StandardCharsets.UTF_8));

        //如果没有shutdownOutput服务器会一直等待消息
      //  socket.shutdownOutput();

        InputStream inputStream=socket.getInputStream();

        byte[] b=new byte[1024];

        StringBuilder cb=new StringBuilder();
        int len;
        while((len=inputStream.read(b))!=-1){
            cb.append(new String(b,0,len, StandardCharsets.UTF_8));
        }
        System.out.println("get message"+cb);

        inputStream.close();
        outputStream.close();
        socket.close();




    }
}
