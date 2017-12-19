package ncu.jerry.orangeplus.rabbitMq.Controller;

import ncu.jerry.orangeplus.common.base.Result;
import ncu.jerry.orangeplus.rabbitMq.P2P.HelloSenderP2P;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jiacheng on 2017/12/18.
 */
@RestController
@RequestMapping(value="/rabbit")
public class RabbitMqP2PController {

    @Autowired
    private HelloSenderP2P helloSenderP2P;

    @RequestMapping("/hello")
    public Result hello() {
        helloSenderP2P.send();
        return new Result("SUCCESS");
    }

}
