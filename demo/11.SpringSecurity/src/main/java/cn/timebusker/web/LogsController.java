package cn.timebusker.web;

import cn.timebusker.util.LoggingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogsController {
    // 在Java类中创建 logger 实例
    public static final Logger logger = LoggerFactory.getLogger(LogsController.class);

    // 在方法中使用日志输出，如
    @RequestMapping(value = {"/**","/"},method = RequestMethod.GET)
    public Long createLogs(){
        logger.info("----------------------------INFO");
        logger.debug("----------------------------DEBUG");
        logger.error("----------------------------ERROR");
        LoggingUtil.crateLogging();
        return System.currentTimeMillis();
    }
}
