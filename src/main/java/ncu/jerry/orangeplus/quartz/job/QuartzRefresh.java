package ncu.jerry.orangeplus.quartz.job;

import ncu.jerry.orangeplus.quartz.entity.QuartzCronConfig;
import ncu.jerry.orangeplus.quartz.repository.QuartzCronConfigRepository;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 定时查库，并更新任务
 * <p>
 * Created by Jiacheng on 2018/1/29.
 */
@Component
@EnableScheduling
public class QuartzRefresh {

    private final static Logger LOGGER = LoggerFactory.getLogger(QuartzRefresh.class);

    @Autowired
    private QuartzCronConfigRepository quartzCronConfigRepository;

    @Resource(name = "jobDetail")
    private JobDetail jobDetail;

    @Resource(name = "jobTrigger")
    private CronTrigger cronTrigger;

    @Resource(name = "scheduler")
    private Scheduler scheduler;

    /**
     * 每隔5s查库，并根据查询结果决定是否重新设置定时任务
     *
     * @throws SchedulerException
     */
    @Scheduled(fixedRate = 5000)
    public void scheduleUpdateCronTrigger() throws SchedulerException {
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(cronTrigger.getKey());
        String currentCron = trigger.getCronExpression();// 当前Trigger使用的
        QuartzCronConfig quartzCronConfig = quartzCronConfigRepository.findOne(1L);
        String searchCron = quartzCronConfig.getCron();
        LOGGER.debug("currentCron :" + currentCron);
        LOGGER.debug("searchCron :" + searchCron);
        if (currentCron.equals(searchCron)) {
            // 如果当前使用的cron表达式和从数据库中查询出来的cron表达式一致，则不刷新任务
        } else {
            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(searchCron);
            // 按新的cronExpression表达式重新构建trigger
            trigger = (CronTrigger) scheduler.getTrigger(cronTrigger.getKey());
            trigger = trigger.getTriggerBuilder().withIdentity(cronTrigger.getKey()).withSchedule(scheduleBuilder).build();
            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(cronTrigger.getKey(), trigger);
        }
    }
}
