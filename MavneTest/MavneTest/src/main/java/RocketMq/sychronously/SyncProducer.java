package RocketMq.sychronously;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

/**
 * @ClassName SyncProducer
 * @Description 同步消息
 * @Author alms
 * @Data 2022/6/16 17:47
 **/
public class SyncProducer {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        int i = 1;
        //使用一个名字实例化生产者
        DefaultMQProducer producer = new DefaultMQProducer("test_sync");
        //定义name Server addresses：
        producer.setNamesrvAddr("192.168.181.133:9876");
        //启动这个实例
        producer.start();
       while (true){
            //创建一个message 实例，指定topic，tag和message信息体
            Message msg = new Message("TopicTest", "TagA", ("Hello RocketMQ" + i).getBytes(StandardCharsets.UTF_8));
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n",sendResult);
            i++;
            Thread.sleep(3000);
        }
    }
}
