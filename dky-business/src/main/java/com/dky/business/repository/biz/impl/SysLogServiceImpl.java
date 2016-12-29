package com.dky.business.repository.biz.impl;

import com.dky.business.repository.repository.BaseDao;
import com.dky.business.repository.repository.SysLogDao;
import com.dky.business.repository.biz.SysLogService;
import com.dky.common.bean.SysLog;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wangpeng on 2016/12/13.
 */
@Service
@Transactional
public class SysLogServiceImpl extends BaseServiceImpl<SysLog,Integer> implements SysLogService{

    @Autowired
    private SysLogDao sysLogDao;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ReturnT<List<SysLog>> query(SysLog sysLog) {
        List<SysLog> list = sysLogDao.query(sysLog);
        return new ReturnT<List<SysLog>>().sucessData(list);
    }

    @Override
    public ReturnT<PageList<SysLog>> pageList(SysLog sysLog) {
        PageList<SysLog> pageList = this.findByPage(sysLog);
        return new ReturnT<PageList<SysLog>>().sucessData(pageList);
    }


    @Override
    public ReturnT<List<SysLog>> queryList(SysLog sysLog){
        String sql = "SELECT * FROM log";
        List<SysLog> list = namedParameterJdbcTemplate.query(sql, new MapSqlParameterSource(), new BeanPropertyRowMapper<SysLog>(SysLog.class));
        return new ReturnT<>().sucessData(list);
    }


    @Override
    protected BaseDao<SysLog, Integer> getDao() {
        return sysLogDao;
    }
}
