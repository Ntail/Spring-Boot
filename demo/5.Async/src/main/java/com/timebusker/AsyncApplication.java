package com.timebusker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class AsyncApplication {

    public static void main(String[] args) {

        // 启动Spring boot
        ApplicationContext act = SpringApplication.run(AsyncApplication.class,args);
        //System.out.println("Let's inspect the beans provided by Spring Boot:");
        System.out.println("让我们检查Spring Boot提供的bean:");
        String[] beanNames = act.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for(String beanName:beanNames){
            System.out.println(beanName);
        }
    }
}
