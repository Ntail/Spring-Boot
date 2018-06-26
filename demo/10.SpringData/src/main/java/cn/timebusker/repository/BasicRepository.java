package cn.timebusker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * spring data jpa 错误 Not an managed type: class java.lang.Object
 * spring data jpa 1.4.1.RELEASE及以下版本定义了一个基本接口,
 * 升级到1.5.1RELEASE及以上的版本
 * 添加注解 @NoRepositoryBean
 */
@NoRepositoryBean
public interface BasicRepository<T,ID extends Serializable> extends JpaRepository<T,ID> {


}
