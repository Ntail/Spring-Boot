package com.timebusker.springTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

/**
 * 动态添加修改删除定时任务
 */
@RestController
public class SpringTaskDynamicHandle {

    @Autowired
    // threadPoolTaskScheduler 类实现对任务的定时调度功能
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    /**
     * ScheduledFuture很简单，它就是在Future<V>基础上还集成了Comparable<Delayed>和Delayed的接口。
     * 它用于表示ScheduledExecutorService中提交了任务的返回结果。我们通过Delayed的接口getDelay()方法知道该任务还有好久才被执行
     */
    private ScheduledFuture<?> future;

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        return new ThreadPoolTaskScheduler();
    }

    @RequestMapping("/start")
    public String startCron(){
        future = threadPoolTaskScheduler.schedule(new SpringTaskRunnable(), new CronTrigger("0/5 * * * * *"));
        return "0/5 * * * * *";
    }

    @RequestMapping("/stop")
    public String stopCron(){
        if(future!=null){
            future.cancel(true);
        }
        return "stop";
    }

    @RequestMapping("/change")
    public String changeCron(){
        stopCron();
        future = threadPoolTaskScheduler.schedule(new SpringTaskRunnable(),new CronTrigger("*/1 * * * * *"));
        return "*/1 * * * * *";
    }

    private class SpringTaskRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("SpringTaskDynamicHandle.SpringTaskRunnable.run()的具体业务逻辑代码：---- " + new Date());
        }
    }

}
