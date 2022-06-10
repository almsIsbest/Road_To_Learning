package RocketMq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Producer {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer("ProducerGroup");
        defaultMQProducer.setNamesrvAddr("101.42.134.97:9876");
//        defaultMQProducer.setSendMsgTimeout(6000);
        defaultMQProducer.start();
        for (int i = 0; i < 100; i++) {
            try {
                Message message = new Message("Topic","Tag",("Hello RocketMq"+i).getBytes(StandardCharsets.UTF_8));
                SendResult sendResult = defaultMQProducer.send(message);
                System.out.println(sendResult);
            }catch (Exception e){
                e.printStackTrace();
            }
            //Thread.sleep(1000);
        }
        defaultMQProducer.shutdown();





    }
}
