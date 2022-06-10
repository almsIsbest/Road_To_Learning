package Thread;

import com.mysql.cj.protocol.x.SyncMessageSender;
import com.sun.tools.javac.Main;

import javax.management.monitor.Monitor;
import javax.swing.plaf.synth.SynthMenuBarUI;
import javax.xml.transform.dom.DOMResult;
import java.nio.Buffer;
import java.nio.channels.Channel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class HelloWorld {

    ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("argCheck");
        hashSet.add("playerManage");
        hashSet.add("databaseManage");
        hashSet.add("gameManage");
        for (String s : hashSet) {
            System.out.println(s);
        }


    }
}
