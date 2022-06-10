package Netty.BIO;

import ch.qos.logback.core.net.server.ServerSocketListener;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true){
            Socket  socket=serverSocket.accept();
            new Thread(new TimeServerHandler(socket)).start();
        }
    }
}
