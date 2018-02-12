package ncu.jerry.orangeplus.rabbitMq.P2P;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Jiacheng on 2017/12/18.
 */
@Component
@RabbitListener(queues = "helloQueue")
public class HelloReceiverP2P {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("ReceiverP2P  : " + hello);
    }

}
