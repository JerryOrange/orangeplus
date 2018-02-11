package ncu.jerry.orangeplus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * Created by Jiacheng on 2018/2/9.
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class AsyncApplication {

    protected final static Logger logger = LoggerFactory.getLogger(AsyncApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AsyncApplication.class, args);
        logger.info("Async Application is success!");
    }
}
