package cn.timebusker.service;

import cn.timebusker.annotation.timebuskerBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@timebuskerBean
public class CommonService {

    public static final Logger logger = LoggerFactory.getLogger(CommonService.class);

    public int add(int i){
        i += 1;
        logger.info("CommonService的处理结果为："+i);
        return i;
    }
}
