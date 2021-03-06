package ncu.jerry.orangeplus.rabbitMq.pubsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Jiacheng on 2017/12/22.
 */
@Component
@RabbitListener(queues = "topic.message")
public class topicMessageReceiver {

    protected final static Logger logger = LoggerFactory.getLogger(topicMessageReceiver.class);

    @RabbitHandler
    public void process(String msg) {
        logger.info("topicMessageReceiver  : " +msg);
    }
}
