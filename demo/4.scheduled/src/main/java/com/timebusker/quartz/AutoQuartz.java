package com.timebusker.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * 任务类
 */
public class AutoQuartz implements Job {

    public void execute(JobExecutionContext conetxt) throws JobExecutionException {
        // 执行响应的任务
        System.out.println("AutoQuartz.execute:任务执行类 _______  ," + new Date());
    }
}
