package ncu.jerry.orangeplus.rabbitMq.pubsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * topic Exchange 生产者
 *
 * Created by Jiacheng on 2017/12/22.
 */
@Component
public class TopicSender {

    protected final static Logger logger = LoggerFactory.getLogger(TopicSender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msg1 = "topic.mesaage msg1";
        logger.info("sender1 : " + msg1);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", msg1);

        String msg2 = "topic.mesaages msg2";
        logger.info("sender2 : " + msg2);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", msg2);

        String msg3 = "topic.mesaages msg3";
        logger.info("sender3 : " + msg3);
        this.rabbitTemplate.convertAndSend("exchange2", "topic.message", msg3);
    }
}
