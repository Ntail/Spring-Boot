package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class LogbackApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(LogbackApplication.class, args);
		System.out.println("打印springBoot所有的bean");
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for(String beanName:beanNames){
			System.out.println(beanName);
		}
	}
}
