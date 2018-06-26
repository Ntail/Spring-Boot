package cn.timebusker.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 注释
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface timebuskerBean {

    public abstract String value() default "";
}
