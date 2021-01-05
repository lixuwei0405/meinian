package com.atguigu.service;

import com.atguigu.entities.PageResult;
import com.atguigu.entities.Result;
import com.atguigu.pojo.TravelItem;

import java.util.List;

/**
 * @author lixw
 * @create 2021-01-04 14:47
 */
public interface TravelItemService {
    void add(TravelItem travelItem);

    PageResult findPage(Integer currentPage, Integer pageSize, String queryString);

    void delete(Integer id);

    TravelItem getById(Integer id);

    void edit(TravelItem travelItem);

    List<TravelItem> findAll();
}
