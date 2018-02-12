package ncu.jerry.orangeplus.rabbitMq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 创建初始化队列
 * Initializing exchange, binding exchange with routingKey
 *
 * Created by Jiacheng on 2017/12/18.
 */
@Component
public class RabbitMqConfig {

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
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    TopicExchange exchange2() {
        return new TopicExchange("exchange2");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
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

    /**
     * 任何发送到Fanout Exchange的消息都会被转发到与该Exchange绑定(Binding)的所有Queue上
     *
     * @param AMessage
     * @param fanoutExchange
     * @return
     */
    @Bean
    Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }

}
