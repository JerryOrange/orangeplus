package ncu.jerry.orangeplus;

import ncu.jerry.orangeplus.rabbitMq.P2P.HelloSenderP2P;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqApplicationTests {

    @Autowired
    private HelloSenderP2P sender;

    @Test
    public void hello() throws Exception {
        sender.send("test message");
    }

}
