package cn.timebusker.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonUtils {

    public static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);

    public static int add(int i){
        i += 1;
        logger.info("CommonUtil 的处理结果为："+i);
        return i;
    }
}
