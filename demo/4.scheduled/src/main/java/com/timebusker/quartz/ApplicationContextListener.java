package com.timebusker.quartz;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationContextListener implements ServletContextListener {

    private Scheduler scheduled = null;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try{
            /**
             * 在Quartz中，scheduler由schedule工厂创建，DirectSchedulerFactory 或者
             * StdschedulerFactory.第二种工厂 STDSchedulerFactory使用较多，因为
             * DirectSchedulerFactory 使用起来不够方便，需要座许多详细的手工编码设置
             */
            // 获取scheduler实例
            scheduled = StdSchedulerFactory.getDefaultScheduler();
            scheduled.start();
            System.out.println("scheduler.start");
            System.out.println(scheduled.getSchedulerName());
            // 注册任务
            JobDetail jobDetail = JobBuilder.newJob(AutoQuartz.class).withIdentity("AutoQuartzJob","AutoQuartzGroup").build();
            // 设置触发时间(每隔5秒执行一次)
            SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(5).repeatForever();
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger","group").startNow().withSchedule
                    (simpleScheduleBuilder).build();
            // 交由scheduler安排触发
            scheduled.scheduleJob(jobDetail,trigger);
        }catch (SchedulerException e){
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent arg0){
        try{
            scheduled.shutdown();
        }catch (SchedulerException e){
            e.printStackTrace();
        }// 关闭定时任务调度器
    }
}
