package cn.timebusker.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("HelloController 接口")
@RestController
public class HelloController {

    /**
     * @Api用在类上，说明该类的作用
     *
     * @ApiOperation用在方法上，说明方法的作用
     *
     * @ApiImplicitParams用在方法上包含一组参数说明
     *
     * @ApiImplicitParam用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
     *      paramType>参数放在哪个地方 header-->请求参数的获取：@RequestHeader
     */

    @ApiOperation(value = "更新用户详细信息", notes = "根据URL来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(){
        return "Hello World";
    }
}
