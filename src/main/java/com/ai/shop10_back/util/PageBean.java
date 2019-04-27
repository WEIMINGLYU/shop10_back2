package com.ai.shop10_back.util;


import java.util.List;

public class PageBean<T> {
    private List<T> list;
    private Integer pageNow =1;
    private Integer pageSize;
    private Integer rowCount;
    private Integer pageCount;
    private Integer startLimit;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getStartLimit() {
        return startLimit;
    }

    public void setStartLimit(Integer startLimit) {
        this.startLimit = startLimit;
    }
}
