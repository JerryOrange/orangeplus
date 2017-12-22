package ncu.jerry.orangeplus.rabbitMq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by Jiacheng on 2017/12/18.
 * <p>
 * 创建初始化队列
 * Initializing exchange, binding exchange with routingKey
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

    //topic Exchange Queue
    @Bean
    public Queue queueMessage() {
        return new Queue("topic.message");
    }

    @Bean
    public Queue queueMessages() {
        return new Queue("topic.messages");
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    TopicExchange exchange2() {
        return new TopicExchange("exchange2");
    }

    /**
     * 将队列topic.message与exchange绑定，binding_key为topic.message,完全匹配
     * @param queueMessage
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    /**
     * 将队列topic.messages与exchange绑定，binding_key为topic.#,模糊匹配
     * @param queueMessages
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }

    /**
     * 将队列topic.message与exchange2绑定，binding_key为topic.message,完全匹配
     * @param queueMessage
     * @param exchange2
     * @return
     */
    @Bean
    Binding bindingExchange2Message(Queue queueMessage, TopicExchange exchange2) {
        return BindingBuilder.bind(queueMessage).to(exchange2).with("topic.message");
    }

}
