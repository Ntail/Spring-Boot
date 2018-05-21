package com.example.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingUtil {

    /**
     * LoggerFactory 日志工厂，用来创建日志对象
     * 使用指定类初始化日志对象，在日志输出的时候，可以打印出日志信息所在类
     * 如：Logger logger = LoggerFactory.getLogger(com.Book.class);
     *       logger.debug("日志信息");
     * 将会打印出: com.Book  : 日志信息
     */
    private static final Logger logger = LoggerFactory.getLogger(LoggingUtil.class);

    public static void creatLogging() {
        logger.info("---------info--------");
        logger.debug("-----------debug----------");
        logger.error("-----------error-----------");
    }
}