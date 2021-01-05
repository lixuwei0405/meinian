package com.atguigu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.dao.TravelGroupDao;
import com.atguigu.entities.PageResult;
import com.atguigu.pojo.TravelGroup;
import com.atguigu.service.TravelGroupService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lixw
 * @create 2021-01-05 14:53
 */
@Service(interfaceClass = TravelGroupService.class)
@Transactional
public class TravelGroupServiceImpl implements TravelGroupService {
    @Autowired
    private TravelGroupDao travelGroupDao;

    @Override
    public void edit(Integer[] travelItemIds, TravelGroup travelGroup) {
        travelGroupDao.edit(travelGroup);
        //先删除此跟团游的中间表
        travelGroupDao.deleteTravelGroupAndTravelItemByGroupId(travelGroup.getId());
        //再重新添加该跟团游的中间表数据
        setTravelGroupAndTravelItem(travelItemIds,travelGroup.getId());
    }

    @Override
    public void delete(Integer id) {
        travelGroupDao.deleteTravelGroupAndTravelItemByGroupId(id);
        travelGroupDao.deleteTravelGroupById(id);
    }

    @Override
    public TravelGroup get(Integer id) {
        return travelGroupDao.get(id);
    }

    @Override
    public List<Integer> findTravelItemIdsByTravelGroupId(Integer id) {
        return travelGroupDao.findTravelItemIdsByTravelGroupId(id);
    }



    @Override
    public void add(Integer[] travelItemIds, TravelGroup travelGroup) {
        //添加跟团游数据
        travelGroupDao.add(travelGroup);
        //中间表插入数据   一个跟团游对应多个自由行
        setTravelGroupAndTravelItem(travelItemIds,travelGroup.getId());
    }

    @Override
    public PageResult findPage(Integer currentPage, Integer pageSize, String queryString) {
        //开启分页功能
        PageHelper.startPage(currentPage,pageSize);
        Page<TravelGroup> page = travelGroupDao.findPage(queryString);
        return new PageResult(page.getTotal(),page.getResult());
    }


    private void setTravelGroupAndTravelItem(Integer[] travelItemIds, Integer travelGroupId) {
        if(travelItemIds!=null && travelItemIds.length>0){
            for (Integer travelItemId : travelItemIds) {
                Map<String,Integer> map = new HashMap<>();
                map.put("travelItem",travelItemId);
                map.put("travelGroupId",travelGroupId);
                travelGroupDao.addTravelGroupAndTravelItem(map);
            }
        }
    }
}
