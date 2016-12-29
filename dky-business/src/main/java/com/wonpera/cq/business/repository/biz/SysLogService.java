package com.wonpera.cq.business.repository.biz;

import com.wonpera.cq.common.bean.SysLog;
import com.wonpera.cq.common.response.PageList;
import com.wonpera.cq.common.response.ReturnT;

import java.util.List;

/**
 * Created by wangpeng on 2016/12/13.
 */
public interface SysLogService extends BaseService<SysLog,Integer> {

    public ReturnT<List<SysLog>> query(SysLog sysLog);

    public ReturnT<PageList<SysLog>> pageList(SysLog sysLog);
}
