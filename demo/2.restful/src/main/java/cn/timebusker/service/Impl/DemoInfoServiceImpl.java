package cn.timebusker.service.Impl;

import cn.timebusker.dao.DemoInfoDao;
import cn.timebusker.entity.DemoInfo;
import cn.timebusker.service.I.DemoInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoInfoServiceImpl implements DemoInfoService{

    @Resource
    DemoInfoDao dao;

    // 使用快捷键自动生成的方法
    @Override
    public List<DemoInfo> insertDemoInfo(DemoInfo demo) {
        return dao.insertDemoInfo(demo);
    }

    @Override
    public DemoInfo findDemoInfo(String id) {
        return dao.findDemoInfo(id);
    }

    @Override
    public List<DemoInfo> updateDemoInfo(DemoInfo demo) {
        return dao.updateDemoInfo(demo);
    }

    @Override
    public List<DemoInfo> deleteDemoInfo(DemoInfo demo) {
        return dao.deleteDemoInfo(demo);
    }

    @Override
    public List<DemoInfo> findAll() {
        return dao.findAll();
    }
}
