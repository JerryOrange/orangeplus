package ncu.jerry.orangeplus.rabbitMq.P2P;

import ncu.jerry.orangeplus.modules.sys.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Jiacheng on 2017/12/21.
 * 实体类传输消费者
 */
@RabbitListener(queues = "userQueue")
@Component
public class EntityReceiver {

    @RabbitHandler
    public void process(User user) {
        System.out.println("user receive  : " + user.getName()+"/"+user.getEmail());
    }
}
