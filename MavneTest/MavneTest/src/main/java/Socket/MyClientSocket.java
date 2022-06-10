package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

class MyClientSocket {

    public static void main(String[] args) throws IOException {

        Socket serverSocket = new Socket("10.0.105.237", 8889);


        DataInputStream dataInputStream = new DataInputStream(serverSocket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(serverSocket.getOutputStream());
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
    }//main--end
}//MyClientSocket--end

