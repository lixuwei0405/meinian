package com.atguigu.entities;

import java.io.Serializable;
import java.util.List;

/**
 * @author lixw
 * @create 2021-01-04 14:32
 * 封装分页数据
 */
public class PageResult implements Serializable {
    private Long total;

    private List rows;

    public PageResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
