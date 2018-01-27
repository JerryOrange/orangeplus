package ncu.jerry.orangeplus.rabbitMq.pubsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Jiacheng on 2017/12/25.
 */
@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {

    protected final static Logger LOGGER = LoggerFactory.getLogger(FanoutReceiverA.class);

    @RabbitHandler
    public void process(String msg) {
        LOGGER.info("FanoutReceiverA  : " + msg);
    }
}
