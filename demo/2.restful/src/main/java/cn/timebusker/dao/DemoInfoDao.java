package cn.timebusker.dao;

import cn.timebusker.entity.DemoInfo;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @Repository 用于标注数据访问组建，即Dao组建
 */
@Repository
public class DemoInfoDao {

    // 创建一个线程安全的Map
    public static Map<String,DemoInfo> map = Collections.synchronizedMap(new HashMap<String,DemoInfo>());

    static {
        for(int i=0;i<10;i++){
            DemoInfo demoInfo = new DemoInfo();
            demoInfo.setId(++i+"");// 1,2,3,4,5,6,7,8,9,10
            demoInfo.setName("mine"+i);
            demoInfo.setDescription("我是第"+i+"个同学！");
            map.put(i+"",demoInfo);
        }
        System.out.println("map的值是:" + map + "，当前方法=DemoInfoDao.static initializer()");
    }

    // 添加数据
    public List<DemoInfo> insertDemoInfo(DemoInfo demo){
        System.out.println("demo的值是:" + demo + "，当前方法=DemoInfoDao.insertDemoInfo()");
        map.put(demo.getId(),demo);
        List<DemoInfo> list = getListDemoInfo(map);
        return list;
    }

    // 查找数据
    public DemoInfo findDemoInfo(String id){
        DemoInfo demo = map.get(id);
        return demo;
    }

    // 更新数据
    public List<DemoInfo> updateDemoInfo(DemoInfo demo){
        /**
         * replace Map在java8中新增了两个replace方法
         *
         * 1.replace(k,v)
         *  在指定的键已经存在并且有与之相关的映射值时才会将指定的键映射到指定的值（新值）
         *  在指定的键不存在时，方法会return回来一个null
         *
         * 2.replace(k,v,v)
         *  只有在指定的键和值都匹配的时候才会替换
         */

        map.replace(demo.getId(),demo);
        List<DemoInfo> list = getListDemoInfo(map);
        return list;
    }

    // 查找所有数据
    public List<DemoInfo> deleteDemoInfo(DemoInfo demo){
        map.remove(demo.getId());
        List<DemoInfo> list = getListDemoInfo(map);
        return list;
    }

    // 查找所有数据
    public List<DemoInfo> findAll(){
        List<DemoInfo> list = getListDemoInfo(map);
        return list;
    }

    private List<DemoInfo> getListDemoInfo(Map<String,DemoInfo> map){
        /**
         *   Map集合中提供了get() 获取元素的方法， get()对应一个键取出其对应 的值，这种方式比较局限和单一，
         *   不能全部取出来 。要取出所有的元素（值），则必须要拿到所有的键，然后才能取到所有与其对应的值，
         *   针对这种新的需求，Java中提供了相应的解决方案
         * Map集合中提供了两种取出方式：
         * <1>.  返回值类型Set<k>    方法是： keySet()   :返回此映射中包含的键的 Set 视图
         * 将map中所有的键存入到Set集合，因为set具备迭代器，所有迭代方式取出所有的键
         * 再根据get()方法  ，获取每一个键对应的值
         *
         * <2>.  返回值类型：Set<Map.Entry<K,V>>方法是：entrySet()
         * 取出的是关系，关系中包含key和value,其中Map.Entry<k,V>来表示这种数据类型
         * 即：将map集合中的映射关系存入到set集合中，这个关系的数据类型为:Map.Entry
         *
         * Map.Entry接口
         *    此接口在java.util包中，其实Entry也是一个接口，它是Map接口中的一个内部接口  ,
         *     getKey()和getValue是接口Map.Entry<K,V>中的方法，返回对应的键和对应的值
         *     Map集合中是没有迭代器 的  ,Map集合取出键值的原理：将map集合转成set集合，再通过迭代器取出
         */
        Set<String> set = map.keySet();
        List<DemoInfo> list = new ArrayList<>();
        for(String string:set){
            DemoInfo demo = map.get(string);
            list.add(demo);
        }
        return list;
    }

}
