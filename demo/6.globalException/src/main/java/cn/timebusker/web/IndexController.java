package cn.timebusker.web;

import cn.timebusker.exception.MineException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    public static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/")
    public String hello(ModelMap map){
        logger.info("访问到来 hello");
        map.addAttribute("index","一起尝试 springBoot 全局异常捕获吧...");
        return "index";
    }

    @RequestMapping("/anyone")
    public String anyone(ModelMap map) throws Exception{
        logger.info("访问到来 index....");
        throw new Exception();
    }

    @RequestMapping("/mine")
    public String mine(ModelMap map) throws MineException {
        logger.info("访问到了 mine....");
        Throwable throwable = new Throwable();
        throw new MineException("我们访问到了 mine...",throwable);
    }

    @ResponseBody
    @RequestMapping("/sum")
    public String sum(ModelMap map) throws ArithmeticException{
        int i = 1/0;
        return ""+i;
    }
}