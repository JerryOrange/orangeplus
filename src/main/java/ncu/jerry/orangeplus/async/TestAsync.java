package ncu.jerry.orangeplus.async;

import ncu.jerry.orangeplus.common.utils.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;


import javax.swing.*;
import java.util.concurrent.Future;

/**
 * Created by Jiacheng on 2017/8/28.
 *
 * AsyncTask @Test
 */

public class TestAsync {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AsyncTask asyncTask;

    @Test
    public void AsyncTaskTest() throws Exception {
        asyncTask = new AsyncTask();
        Future<String> task1 = asyncTask.doTask1();
        Future<String> task2 = asyncTask.doTask2();

        while(true) {
            if(task1.isDone() && task2.isDone()) {
                logger.info("Task1 result: {}", task1.get());
                logger.info("Task2 result: {}", task2.get());
                break;
            }
            Thread.sleep(1000);
        }

        logger.info("All tasks finished.");
    }
}
