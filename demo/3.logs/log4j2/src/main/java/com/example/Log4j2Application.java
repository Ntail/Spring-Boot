package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Log4j2Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Log4j2Application.class, args);
		System.out.println("Let's inspect the beans provided by Spring Boot:");
		String[] beanNames = ctx.getBeanDefinitionNames();
		// 排序
		Arrays.sort(beanNames);
		for (String beanName:beanNames) {
			System.out.println(beanName);
		}
	}
}
