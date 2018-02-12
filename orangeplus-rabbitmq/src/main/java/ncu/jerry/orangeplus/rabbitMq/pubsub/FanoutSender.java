package ncu.jerry.orangeplus.rabbitMq.pubsub;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * fanout ExChange测试生产者
 *
 * Created by Jiacheng on 2017/12/25.
 */
@Component
public class FanoutSender {

    protected final static Logger LOGGER = LoggerFactory.getLogger(FanoutSender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msgString="fanoutSender :hello";
        LOGGER.info(msgString);
        //这种模式不需要routingKey
        this.rabbitTemplate.convertAndSend("fanoutExchange", StringUtils.EMPTY, msgString);
    }
}
