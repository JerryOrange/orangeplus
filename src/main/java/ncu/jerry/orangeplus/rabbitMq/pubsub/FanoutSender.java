package ncu.jerry.orangeplus.rabbitMq.pubsub;

import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Jiacheng on 2017/12/25.
 * fanout ExChange测试生产者
 */
@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msgString="fanoutSender :hello";
        System.out.println(msgString);
        //这种模式不需要routingKey
        this.rabbitTemplate.convertAndSend("fanoutExchange", StringUtils.EMPTY, msgString);
    }
}
