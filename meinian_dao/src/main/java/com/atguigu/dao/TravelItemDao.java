package com.atguigu.dao;

import com.atguigu.entities.PageResult;
import com.atguigu.entities.Result;
import com.atguigu.pojo.TravelItem;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lixw
 * @create 2021-01-04 14:48
 */
public interface TravelItemDao {
    void add(TravelItem travelItem);

    Page<TravelItem> findPage(@Param("queryString") String queryString);

    void delete(Integer id);

    TravelItem getById(Integer id);

    void edit(TravelItem travelItem);

    int findCountByTravelItemId(Integer id);

    List<TravelItem> findAll();

    //增加辅助方法
    //根据跟团游的id查询自由行集合
    List<TravelItem> findTravelItemById(Integer id);
}
