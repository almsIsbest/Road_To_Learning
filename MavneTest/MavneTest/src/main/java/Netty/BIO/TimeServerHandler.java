package Netty.BIO;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TimeServerHandler implements Runnable {
    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @SneakyThrows
    @Override
    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        String currentTime = null;
        String body = null;
        while (true) {
            body = in.readLine();
            if (body == null) {
                in.close();
                out.close();
                break;
            }
            System.out.println(body);
            out.println(new Date().toString());
        }
    }
}
