package cn.timebusker.service.impl;

import cn.timebusker.dao.UserRepository;
import cn.timebusker.entity.User;
import cn.timebusker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "user-cache")
public class UserServiceImpl implements UserService{

    public static final String CACHE_KEY = "USERS_CACHE_KEY";

    @Autowired
    UserRepository repository;

    /**
     * 使用ID查询用户
     * @param id
     * @return
     */
    @Override
    @Cacheable(value = {})
    public User findUserById(long id) {
        // findOne2.0版本会报错
        User u = repository.findOne(id);
        return u;
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    @Cacheable
    public List<User> findAllUser() {
        List<User> list = repository.findAll();
        return list;
    }

    /**
     * 更新或新增用户信息
     * @param user
     */
    @Override
    @Cacheable
    public void saveAndFlush(User user) {
        repository.saveAndFlush(user);
    }

    /**
     * 通过ID删除一个用户
     * @param id
     */
    @Override
    @Cacheable
    public void deleteUserById(long id) {
        repository.delete(id);
    }
}
