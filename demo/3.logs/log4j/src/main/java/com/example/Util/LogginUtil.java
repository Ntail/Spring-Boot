package com.example.Util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogginUtil {

    private static final Logger logger = LoggerFactory.getLogger(LogginUtil.class);

    public static void creatLoggin(){
        logger.info("--INFO--");
        logger.debug("--DEBUG--");
        logger.error("--ERROR--");
    }
}
