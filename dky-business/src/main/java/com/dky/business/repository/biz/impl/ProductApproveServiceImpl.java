package com.dky.business.repository.biz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dky.business.repository.biz.ProductApproveService;
import com.dky.business.repository.repository.*;
import com.dky.common.bean.BmptApprove;
import com.dky.common.bean.ProductApprove;
import com.dky.common.enums.IsActiveEnum;
import com.dky.common.enums.IsApproveEnum;
import com.dky.common.enums.ResultCodeEnum;
import com.dky.common.enums.VesionEnum;
import com.dky.common.param.*;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.*;
import com.dky.common.utils.DateUtils;
import com.google.gson.Gson;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by wonpera on 2017/1/6.
 */
@Service
public class ProductApproveServiceImpl implements ProductApproveService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductApproveServiceImpl.class);

    @Autowired
    private ProductApproveMapper mapper;
    @Autowired
    private BmptApproveMapper bmptApproveMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private DimNewMapper dimNewMapper;
    @Autowired
    private ProductCollectMapper productCollectMapper;

    @Override
    public ReturnT<PageList> findByPage(Object param) {
        if (param instanceof ProductApproveQueryParam){
            ProductApproveQueryParam queryParam = (ProductApproveQueryParam) param;
            String email = queryParam.getSessionUser().getEmail();
            ProductApprove approve = new ProductApprove();
            BeanUtils.copyProperties(queryParam,approve);
            Map<String,String> map = usersMapper.getStoreCodeByEmail(email);
            approve.setJgno(map!=null?map.get("CODE"):email);
            return new ReturnT<>().sucessData(findPage(approve));
        }else if (param instanceof BmptApproveQueryParam){
            BmptApproveQueryParam queryParam = (BmptApproveQueryParam) param;
            String email = queryParam.getSessionUser().getEmail();
            Map<String,String> map = usersMapper.getStoreCodeByEmail(email);
            queryParam.setJgno(map!=null?map.get("CODE"):email);
            return new ReturnT<>().sucessData(findPage(queryParam));
        }
        return null;
    }

    @Override
    public ReturnT<List<ProductApproveInfoView>> queryProductApproveInfoList(Long[] ids) {
        return new ReturnT<>().sucessData(mapper.queryProductApproveInfoList(ids));
    }


    /**
     * 下单保存大货类型订单
     * @param param
     * @return
     */
    @Override
    public ReturnT bMptApproveSave(BMptApproveSaveParam param) {
        try {
            Map<String,String> userMap = usersMapper.getStoreCodeByEmail(param.getSessionUser().getEmail());
            String code = userMap!=null?userMap.get("CODE"):param.getSessionUser().getEmail();
            bmptApproveMapper.bMptApproveSave(code,param.getProductName(),
                    param.getSizeId(),param.getColorId());
        } catch (Exception e) {
            LOGGER.error("大货订单保存失败 error:{}",e.getMessage());
            return new ReturnT().failureData("保存大货类型订单失败");
        }
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT bMptApproveInsert(BMptApproveSaveParam param) {
        try {
            Map<String,String> userMap = usersMapper.getStoreCodeByEmail(param.getSessionUser().getEmail());
            String code = userMap!=null?userMap.get("CODE"):param.getSessionUser().getEmail();
            bmptApproveMapper.bMptApproveInsert(code,param.getPdtId(),
                    param.getSizeId(),param.getColorId(),param.getQty());
        } catch (Exception e) {
            LOGGER.error("大货订单保存失败 error:{}",e.getMessage());
            return new ReturnT().failureData("保存大货类型订单失败");
        }
        return new ReturnT().successDefault();
    }

    private PageList<ProductApproveView> findPage(ProductApprove approve){
        if (approve.getVersion().equals(VesionEnum.INNER_ORDER.getCode()) || approve.getVersion().equals(VesionEnum.OUTER_ORDER.getCode())){
            return new PageList<>(
                    mapper.queryByPageGroup(approve),mapper.countGroup(approve),approve.getPageNo(),approve.getPageSize(),mapper.queryGroupTotalMap(approve));
        }else{
            return new PageList<>(
                    mapper.queryByPage(approve),mapper.count(approve),approve.getPageNo(),approve.getPageSize(),mapper.queryTotalMap(approve));
        }
    }

    private PageList<BmptApproveView> findPage(BmptApproveQueryParam approve){
        return new PageList<BmptApproveView>(
                bmptApproveMapper.queryByPage(approve),bmptApproveMapper.count(approve),approve.getPageNo(),approve.getPageSize(),bmptApproveMapper.queryTotalMap(approve));
    }

    @Override
    public ReturnT<ProductApproveReturnView> insertProductApprove(AddProductApproveParam param) {
        ProductApprove approve = new ProductApprove();
        BeanUtils.copyProperties(param,approve);
        approve.setQtxbzzValue1(param.getQtxbzzValue());
        approve.setDocno(param.getOrderNo());
        approve.setIsapprove(IsApproveEnum.DEFAULT.getCode());
        approve.setIsactive(IsActiveEnum.NO.getCode());
        Long userId = param.getSessionUser().getUserId();
        approve.setOwnerid(userId);
        approve.setModifierid(userId);
        approve.setAdClientId(37l);
        approve.setAdOrgId(27l);
        Long id = mapper.getProductApproveSeq();
        try {
            approve.setId(id);
            mapper.insertProductApprove(approve);
            mapper.productApproveAc(id);
        }catch (Exception e){
            e.printStackTrace();
            return new ReturnT().failureData(e.getMessage());
        }
        Map<String,Object> map = new HashedMap();
        map.put("id",id);
        mapper.getScorder(map);
        ProductApproveReturnView view = new ProductApproveReturnView(map.get("R_MESSAGE").toString());
        view.setProductApproveId(id);
        ReturnT<ProductApproveReturnView>  returnT = new ReturnT<>();
        returnT.setData(view);
        return returnT.successDefault();
    }

    @Override
    public ReturnT updateProductApproveList(Long[] ids) {
        for (Long id : ids){
            ProductApprove p = mapper.getById(id);
            if (IsApproveEnum.APPROVE_SUCCESS.getCode().equals(p.getIsapprove())){
                return new ReturnT().failureData("已审核的订单不能删除！ 订单序号："+id+"！");
            }
        }
        mapper.updateProductApproveList(ids);
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT<ProductApproveReturnView> addProductDefault(AddProductApproveParam param) {
        ProductApprove approve = new ProductApprove();
        BeanUtils.copyProperties(param,approve);
        approve.setFhDate(dimNewMapper.getSendDate());
        Map<String,String> userMap = usersMapper.getStoreCodeByEmail(param.getSessionUser().getEmail());
        approve.setJgno(userMap!=null?userMap.get("CODE"):param.getSessionUser().getEmail());
        approve.setCzDate(DateUtils.formatNowDate(DateUtils.FORMAT_YYYYMMDD));
        approve.setDocno("PAD"+DateUtils.formatNowDate(DateUtils.FORMAT_YYYYMMDDHHMMSS));
        approve.setIsapprove(IsApproveEnum.DEFAULT.getCode());
        approve.setIsactive(IsActiveEnum.NO.getCode());
        Long userId = param.getSessionUser().getUserId();
        approve.setOwnerid(userId);
        approve.setModifierid(userId);
        approve.setAdClientId(37l);
        approve.setAdOrgId(27l);
        approve.setJxwValue("0");
        approve.setSjxcValue("0");
        Long id = mapper.getProductApproveSeq();
        approve.setId(id);
        Map<String,Object> map = new HashedMap();
        map.put("id",id);
        mapper.addProductDefault(approve);
        mapper.addProductDefaultAc(map);
        ProductApproveReturnView view = new ProductApproveReturnView(map.get("R_MESSAGE").toString());
        view.setProductApproveId(id);
        ReturnT<ProductApproveReturnView> returnT = new ReturnT<>();
        returnT.setData(view);
        return returnT.successDefault();
    }

    @Override
    public ReturnT confirmProductApprove(UpdateProductApproveParam param) {
        ProductApprove productApprove = new ProductApprove();
        if (param.getId() != null){
            productApprove.setId(param.getId());
            productApprove.setIsactive(IsActiveEnum.YES.getCode());
            mapper.updateProductApproveById(productApprove);
            mapper.updateProductApproveByApproveId(productApprove);
        }
        if (param.getApproveIds() != null && param.getApproveIds().length > 0){
            for (Long id : param.getApproveIds()){
                productApprove = new ProductApprove();
                productApprove.setIsactive(IsActiveEnum.YES.getCode());
                productApprove.setId(id);
                mapper.updateProductApproveById(productApprove);
                mapper.updateProductApproveByApproveId(productApprove);
            }
        }
        if (param.getBmptIds() != null && param.getBmptIds().length > 0){
            for (Long id : param.getBmptIds()){
                BmptApprove bmptApprove = new BmptApprove();
                bmptApprove.setIsactive(IsActiveEnum.YES.getCode());
                bmptApprove.setId(id);
                bmptApproveMapper.updateBmptApproveById(bmptApprove);
            }
        }
        return new ReturnT().successDefault();
    }

    @Override
    @Transactional
    public ReturnT addProductDpGroup(AddDpGroupParam param) {
        List<Long> bmptIds = new ArrayList<>();
        List<Long> approveIds = new ArrayList<>();
        try {
            //大货下单
            Map<String,String> userMap = usersMapper.getStoreCodeByEmail(param.getSessionUser().getEmail());
            String code = userMap!=null?userMap.get("CODE"):param.getSessionUser().getEmail();
            JSONArray bmptArray = JSONObject.parseObject(param.getParamJson()).getJSONArray("addDpGroupBmptParamList");
            Iterator<Object> it = bmptArray.iterator();
            while (it.hasNext() && bmptArray.size() > 0) {
                String jsonStr = it.next().toString();
                Gson gson = new Gson();
                AddDpGroupBmptParam bmptParam = gson.fromJson(jsonStr,AddDpGroupBmptParam.class);
                if (bmptParam.getSum() != null && bmptParam.getSum() > 0){
                    Long id = bmptApproveMapper.getBmptApproveSeq();
                    bmptApproveMapper.insertBmptApprove(id,code,bmptParam.getmProductId(),
                            bmptParam.getSizeId(),bmptParam.getColorId(),bmptParam.getSum());
                    bmptApproveMapper.bmptApproveAcm(id);
                    bmptIds.add(id);
                }
            }
            //定制下单
            JSONArray approveArray = JSONObject.parseObject(param.getParamJson()).getJSONArray("addDpGroupApproveParamList");
            Iterator<Object> iterator = approveArray.iterator();
            while (iterator.hasNext() && approveArray.size() > 0) {
                String json =  iterator.next().toString();
                Gson gson = new Gson();
                AddDpGroupApproveParam approveParam = gson.fromJson(json,AddDpGroupApproveParam.class);
                if (approveParam.getSum() != null && approveParam.getSum() > 0){
                    ProductApprove approve = new ProductApprove();
                    BeanUtils.copyProperties(approveParam,approve);
                    buildDimNew(approveParam,approve);
                    approve.setFhDate(dimNewMapper.getSendDate());
                    approve.setJgno(code);
                    approve.setCzDate(DateUtils.formatNowDate(DateUtils.FORMAT_YYYYMMDD));
                    approve.setNo(mapper.getMaxNo(code,approve.getCzDate()));
                    approve.setDocno("PAD"+DateUtils.formatNowDate(DateUtils.FORMAT_YYYYMMDDHHMMSS));
                    approve.setIsapprove(IsApproveEnum.DEFAULT.getCode());
                    approve.setIsactive(IsActiveEnum.NO.getCode());
                    Long userId = param.getSessionUser().getUserId();
                    approve.setOwnerid(userId);
                    approve.setModifierid(userId);
                    approve.setAdClientId(37l);
                    approve.setAdOrgId(27l);
                    approve.setJxwValue("0");
                    approve.setSjxcValue("0");
                    approve.setCustomer("样衣五");
                    Long id = mapper.getProductApproveSeq();
                    approve.setId(id);
                    Map<String,Object> map = new HashedMap();
                    map.put("id",id);
                    mapper.addProductDefault(approve);
                    mapper.add_product_dp_group(map);
                    approveIds.add(id);
                }
            }
        }catch (Exception e){
                //e.printStackTrace();
                LOGGER.error("搭配下单出错！result:{}",e.getMessage());
                return new ReturnT().failureData(ResultCodeEnum.SYSTEM_ERROR);
            }
        DpGroupReturnView view = new DpGroupReturnView();
        view.setBmptIds(bmptIds);
        view.setApproveIds(approveIds);
        ReturnT returnT = new ReturnT();
        returnT.setData(view);
        return returnT.successDefault();
    }

    public void buildDimNew(AddDpGroupApproveParam approveParam,ProductApprove productApprove){
        PzsJsonQueryParam pzsJsonQueryParam = new PzsJsonQueryParam();
        pzsJsonQueryParam.setFlag("2");
        pzsJsonQueryParam.setProductId(approveParam.getmProductId());
        pzsJsonQueryParam.setmDimNew14Id(approveParam.getmDimNew14Id());
        String result = dimNewMapper.getpzsJson(pzsJsonQueryParam);
        if(StringUtils.isNoneEmpty(result)){
            result = result.replaceAll("'","\"");
            JSONObject zzJson = (JSONObject)JSONObject.parseArray(JSONObject.parseObject(result).getString("value")).get(0);
            productApprove.setmDimNew15Id(Long.valueOf(zzJson.get("id").toString()));
        }
        pzsJsonQueryParam.setFlag("4");
        pzsJsonQueryParam.setmDimNew15Id(productApprove.getmDimNew15Id());
        pzsJsonQueryParam.setmDimNew16Id(approveParam.getmDimNew16Id());
        result = dimNewMapper.getpzsJson(pzsJsonQueryParam);
        if(StringUtils.isNoneEmpty(result)){
            result = result.replaceAll("'","\"");
            JSONObject zzJson = (JSONObject)JSONObject.parseArray(JSONObject.parseObject(result).getString("value")).get(0);
            productApprove.setmDimNew17Id(Long.valueOf(zzJson.get("id").toString()));
        }
    }
}
