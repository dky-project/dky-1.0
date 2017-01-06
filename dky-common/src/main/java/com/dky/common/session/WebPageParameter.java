package com.dky.common.session;

import com.dky.common.constats.GlobConts;

/**
 * Created by wonpera on 2017/1/6.
 */
public class WebPageParameter extends SessionParameter {

    public Integer requestOffset;
    public Integer requestCount;

    private Integer pageIndex = 0;

    private Integer pageSize = GlobConts.DEFUALT_PAGE_SIZE;

    public Integer getRequestOffset() {
        return requestOffset;
    }

    public void setRequestOffset(Integer requestOffset) {
        this.requestOffset = requestOffset;
    }

    public Integer getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(Integer requestCount) {
        this.requestCount = requestCount;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
