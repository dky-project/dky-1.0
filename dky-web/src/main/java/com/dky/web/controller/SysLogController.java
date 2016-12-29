package com.dky.web.controller;

import com.dky.business.repository.biz.SysLogService;
import com.dky.common.bean.SysLog;
import com.dky.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangpeng on 2016/12/13.
 */
@RestController
@RequestMapping("sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;


    @RequestMapping("list")
    public ReturnT getSysLogList(SysLog sysLog){
        return sysLogService.query(sysLog);
    }

    @RequestMapping("query")
    public ReturnT query(SysLog sysLog){
        return sysLogService.queryList(sysLog);
    }

    @RequestMapping("page")
    public ReturnT getPage(SysLog sysLog){
        return sysLogService.pageList(sysLog);
    }
}
