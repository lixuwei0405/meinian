package com.atguigu.dao;

import com.atguigu.pojo.TravelGroup;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

/**
 * @author lixw
 * @create 2021-01-05 14:53
 */
public interface TravelGroupDao {
    void add(TravelGroup travelGroup);

    void addTravelGroupAndTravelItem(Map<String, Integer> map);

    Page<TravelGroup> findPage(String queryString);

    TravelGroup get(Integer id);

    List<Integer> findTravelItemIdsByTravelGroupId(Integer id);

    void edit(TravelGroup travelGroup);

    void deleteTravelGroupAndTravelItemByGroupId(Integer id);

    void deleteTravelGroupById(Integer id);
}
