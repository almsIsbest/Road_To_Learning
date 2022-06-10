package Socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


class MyClientToSerThread extends Thread {

    private DataOutputStream dataOutputStream = null;
    private Scanner in = null;

    public MyClientToSerThread(Socket socket) {
        try {
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
            this.in = new Scanner(System.in);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }//MyClientToSerThread--end

    @Override
    public void run() {
        String tell = null;
        while (true) {
            try {
                tell = in.nextLine();
                dataOutputStream.writeUTF(tell);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//run--end
}//MyClientToSerThread--end
