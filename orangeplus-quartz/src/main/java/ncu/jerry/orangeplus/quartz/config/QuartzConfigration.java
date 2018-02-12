package ncu.jerry.orangeplus.quartz.config;

import ncu.jerry.orangeplus.quartz.job.ScheduledJob;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Quartz配置类
 * <p>
 * Created by Jiacheng on 2018/1/29.
 */
@Configuration
public class QuartzConfigration {

    /**
     * 配置定时任务
     *
     * @param job 需要执行的任务
     * @return
     */
    @Bean(name = "jobDetail")
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(ScheduledJob job) {
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
        //是否并发执行
        jobDetail.setConcurrent(false);
        //设置任务的名字
        jobDetail.setName("group-job");
        //设置任务的分组，这些属性都可以存储在数据库中，在多任务的时候使用
        jobDetail.setGroup("group");
        //为需要执行的实体类对应的对象
        jobDetail.setTargetObject(job);
        //配置JobDetailFactoryBean我要执行定时执行ScheduledJob类中的sayHello方法
        jobDetail.setTargetMethod("sayHello");
        return jobDetail;
    }

    /**
     * 配置定时任务的触发器，何时触发执行定时任务
     *
     * @param jobDetail
     * @return
     */
    @Bean(name = "jobTrigger")
    public CronTriggerFactoryBean cronJobTrigger(MethodInvokingJobDetailFactoryBean jobDetail) {
        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
        tigger.setJobDetail(jobDetail.getObject());
        //初始时的cron表达式
        tigger.setCronExpression("0 30 20 * * ?");
        //trigger的name
        tigger.setName("group-job");
        return tigger;
    }

    /**
     * 定义quartz调度工厂
     *
     * @param cronJobTrigger
     * @return
     */
    @Bean(name = "scheduler")
    public SchedulerFactoryBean schedulerFactory(Trigger cronJobTrigger) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        //用于quartz集群,QuartzScheduler 启动时更新己存在的Job
        bean.setOverwriteExistingJobs(true);
        //延时启动，应用启动2秒后
        bean.setStartupDelay(2);
        //注册触发器
        bean.setTriggers(cronJobTrigger);
        return bean;
    }
}
