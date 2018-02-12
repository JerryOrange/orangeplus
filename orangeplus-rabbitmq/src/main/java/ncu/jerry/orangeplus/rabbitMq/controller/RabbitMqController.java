package ncu.jerry.orangeplus.rabbitMq.controller;

import ncu.jerry.orangeplus.common.base.Result;
import ncu.jerry.orangeplus.rabbitMq.P2P.EntitySender;
import ncu.jerry.orangeplus.rabbitMq.P2P.HelloSender2;
import ncu.jerry.orangeplus.rabbitMq.P2P.HelloSenderP2P;
import ncu.jerry.orangeplus.rabbitMq.pubsub.CallBackSender;
import ncu.jerry.orangeplus.rabbitMq.pubsub.FanoutSender;
import ncu.jerry.orangeplus.rabbitMq.pubsub.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RabbitMQ 测试类
 *
 * Created by Jiacheng on 2017/12/18.
 */
@RestController
@RequestMapping(value = "/rabbit")
public class RabbitMqController {

    @Autowired
    private HelloSenderP2P helloSenderP2P;
    @Autowired
    private HelloSender2 helloSender2;
    @Autowired
    private EntitySender entitySender;
    @Autowired
    private TopicSender topicSender;
    @Autowired
    private FanoutSender fanoutSender;
    @Autowired
    private CallBackSender callBackSender;

    /**
     * 单生产者-单消费者
     * P2P：每个消息只有一个消费者（Consumer）
     * 消息一旦被某个消费者消费，消息就不再在消息队列中
     *
     * @return
     */
    @RequestMapping("/hello")
    public Result hello() {
        helloSenderP2P.send("helloMsg");
        return new Result("SUCCESS");
    }

    /**
     * 单生产者-多消费者
     * P2P：每个消息只有一个消费者（Consumer）
     * 消息一旦被某个消费者消费，消息就不再在消息队列中
     */
    @PostMapping("/toConsumers")
    public Result toConsumers() {
        for (int i = 0; i < 10; i++) {
            helloSenderP2P.send("helloMsg:" + i);
        }
        return new Result("SUCCESS");
    }

    /**
     * 多生产者-多消费者
     */
    @PostMapping("/sendersToConsumers")
    public Result sendersToConsumers() {
        for (int i = 0; i < 10; i++) {
            helloSenderP2P.send("hellomsg:" + i);
            helloSender2.send("hellomsg:" + i);
        }
        return new Result("SUCCESS");
    }

    /**
     * 实体类传输测试
     */
    @PostMapping("/entityTest")
    public void entityTest() {
        entitySender.send();
    }

    /**
     * topic exchange类型测试
     */
    @PostMapping("/topicTest")
    public void topicTest() {
        topicSender.send();
    }

    /**
     * fanout exchange类型测试
     */
    @PostMapping("/fanoutTest")
    public void fanoutTest() {
        fanoutSender.send();
    }

    /**
     * 带callback的消息发送
     */
    @PostMapping("/callback")
    public void callbak() {
        callBackSender.send();
    }

}
