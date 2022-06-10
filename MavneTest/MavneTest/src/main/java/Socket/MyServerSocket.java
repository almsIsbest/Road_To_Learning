package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServerSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("10.0.105.237", 8889));
        Socket socket = serverSocket.accept();
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        new Thread(() -> {
            while (true) {
                String s = null;
                try {
                    s = dataInputStream.readUTF();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(s);
            }
        }).start();
        new Thread(() -> {
            while (true) {
                String s = null;
                s = scanner.nextLine();
                try {
                    dataOutputStream.writeUTF(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
