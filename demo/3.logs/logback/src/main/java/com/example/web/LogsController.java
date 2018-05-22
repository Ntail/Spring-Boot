package com.example.web;

import com.example.util.LoggingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogsController {
    private static final Logger logger = LoggerFactory.getLogger(LogsController.class);

    @RequestMapping(value = {"/**","/"},method = RequestMethod.GET)
    public Long creatLogs(){
        logger.info("--INFO--");
        logger.debug("--DEBUG--");
        logger.error("--error--");
        LoggingUtil.creatLogging();
        return System.currentTimeMillis();
    }
}
