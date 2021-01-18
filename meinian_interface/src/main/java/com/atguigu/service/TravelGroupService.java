package com.atguigu.service;

import com.atguigu.entities.PageResult;
import com.atguigu.pojo.TravelGroup;

import java.util.List;

/**
 * @author lixw
 * @create 2021-01-05 14:53
 */
public interface TravelGroupService {
    void add(Integer[] travelItemIds, TravelGroup travelGroup);

    PageResult findPage(Integer currentPage, Integer pageSize, String queryString);

    TravelGroup get(Integer id);

    List<Integer> findTravelItemIdsByTravelGroupId(Integer id);

    void edit(Integer[] travelItemIds, TravelGroup travelGroup);

    void delete(Integer id);

    List<TravelGroup> findAll();
}
