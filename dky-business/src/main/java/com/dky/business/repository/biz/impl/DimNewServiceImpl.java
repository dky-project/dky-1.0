package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.DimNewService;
import com.dky.business.repository.cache.RedisCacheManager;
import com.dky.business.repository.repository.DimNewMapper;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.DimNewView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangpeng on 2017/1/10.
 */
@Service
public class DimNewServiceImpl implements DimNewService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DimNewServiceImpl.class);


    @Autowired
    private DimNewMapper mapper;

    @Autowired
    private RedisCacheManager redisCacheManager;

    @Override
    public ReturnT<List<DimNewView>> queryByDimFlag(String dimFlag) {
        ReturnT<List<DimNewView>> returnT = (ReturnT)redisCacheManager.get(dimFlag);
        if(redisCacheManager.get(dimFlag) != null){
            LOGGER.info("[{}]loading from cache",dimFlag);
            return returnT;
        }
        ReturnT result = new ReturnT().sucessData(mapper.queryByDimFlag(dimFlag));
        redisCacheManager.put(dimFlag,result,60*1000L);
        return result;
    }

}
