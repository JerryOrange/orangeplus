package ncu.jerry.orangeplus.async;

import ncu.jerry.orangeplus.common.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Future;

/**
 * Created by Jiacheng on 2017/8/28.
 *
 * 异步操作测试类
 */

@Controller
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncTask task;

    @RequestMapping(value = "/task", method = RequestMethod.GET)
    @ResponseBody
    public Result task() throws Exception {
        long start = System.currentTimeMillis();

        Future<String> task1 = task.doTaskOne();
        Future<String> task2 = task.doTaskTwo();
        Future<String> task3 = task.doTaskThree();

        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
        return new Result<>(end - start);
    }
}
