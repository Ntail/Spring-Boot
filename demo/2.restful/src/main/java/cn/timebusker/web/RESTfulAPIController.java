package cn.timebusker.web;

import cn.timebusker.entity.DemoInfo;
import cn.timebusker.service.Impl.DemoInfoServiceImpl;
import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RESTfulAPIController {

    @Resource
    DemoInfoServiceImpl service;

    /**
     * GET(SELECT)：从服务器取出资源（一项或多项）
     * POST(CREATE)：在服务器新建一个资源
     * PUT(UPDATE)：在服务器更新资源(客户端提供改变后的完整资源)
     * PATCH(UPDATE):在服务器更新资源(客户端提供改变的属性)
     * DELETE(DELETE)：从服务器删除资源
     */

    @RequestMapping(value = {"/demo"},method = RequestMethod.POST)
    public List<DemoInfo> addDemoInfo(@ModelAttribute DemoInfo demo){
        // POST请求，用来创建DemoInfo
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        System.out.println(JSON.toJSONString(demo));
        return service.insertDemoInfo(demo);
    }

    @RequestMapping(value = {"/demo-requestParam"},method = RequestMethod.POST)
    public List<DemoInfo> insertDemoInfo(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("description") String description){
        DemoInfo demo = new DemoInfo();
        demo.setId(id);
        demo.setName(name);
        demo.setDescription(description);
        System.out.println(JSON.toJSONString(demo));
        return service.insertDemoInfo(demo);
    }

    @RequestMapping(value = "/demo/{id}",method = RequestMethod.GET)
    public DemoInfo findDemoInfo(@PathVariable String id){
        // GET 请求，用来获取信息
        // url 中的id可通过@PathVariable绑定导函数的参数中
        return service.findDemoInfo(id);
    }

    @RequestMapping(value = "/demo/{id}",method = RequestMethod.PUT)
    public List<DemoInfo> updataDemoInfo(@PathVariable String id){
        // PUT请求，用来更新信息
        DemoInfo demo = new DemoInfo();
        demo.setId(id);
        demo.setDescription("我是第"+id+"ST");
        demo.setName("TS_"+id);
        return service.updateDemoInfo(demo);
    }

    @RequestMapping(value = "/demo/{id}",method = RequestMethod.DELETE)
    public List<DemoInfo> deleteDemoInfo(@PathVariable String id){
        // DELETE请求，用来删除信息
        DemoInfo demo = new DemoInfo();
        demo.setId(id);
        System.out.println("demo的值是:" + demo + "，当前方法=RESTfulAPIController.deleteDemoInfo()");
        return service.deleteDemoInfo(demo);
    }

    @RequestMapping(value = {"/demos","/"},method = RequestMethod.GET)
    public List<DemoInfo> findAll(){
        // GET请求，用来获取信息
        return service.findAll();
    }
}
