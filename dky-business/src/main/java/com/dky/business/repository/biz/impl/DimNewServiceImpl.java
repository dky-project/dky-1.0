package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.DimNewService;
import com.dky.business.repository.repository.DimNewMapper;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.DimNewView;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangpeng on 2017/1/10.
 */
@Service
public class DimNewServiceImpl implements DimNewService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DimNewServiceImpl.class);

    //public static LoadingCache<String, ReturnT<List<DimNewView>>> dictCahceBuilder;

    @Autowired
    private DimNewMapper mapper;

    @Override
    public ReturnT<List<DimNewView>> queryByDimFlag(final String dimFlag) {
        return new ReturnT<List<DimNewView>>().sucessData(mapper.queryByDimFlag(dimFlag));
        /*try {
            if((dictCahceBuilder != null) && dictCahceBuilder.get(dimFlag) != null){
                LOGGER.debug("从缓存中获取{}数据",dimFlag);
                return dictCahceBuilder.get(dimFlag);
            }else {
                return getCacheBuilder(new CacheLoader<String, ReturnT<List<DimNewView>>>(){
                    @Override
                    public ReturnT<List<DimNewView>> load(String key) throws Exception {
                        return new ReturnT<List<DimNewView>>().sucessData(mapper.queryByDimFlag(dimFlag));
                    }
                }).get(dimFlag);
            }
        }catch (Exception e){
            LOGGER.error(e.getMessage(),e);
            return new ReturnT<>().failureData("查询数据字典出错");
        }*/
    }



    /*public static synchronized LoadingCache<String,ReturnT<List<DimNewView>>> getCacheBuilder(CacheLoader<String, ReturnT<List<DimNewView>>> cacheLoader) {
        dictCahceBuilder = CacheBuilder
                .newBuilder()
                .weakKeys()
                .softValues()
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .refreshAfterWrite(1, TimeUnit.MINUTES)
                .build(cacheLoader);
        return dictCahceBuilder;
    }*/
}
