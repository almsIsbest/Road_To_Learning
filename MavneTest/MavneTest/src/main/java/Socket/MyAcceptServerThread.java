package Socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;


class MyAcceptServerThread extends Thread {

    private DataInputStream dataInputStream = null;

    public MyAcceptServerThread(Socket socket) {
        try {
            this.dataInputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//MyAcceptServerThread--end

    @Override
    public void run() {
        String tell = null;
        while (true) {
            try {
                tell = this.dataInputStream.readUTF();
                System.out.println("闵："+tell);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//run--end
}//MyAcceptServerThread--end