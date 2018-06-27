package cn.timebusker.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingUtil {

    public static final Logger logger = LoggerFactory.getLogger(LoggingUtil.class);

    public static void crateLogging(){
        logger.info("------------------------INFO");
        logger.error("-----------------------ERROR");
        logger.debug("-----------------------DEBUG");
    }
}
