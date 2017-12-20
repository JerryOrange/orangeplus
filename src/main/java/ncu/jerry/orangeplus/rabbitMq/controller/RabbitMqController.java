package ncu.jerry.orangeplus.rabbitMq.controller;

import ncu.jerry.orangeplus.common.base.Result;
import ncu.jerry.orangeplus.rabbitMq.P2P.HelloSender2;
import ncu.jerry.orangeplus.rabbitMq.P2P.HelloSenderP2P;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jiacheng on 2017/12/18.
 * RabbitMQ 测试类
 */
@RestController
@RequestMapping(value = "/rabbit")
public class RabbitMqController {

    @Autowired
    private HelloSenderP2P helloSenderP2P;
    @Autowired
    private HelloSender2 helloSender2;

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

}
