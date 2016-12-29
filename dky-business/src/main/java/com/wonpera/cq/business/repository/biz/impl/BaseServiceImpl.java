package com.wonpera.cq.business.repository.biz.impl;

import com.wonpera.cq.business.repository.biz.BaseService;
import com.wonpera.cq.business.repository.repository.BaseDao;
import com.wonpera.cq.common.bean.PojoObjectBase;
import com.wonpera.cq.common.constats.GlobConts;
import com.wonpera.cq.common.response.PageList;

/**
 * Created by wangpeng on 2016/12/13.
 */
public abstract class BaseServiceImpl<T,K> implements BaseService<T,K> {

    protected abstract BaseDao<T,K> getDao();

    public PageList<T> findByPage(T t) {
        if (this.getDao() != null && this.getDao() instanceof BaseDao) {
            if(t instanceof PojoObjectBase){
               if(((PojoObjectBase) t).getRequestOffset() == null && ((PojoObjectBase) t).getRequestCount() == null){
                   ((PojoObjectBase) t).setRequestOffset(0);
                   ((PojoObjectBase) t).setRequestCount(GlobConts.DEFUALT_PAGE_SIZE);
               }
            }
            return new PageList<T>(getDao().query(t), getDao().count(t), 0, 0);
        }
        return null;
    }
}
