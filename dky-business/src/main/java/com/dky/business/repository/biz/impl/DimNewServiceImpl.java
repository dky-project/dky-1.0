package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.DimNewService;
import com.dky.business.repository.cache.LoadingCacheManager;
import com.dky.business.repository.repository.DimNewMapper;
import com.dky.business.repository.repository.UsersMapper;
import com.dky.common.param.ProductApproveDetailParam;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.DimNewView;
import com.dky.common.response.view.ProductApproveTitleView;
import com.dky.common.utils.DateUtils;
import com.google.common.cache.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;


/**
 * Created by wangpeng on 2017/1/10.
 */
@Service
public class DimNewServiceImpl implements DimNewService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DimNewServiceImpl.class);

    public static LoadingCache<String,ReturnT<List<DimNewView>>> dictCahceBuilder;

    @Autowired
    private DimNewMapper mapper;
    @Autowired
    private UsersMapper usersMapper;

    @PostConstruct
    public void init(){
        dictCahceBuilder = loadingCache();
    }

    public synchronized  LoadingCache<String,ReturnT<List<DimNewView>>> loadingCache(){
        return LoadingCacheManager.cached(new CacheLoader<String, ReturnT<List<DimNewView>>>() {
            @Override
            public ReturnT<List<DimNewView>> load(String key) throws Exception {
                return new ReturnT<List<DimNewView>>().sucessData(mapper.queryByDimFlag(key));
            }
        });
    }

    @Override
    public ReturnT<List<DimNewView>> queryByDimFlag(String dimFlag) {
        try {
            if(dictCahceBuilder == null){
                init();
            }
            return dictCahceBuilder.get(dimFlag);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
            return new ReturnT<>().failureData("获取数据失败");
        }
    }

    @Override
    public ReturnT<ProductApproveTitleView> getProductApproveTitle(ProductApproveDetailParam param) {
        ProductApproveTitleView view = new ProductApproveTitleView();
        view.setSendDate(mapper.getSendDate());
        Map<String,String> map = usersMapper.getStoreCodeByEmail(param.getSessionUser().getEmail());
        view.setCode(map.get("CODE"));
        view.setUserName(map.get("USERNAME"));
        view.setCzDate(DateUtils.formatNowDate(DateUtils.FORMAT_YYYYMMDD));
        view.setOrderNo(DateUtils.formatNowDate(DateUtils.FORMAT_YYYYMMDDHHMMSS));
        view.setDimList(mapper.getDimClob());
        ReturnT<ProductApproveTitleView> returnT = new ReturnT<>();
        returnT.setData(view);
        return returnT.successDefault();
    }
}
