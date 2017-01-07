package com.dky.web.controller;

import com.dky.business.repository.biz.SysLogService;
import com.dky.business.repository.cache.RedisCacheManager;
import com.dky.common.bean.SysLog;
import com.dky.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by wangpeng on 2016/12/13.
 */
@RestController
@RequestMapping("sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @Autowired
    private RedisCacheManager redisCacheManager;


    private static final String CACHE_KEY = "redis_test";


    @RequestMapping("putRedis")
    public ReturnT putRedis(){
        long time  = System.currentTimeMillis();
        redisCacheManager.put(CACHE_KEY,time);
        return new ReturnT().sucessData(time);
    }


    @RequestMapping("getRedis")
    public ReturnT getRedis(){
        Long time = redisCacheManager.getLong(CACHE_KEY);
        return  new ReturnT().sucessData(time);
    }


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


    @RequestMapping("/exception")
    public void exception() throws Exception {
        throw new Exception("testException");
    }

    @RequestMapping("/date")
    public ReturnT<Date> dateReturnT(Date date){
        return new ReturnT<>().sucessData(date);
    }
}
