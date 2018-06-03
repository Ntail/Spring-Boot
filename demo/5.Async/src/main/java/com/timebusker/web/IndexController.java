package com.timebusker.web;

import com.timebusker.service.ArithmeticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private ArithmeticService arithmeticService;

    @RequestMapping("/hello")
    public String getHello(){
        return "hello";
    }

    @SuppressWarnings("static-access")
    @RequestMapping(value = {"/async"},method = RequestMethod.GET)
    public void index(){
        long start = System.currentTimeMillis();
        try{
            System.out.println("start");
            logger.info("-----------------------------\n");
            logger.info("每个任务执行时间是："+arithmeticService.DoTime+"(毫秒)");

            Future<Long> task = arithmeticService.subByAsync();

            arithmeticService.subByVoid();

            long sync = arithmeticService.subBySync();

            while (true){
                if(task.isDone()){
                    long async = task.get();
                    logger.info("异步任务执行的时间是："+async+"(毫秒)");
                    logger.info("同步任务执行的时间是："+sync + "(毫秒)");
                    System.out.println("异步任务执行的时间是："+async+"(毫秒)\t同步任务执行的时间是："+sync + "(毫秒)");
                    break;
                }
            }
            //logger.info("-----------------------\n");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 自定义实现线程同步
     */
    @RequestMapping(value = {"mine","/m*"}, method = RequestMethod.GET)
    public void mineAsync(){
        for(int i=0;i<100;i++){
            try{
                arithmeticService.doMineAsync(i);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
