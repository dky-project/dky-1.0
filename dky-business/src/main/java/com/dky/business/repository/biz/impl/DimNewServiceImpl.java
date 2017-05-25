package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.DimNewService;
import com.dky.business.repository.cache.LoadingCacheManager;
import com.dky.business.repository.repository.DimNewMapper;
import com.dky.business.repository.repository.ProductApproveMapper;
import com.dky.business.repository.repository.ProductMapper;
import com.dky.business.repository.repository.UsersMapper;
import com.dky.common.constats.GlobConts;
import com.dky.common.param.*;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.DimNewView;
import com.dky.common.response.view.ProductApproveTitleView;
import com.dky.common.response.view.ProductColorView;
import com.dky.common.utils.DateUtils;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
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
    @Autowired
    private ProductApproveMapper productApproveMapper;
    @Autowired
    private ProductMapper productMapper;

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
    public ReturnT<List<DimNewView>> queryByDimText(String dimText) {
        return new ReturnT<List<DimNewView>>().sucessData(mapper.queryDimByDimText(dimText));
    }

    @Override
    public ReturnT<ProductApproveTitleView> getProductApproveTitle(ProductApproveDetailParam param) {
        ProductApproveTitleView view = new ProductApproveTitleView();
        view.setSendDate(mapper.getSendDate());
        Map<String,String> map = usersMapper.getStoreCodeByEmail(param.getSessionUser().getEmail());
        view.setCode(map!=null?map.get("CODE"):param.getSessionUser().getEmail());
        view.setUserName(map!=null?map.get("USERNAME"):"");
        view.setCzDate(DateUtils.formatNowDate(DateUtils.FORMAT_YYYYMMDD));
        view.setOrderNo(DateUtils.formatNowDate(DateUtils.FORMAT_YYYYMMDDHHMMSS));
        view.setDimList(mapper.getDimClob());
        view.setStaticDimList(GlobConts.dimList);
        view.setNo(productApproveMapper.getMaxNo(view.getCode(),view.getCzDate()));
        ReturnT<ProductApproveTitleView> returnT = new ReturnT<>();
        returnT.setData(view);
        return returnT.successDefault();
    }

    @Override
    public ReturnT getpzsJson(PzsJsonQueryParam param) {
        String result = mapper.getpzsJson(param);
        if(StringUtils.isNoneEmpty(result)){
            result = result.replaceAll("'","\"");
        }
        JSONObject jsonObject  = new JSONObject();

        ReturnT returnT = new ReturnT();
        returnT.setData(jsonObject.fromObject(result));
        return returnT.successDefault();
    }

    @Override
    public ReturnT<List<ProductColorView>> getColorList(ColorQueryParam param) {
        List<ProductColorView> colorList = productMapper.getProductColorListByDimId(param.getmDimNew14Id());
        ReturnT<List<ProductColorView>> returnT = new ReturnT<>();
        returnT.setData(colorList);
        return returnT.successDefault();
    }

    @Override
    public ReturnT<List<ProductColorView>> getColorDimList(ColorDimQueryParam param) {
        List<ProductColorView> colorList = productMapper.getColorDimListByProductId(param.getmProductId());
        ReturnT<List<ProductColorView>> returnT = new ReturnT<>();
        returnT.setData(colorList);
        return returnT.successDefault();
    }

    @Override
    public ReturnT getSizeData(SizeDataQueryParam param) {
        ReturnT returnT = new ReturnT();
        String jsonStr = mapper.getSizeData(param.getPdt(),param.getXwValue());
        returnT.setData(JSONObject.fromObject(jsonStr));
        return returnT.successDefault();
    }
}
