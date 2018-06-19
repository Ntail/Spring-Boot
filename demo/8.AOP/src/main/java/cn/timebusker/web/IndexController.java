package cn.timebusker.web;

import cn.timebusker.service.CommonService;
import cn.timebusker.service.order.OrderInfoService;
import cn.timebusker.service.user.UserInfoService;
import cn.timebusker.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class IndexController {

    public static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Resource
    CommonService service;

    @Resource
    OrderInfoService orderInfoService;

    @Resource
    UserInfoService userInfoService;

    @RequestMapping(value = {"/**","/"}, method = RequestMethod.GET)
    public Long testAop(){
        logger.info("\n=================================spring aop============================");
        int i = 1;
        i = CommonUtils.add(i);
        i = service.add(i);
        logger.info("\n===================处理结果为："+i+"======================");
        String name = "#####";
        name = orderInfoService.addOrderInfo(name);
        name = userInfoService.addUserInfo(name);
        logger.info("\n===============名称为\t"+name+"============");
        return System.currentTimeMillis();
    }
}
