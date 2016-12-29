package com.dky.business.repository.biz;

import com.dky.common.bean.SysLog;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;

import java.util.List;

/**
 * Created by wangpeng on 2016/12/13.
 */
public interface SysLogService extends BaseService<SysLog,Integer> {

    public ReturnT<List<SysLog>> query(SysLog sysLog);

    public ReturnT<PageList<SysLog>> pageList(SysLog sysLog);
}
