package cn.timebusker.web;

import cn.timebusker.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Api("UserController接口")
@RestController
@RequestMapping("users")
public class UserController {

    static Map<Long,User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value = "获取用户列表",notes = "")
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> r = new ArrayList<>(users.values());
        return r;
    }

    @ApiOperation(value = "创建用户",notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user",value = "用户详细实体user",required = true,dataType = "User")
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String postUser(@RequestBody User user){
        users.put(user.getId(),user);
        return "seccess";
    }


}
