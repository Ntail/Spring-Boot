package cn.timebusker.dao;

import cn.timebusker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    /**
     *通过用户名查询用户
     * @param name
     * @return
     */
    User findByName(String name);

    /**
     * 通过用户ID查询用户
     * @param id
     * @return
     */
    User findById(String id);
}
