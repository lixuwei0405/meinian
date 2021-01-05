package com.atguigu.entities;

import java.io.Serializable;

/**
 * @author lixw
 * @create 2021-01-04 14:33
 * 提交分页查询时用于封装请求的参数
 */
public class QueryPageBean implements Serializable {
    private Integer currentPage;

    private Integer pageSize;

    private String queryString;

    public QueryPageBean(Integer currentPage, Integer pageSize, String queryString) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.queryString = queryString;
    }

    public QueryPageBean() {
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    @Override
    public String toString() {
        return "QueryPageBean{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", queryString='" + queryString + '\'' +
                '}';
    }
}
