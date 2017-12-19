package ncu.jerry.orangeplus.rabbitMq.P2P;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Jiacheng on 2017/12/18.
 */
@Component
public class HelloSenderP2P {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String sendMsg = "hello " + new Date();
        System.out.println("SenderP2P : " + sendMsg);
        this.rabbitTemplate.convertAndSend("helloQueue", sendMsg);
    }
}
