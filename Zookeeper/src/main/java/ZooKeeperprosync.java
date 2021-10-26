import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;

public class ZooKeeperprosync implements Watcher {
    private static CountDownLatch connectedSemaphore =new CountDownLatch(1);
    private static ZooKeeper zk=null;
    private static Stat stat=new Stat();
    public static void main(String[] args) throws Exception{
        //zookeeper配置数据存放路径
        String path="/username";
        //连接zookeeper并且注册一个默认的监听器
        zk=new ZooKeeper("192.168.181.133:2181",5000,new ZooKeeperprosync());
        //等待zk连接成功的通知
        connectedSemaphore.await();
        //获取path目录节点的配置数据，并注册默认的监听器
        System.out.println(new String(zk.getData(path,true,stat)));

        Thread.sleep(Integer.MAX_VALUE);
    }
    @Override
    public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected== watchedEvent.getState()){//zk连接成功通知事件
            if (Event.EventType.None== watchedEvent.getType()&&null== watchedEvent.getPath()){
                connectedSemaphore.countDown();
            }else if(Event.EventType.NodeDataChanged.equals(watchedEvent.getType())) {
                try {
                    System.out.println("配置已修改，新值为："+new String(zk.getData(watchedEvent.getPath(),true,stat)));
                    int timeOut=3000;
                    boolean status= InetAddress.getByName(new String(zk.getData(watchedEvent.getPath(),true,stat))).isReachable(timeOut);
                    System.out.println("是否能连同："+status);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
