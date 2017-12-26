package ncu.jerry.orangeplus.rabbitMq.pubsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by Jiacheng on 2017/12/26.
 * 发布确认机制：
 * (1) 需置CachingConnectionFactory的publisherConfirms属性为true；
 * (2) 生产者需调用setConfirmCallback(ConfirmCallback callback)，Confirms就会回调给生产者；
 * (3) 消费者需考虑消息去重处理。
 * 注意：一个RabbitTemplate只能支持一个ConfirmCallback。
 */
@Component
public class CallBackSender implements RabbitTemplate.ConfirmCallback{

    protected final static Logger logger = LoggerFactory.getLogger(CallBackSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplatenew;

    public void send() {
        rabbitTemplatenew.setConfirmCallback(this);
        String msg="callbackSender : i am callback sender";
        logger.debug(msg);
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        logger.debug("callbackSender UUID: " + correlationData.getId());
        this.rabbitTemplatenew.convertAndSend("exchange", "topic.messages", msg, correlationData);
    }

    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        logger.debug("callbakck confirm: " + correlationData.getId());
    }
}
