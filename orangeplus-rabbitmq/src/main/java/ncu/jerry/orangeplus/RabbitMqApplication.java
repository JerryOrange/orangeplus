package ncu.jerry.orangeplus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class RabbitMqApplication {

    protected final static Logger logger = LoggerFactory.getLogger(RabbitMqApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqApplication.class, args);
        logger.info("RabbitMQ Application is success!");
    }
}
