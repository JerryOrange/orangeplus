package ncu.jerry.orangeplus.rabbitMq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by Jiacheng on 2017/12/18.
 * <p>
 * 创建初始化队列
 */
@Component
public class RabbitMqApplication {

    final static String queueName = "helloQueue";
    final static String userQueueName = "userQueue";

    @Bean
    public Queue helloQueue() {
        return new Queue(queueName);
    }

    @Bean
    public Queue userQueue() {
        return new Queue(userQueueName);
    }

}
