package com.wonpera.cq.business.repository.biz;

import com.wonpera.cq.common.response.PageList;

/**
 * Created by wangpeng on 2016/12/13.
 */
public interface BaseService<T,K> {

    /**
     * 分页查询
     *
     * @param t
     * @return
     */
    public PageList<T> findByPage(T t);
}
