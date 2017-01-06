package com.dky.common.response;

import com.dky.common.constats.GlobConts;

import java.util.List;

/**
 * Created by wangpeng on 2016/12/13.
 */
public class PageList<T> {

    private List<T> items;

    private Integer total;

    private Integer pageIndex = 0;

    private Integer pageSize = GlobConts.DEFUALT_PAGE_SIZE;

    public PageList(List<T> items, Integer total, Integer pageIndex, Integer pageSize) {
        this.items = items;
        this.total = total;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }
    public PageList(List<T> items, Integer total) {
        this.items = items;
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
