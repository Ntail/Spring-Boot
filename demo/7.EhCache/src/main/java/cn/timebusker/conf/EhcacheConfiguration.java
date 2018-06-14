package cn.timebusker.conf;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.lang.reflect.Method;

public class EhcacheConfiguration implements CachingConfigurer {

    /**
     * ehcache 主要的管理器
     * @return
     */
    @Bean
    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean){
        return new EhCacheCacheManager(bean.getObject());
    }

    /**
     * 据shared与否的设置，spring分别通过cacheManager.create()或new CacheManager()方式来创建一个ehcache基地
     * @return
     */
    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        // 设置cache的基地是spring独立用，还是与hisbernate的Ehcache共享
        cacheManagerFactoryBean.setShared(true);
        return cacheManagerFactoryBean;
    }

    /**
     * 制定生成缓存key策略，在默认情况下，将直接使用该策略
     * @return
     */
    @Bean
    public KeyGenerator defaultKeyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                // 生成 类名 + 方法名 + 参数 的key
                StringBuilder builder = new StringBuilder();
                builder.append(target.getClass().getName());
                builder.append(method.getName());
                for(Object obj:params){
                    builder.append(obj.toString());
                }
                return builder.toString();
            }
        };
    }

    @Bean
    @Override
    public CacheManager cacheManager() {
        EhCacheCacheManager cacheCacheManager = new EhCacheCacheManager();
        return cacheCacheManager;
    }

    @Override
    public CacheResolver cacheResolver() {
        // TODO auto-generated method stud
        return null;
    }

    @Override
    public KeyGenerator keyGenerator() {
        // TODO auto-generated method stud
        return null;
    }

    @Override
    public CacheErrorHandler errorHandler() {
        // TODO auto-generated method stud
        return null;
    }
}
