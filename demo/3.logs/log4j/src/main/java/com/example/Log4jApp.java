package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Log4jApp {

	public static void main(String[] args) {

		// 启动Sprign Boot
		ApplicationContext ctx = SpringApplication.run(Log4jApp.class, args);
		System.out.println("让我们检查Spring Boot提供的bean:");
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for(String beanName:beanNames){
			System.out.println(beanName);
		}
	}
}
