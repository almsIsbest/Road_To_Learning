import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class SocketServer {

    public static void main(String[] args) throws IOException {
       InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress);

    }
}
