package ncu.jerry.orangeplus.rabbitMq.P2P;

import ncu.jerry.orangeplus.modules.sys.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Jiacheng on 2017/12/21.
 * 实体类传输生产者
 */
@Component
public class EntitySender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        User user=new User();
        user.setName("Jiacheng");
        user.setEmail("123456789@qq.com");
        System.out.println("user send : " + user.getName()+"/"+user.getEmail());
        this.rabbitTemplate.convertAndSend("userQueue", user);
    }
}
