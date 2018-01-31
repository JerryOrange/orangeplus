package ncu.jerry.orangeplus.common.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Spring @Scheduled 实现定时任务
 * <p>
 * Created by Jiacheng on 2018/1/27.
 */
@Component
@EnableScheduling
public class ScheduledJob {

    private final static Logger LOGGER = LoggerFactory.getLogger(ScheduledJob.class);

    /**
     * 每分钟执行一次
     *
     * @throws Exception
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void work() throws Exception {
        LOGGER.debug("执行调度任务：" + new Date());
    }

    /**
     * 每5秒执行一次
     *
     * @throws Exception
     */
    @Scheduled(fixedRate = 5000)
    public void play() throws Exception {
        LOGGER.debug("执行定时器任务：" + new Date());
    }

    /**
     * 每2秒执行一次
     *
     * @throws Exception
     */
    @Scheduled(cron = "0/2 * * * * ?")
    public void doSomething() throws Exception {
        LOGGER.debug("每2秒执行一个的定时任务：" + new Date());
    }

    /**
     * 每一小时执行一次
     *
     * @throws Exception
     */
    @Scheduled(cron = "0 0 0/1 * * ? ")
    public void goWork() throws Exception {
        LOGGER.debug("每一小时执行一次的定时任务：" + new Date());
    }

    /**
     * Quartz定时任务
     */
    public void sayHello() {
        LOGGER.debug("=== Quartz === Hello world");
    }
}
