package cn.timebusker.service.I;

import cn.timebusker.entity.DemoInfo;

import java.util.List;

/**
 * DemoInfoService接口
 */
public interface DemoInfoService {

    // 添加DemoInfo
    List<DemoInfo> insertDemoInfo(DemoInfo demo);

    // 查找DemoInfo
    DemoInfo findDemoInfo(String id);

    // 更新DemoInfo
    List<DemoInfo> updateDemoInfo(DemoInfo demo);

    List<DemoInfo> deleteDemoInfo(DemoInfo demo);

    List<DemoInfo> findAll();
}
