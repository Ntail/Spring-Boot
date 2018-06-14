package cn.timebusker.web;

import cn.timebusker.entity.User;
import cn.timebusker.service.UserService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/u")
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 在实现类使用@service注解
     */
    @Autowired
    UserService service;

    /**
     * 使用ID查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User findOneUser(@PathVariable long id){
        logger.info("传入的参数 ID:"+id);
        User u = service.findUserById(id);
        return u;
    }

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> findAllUser(){
        logger.info("查询所有用户信息");
        List<User> list = service.findAllUser();
        return list;
    }

    /**
     * 更新或者新增用户信息
     * @param user
     */
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public User saveAndFlushUser(@ModelAttribute User user){
        logger.info("传入的参数 user："+ JSON.toJSONString(user));
        service.saveAndFlush(user);
        return user;
    }

    /**
     *通过ID删除一个用户
     * @param id
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable long id){
        User user = service.findUserById(id);
        logger.info("查询到的user信息是："+JSON.toJSONString(user));
        service.deleteUserById(id);
        return user;
    }
}
