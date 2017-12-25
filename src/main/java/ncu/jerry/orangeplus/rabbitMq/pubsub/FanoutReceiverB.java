package ncu.jerry.orangeplus.rabbitMq.pubsub;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Jiacheng on 2017/12/25.
 */
@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiverB {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("FanoutReceiverB  : " + msg);
    }
}
