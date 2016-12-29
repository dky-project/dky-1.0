package com.wonpera.cq.web.controller;

import com.wonpera.cq.business.repository.biz.SysLogService;
import com.wonpera.cq.common.bean.SysLog;
import com.wonpera.cq.common.response.ReturnT;
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

    @RequestMapping("page")
    public ReturnT getPage(SysLog sysLog){
        return sysLogService.pageList(sysLog);
    }
}
