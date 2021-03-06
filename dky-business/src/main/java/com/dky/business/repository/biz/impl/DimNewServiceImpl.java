package com.dky.business.repository.biz.impl;

import com.alibaba.fastjson.JSONObject;
import com.dky.business.repository.biz.DimNewService;
import com.dky.business.repository.cache.LoadingCacheManager;
import com.dky.business.repository.repository.DimNewMapper;
import com.dky.business.repository.repository.ProductApproveMapper;
import com.dky.business.repository.repository.ProductMapper;
import com.dky.business.repository.repository.UsersMapper;
import com.dky.common.constats.GlobConts;
import com.dky.common.enums.DataTableEnum;
import com.dky.common.enums.FlagEnum;
import com.dky.common.param.*;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.*;
import com.dky.common.utils.DateUtils;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.HashMap;
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
    public ReturnT<List<DimNewView>> queryDefaultDimByDimText(String dimText) {
        return new ReturnT<List<DimNewView>>().sucessData(mapper.queryDefaultDimByDimText(dimText));
    }

    @Override
    public ReturnT<ProductApproveTitleView> getProductApproveTitle(ProductApproveDetailParam param) {
        ProductApproveTitleView view = new ProductApproveTitleView();
        view.setSendDate(mapper.getSendDate());
        Map<String,String> map = usersMapper.getStoreCodeByEmail(param.getSessionUser().getEmail());
        view.setCode(map!=null?map.get("CODE"):param.getSessionUser().getEmail());
        view.setUserName(map!=null?map.get("USERNAME"):"");
        view.setCzDate(DateUtils.formatNowDate(DateUtils.FORMAT_YYYYMMDD));
        view.setOrderNo(productApproveMapper.getProductApproveDocno());
        view.setDimList(mapper.getDimClob());
        view.setStaticDimList(GlobConts.dimList);
        view.setNo(productApproveMapper.getMaxNo(view.getCode(),view.getCzDate()));
        ReturnT<ProductApproveTitleView> returnT = new ReturnT<>();
        returnT.setData(view);
        return returnT.successDefault();
    }

    @Override
    public ReturnT<PzJsonResultView> getpzsJson(PzsJsonQueryParam param) {
        PzJsonResultView view = new PzJsonResultView();
        if (FlagEnum.ZZFLAG.getCode().equals(param.getFlag())){
            String result = mapper.getpzsJson(param);
            if(StringUtils.isNoneEmpty(result)){
                result = result.replaceAll("'","\"");
                view.setZzJson(JSONObject.parseObject(result).getString("value"));
            }
            if (param.getmDimNew15Id() == null){
                JSONObject json = (JSONObject)view.getZzJson().get(0);
                param.setmDimNew15Id(Long.valueOf(json.get("id").toString()));
            }
            param.setFlag(FlagEnum.ZXFLAG.getCode());
            result = mapper.getpzsJson(param);
            if(StringUtils.isNoneEmpty(result)){
                result = result.replaceAll("'","\"");
                view.setZxJson(JSONObject.parseObject(result).getString("value"));
            }
            if (param.getmDimNew16Id() != null){
                param.setFlag(FlagEnum.ZBFLAG.getCode());
                result = mapper.getpzsJson(param);
                if(StringUtils.isNoneEmpty(result)){
                    result = result.replaceAll("'","\"");
                    view.setZbJson(JSONObject.parseObject(result).getString("value"));
                }
            }
        }else if (FlagEnum.ZXFLAG.getCode().equals(param.getFlag())){
            String result = mapper.getpzsJson(param);
            if(StringUtils.isNoneEmpty(result)){
                result = result.replaceAll("'","\"");
                view.setZxJson(JSONObject.parseObject(result).getString("value"));
            }
            param.setFlag(FlagEnum.ZBFLAG.getCode());
            result = mapper.getpzsJson(param);
            if(StringUtils.isNoneEmpty(result)){
                result = result.replaceAll("'","\"");
                view.setZbJson(JSONObject.parseObject(result).getString("value"));
            }
        }else if(FlagEnum.ZBFLAG.getCode().equals(param.getFlag())){
            String result = mapper.getpzsJson(param);
            if(StringUtils.isNoneEmpty(result)){
                result = result.replaceAll("'","\"");
                view.setZbJson(JSONObject.parseObject(result).getString("value"));
            }
        }
        ReturnT returnT = new ReturnT();
        returnT.setData(view);
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
    public ReturnT getColorDimList(ColorDimQueryParam param) {
        List<ProductColorView> colorRangeList = mapper.getColorListByDimIdAndProductId(param.getmProductId(),param.getmDimNew14Id());
        if (!"".equals(param.getGroupNo()) && null != param.getGroupNo()){
            String colorName = mapper.getColorDefaultByGroupNo(param.getGroupNo(), param.getmProductId(),param.getmDimNew14Id());
            for (ProductColorView colorView : colorRangeList){
                if (colorView.getColorName().equals(colorName)){
                    colorView.setIsDefault("Y");
                }
            }
        }else{
            String colorName = mapper.getColorRangeDefault(param.getmProductId(),param.getmDimNew14Id());
            for (ProductColorView colorView : colorRangeList){
                if (colorView.getColorName().equals(colorName)){
                    colorView.setIsDefault("Y");
                }
            }
        }
        List<ProductColorView> colorList = productMapper.getProductColorListByDimId(param.getmDimNew14Id());
        ReturnT returnT = new ReturnT<>();
        Map<String,Object> map = new HashMap<>();
        map.put("colorRangeViewList",colorRangeList);
        map.put("colorViewList",colorList);
        returnT.setData(map);
        return returnT.successDefault();
    }

    @Override
    public ReturnT getSizeData(SizeDataQueryParam param) {
        ReturnT returnT = new ReturnT();
        String jsonStr = mapper.getSizeData(param.getPdt(),param.getXwValue());
        returnT.setData(JSONObject.parseObject(jsonStr));
        return returnT.successDefault();
    }

    @Override
    public ReturnT getProductPrice(ProductPriceQueryParam param) {
        BigDecimal price;
        Map<String,String> userMap = usersMapper.getStoreCodeByEmail(param.getSessionUser().getEmail());
        String code = userMap!=null?userMap.get("CODE"):param.getSessionUser().getEmail();
        if ("C".equals(param.getMptbelongtype())){
            price = productMapper.getMpdtProductPrice(param.getPdtId());
        }else{
            Map<String,Object> map = new HashedMap();
            map.put("V_PZ",param.getmDimNew14Id());
            map.put("V_ZX",param.getmDimNew16Id());
            map.put("V_XW_VALUE",param.getXwValue());
            map.put("V_XC_VALUE",param.getXcValue());
            map.put("V_YC_VALUE1",param.getYcValue());
            map.put("V_JGNO",code);
            map.put("V_PDT",param.getPdt());
            productMapper.getProductPrice(map);
            price = new BigDecimal(map.get("v_price_out").toString());
        }
        ReturnT returnT = new ReturnT();
        returnT.setData(price);
        return returnT.successDefault();
    }

    @Override
    public ReturnT getDataAnalysisList(DataAnalysisParam param) {
        Map<String,String> userMap = usersMapper.getStoreCodeByEmail(param.getSessionUser().getEmail());
        String code = userMap!=null?userMap.get("CODE"):param.getSessionUser().getEmail();
        ReturnT returnT = new ReturnT();
        HashMap<String,Object> map = new HashMap<>();
        for (DataTableEnum type : DataTableEnum.values()){
            map.put(type.getCode(),mapper.getDataAnalysisList(type.getMessage(),code));
        }
        Map<String, Object> totalMap = mapper.getDataAnalysisMapTotal(code);
        Map<String, Object> dataAnalysisMap = mapper.getDataAnalysisMap(code);
        if (dataAnalysisMap != null){
            totalMap.put("GHPRICE",dataAnalysisMap.get("GHPRICE") == null ? 0:dataAnalysisMap.get("GHPRICE"));
            totalMap.put("FLPRICE",dataAnalysisMap.get("FLPRICE") == null ? 0:dataAnalysisMap.get("FLPRICE"));
            totalMap.put("AFTERAMOUNT",dataAnalysisMap.get("AFTERAMOUNT") == null ? 0:dataAnalysisMap.get("AFTERAMOUNT"));
        }else{
            if (totalMap == null){
                totalMap = new HashMap<>();
                totalMap.put("QTY",0);
                totalMap.put("TOTALAMOUNT",0);
            }
            totalMap.put("GHPRICE",0);
            totalMap.put("FLPRICE",0);
            totalMap.put("AFTERAMOUNT",0);
        }
        map.put("total",totalMap);
        returnT.setData(map);
        return returnT.successDefault();
    }

    @Override
    public ReturnT getAttribnameList() {
        ReturnT returnT = new ReturnT();
        returnT.setData(mapper.getAttribnameList());
        return returnT.successDefault();
    }
}
