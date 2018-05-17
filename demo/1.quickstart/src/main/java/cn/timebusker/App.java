package cn.timebusker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class App {

    /**
     * @SpringBootApplication 注解的类一定要放在自定义的包下且属于自定义包的
     *
     * @SpringBootApplication 是一个方便的注解，增加了以下所有类容：
     *
     * @Configuration 标记一个类来作为bean定义的应用程序的上下文资源
     *
     * @EnableAutoConfiguration 告诉Spring boot开始加载基于类路径下的配置信息、beans、各种属性配置
     *通常你会添加@EnableWebMvc为spring MVC的应用程序，但是当Spring boot在classpath下检索到spring-webmvc时，
     * spring boot会自动添加。这标志该应用作为web应用程序，并激活关键行为，如设立的DIspatcherServlet
     *
     * @ComponentScan 告诉Spring寻找其他组建，配置，以及业务层类，最前面才能加载到所有的类
     */

    public static void main(String[] args) {

        /**
         * devtools:是spring boot的一个热部署工具
         * 设置spring.devtool.restart.enabled属性为false可关闭该特性
         * System.setProperty("spring.devtools.restart.enabled","false")
         */

        // 启动Spring boot
        ApplicationContext act = SpringApplication.run(App.class,args);
        //System.out.println("Let's inspect the beans provided by Spring Boot:");
        System.out.println("让我们检查Spring Boot提供的bean:");
        String[] beanNames = act.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for(String beanName:beanNames){
            System.out.println(beanName);
        }
    }
}
