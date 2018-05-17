package cn.timebusker.conf;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebConfig extends WebMvcConfigurerAdapter{

    /**
     * WebMvcConfigurerAdapter 实现了WebMvcConfigurer类
     * WebMvcConfigurerAdapter  在Spring5已被废弃，目前的解决方案有两种
     *
     * 1.直接实现：WebMvcConfigurer(官方推荐)
     *
     * 2.直接继承：WebMvcConfigurationSupport
     *
     * 我们可以在此做一些配置信息：
     * 1.拦截器
     *
     */
	
}
