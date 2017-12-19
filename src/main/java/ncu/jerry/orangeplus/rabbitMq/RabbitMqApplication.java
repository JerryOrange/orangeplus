package ncu.jerry.orangeplus.rabbitMq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 * Created by Jiacheng on 2017/12/18.
 * <p>
 * 创建初始化队列
 */
public class RabbitMqApplication {

    final static String queueName = "hello";

    @Bean
    public Queue helloQueue() {
        return new Queue(queueName);
    }

}
