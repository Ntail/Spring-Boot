package cn.timebusker.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 快速启动spring boot
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("Hello Spring Boot");
        return "Hello Spring Boot QuickStart!!!";
    }
}
