package com.dky.business.repository.biz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dky.business.repository.biz.ProductApproveService;
import com.dky.business.repository.cache.RedisCacheManager;
import com.dky.business.repository.repository.*;
import com.dky.common.bean.BmptApprove;
import com.dky.common.bean.ProductApprove;
import com.dky.common.bean.SessionUser;
import com.dky.common.enums.*;
import com.dky.common.param.*;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.*;
import com.dky.common.utils.DateUtils;
import com.dky.common.utils.DkyUtils;
import com.google.gson.Gson;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    @Autowired
    private RedisCacheManager redisCacheManager;

    @Override
    public ReturnT<PageList> findByPage(Object param) {
        if (param instanceof ProductApproveQueryParam) {
            ProductApproveQueryParam queryParam = (ProductApproveQueryParam) param;
            String email = queryParam.getSessionUser().getEmail();
            ProductApprove approve = new ProductApprove();
            BeanUtils.copyProperties(queryParam, approve);
            Map<String, String> map = usersMapper.getStoreCodeByEmail(email);
            approve.setJgno(map != null ? map.get("CODE") : email);
            return new ReturnT<>().sucessData(findPage(approve));
        } else if (param instanceof BmptApproveQueryParam) {
            BmptApproveQueryParam queryParam = (BmptApproveQueryParam) param;
            String email = queryParam.getSessionUser().getEmail();
            Map<String, String> map = usersMapper.getStoreCodeByEmail(email);
            queryParam.setJgno(map != null ? map.get("CODE") : email);
            return new ReturnT<>().sucessData(findPage(queryParam));
        }
        return null;
    }

    @Override
    public ReturnT<List<ProductApproveInfoView>> queryProductApproveInfoList(Long[] ids) {
        SessionUser user = DkyUtils.getCurrentUser();
        return new ReturnT<>().sucessData(mapper.queryProductApproveInfoList(ids,user.getEmail()));
    }


    /**
     * 下单保存大货类型订单
     *
     * @param param
     * @return
     */
    @Override
    public ReturnT bMptApproveSave(BMptApproveSaveParam param) {
        try {
            if (null == param.getIssource()) {
                param.setIssource(SourceEnum.DEFALUT.getCode());
            }
            Map<String, String> userMap = usersMapper.getStoreCodeByEmail(param.getSessionUser().getEmail());
            String code = userMap != null ? userMap.get("CODE") : param.getSessionUser().getEmail();
            bmptApproveMapper.bMptApproveSave(code, param.getProductName(),
                    param.getSizeId(), param.getColorId(), param.getIssource());
        } catch (Exception e) {
            LOGGER.error("大货订单保存失败 error:{}", e.getMessage());
            return new ReturnT().failureData("保存大货类型订单失败");
        }
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT bMptApproveInsert(BMptApproveSaveParam param) {
        try {
            Map<String, String> userMap = usersMapper.getStoreCodeByEmail(param.getSessionUser().getEmail());
            String code = userMap != null ? userMap.get("CODE") : param.getSessionUser().getEmail();
            bmptApproveMapper.bMptApproveInsert(code, param.getPdtId(),
                    param.getSizeId(), param.getColorId(), param.getQty(), param.getIssource());
        } catch (Exception e) {
            LOGGER.error("大货订单保存失败 error:{}", e.getMessage());
            return new ReturnT().failureData("保存大货类型订单失败");
        }
        return new ReturnT().successDefault();
    }

    private PageList<ProductApproveView> findPage(ProductApprove approve) {
        if (approve.getVersion().equals(VesionEnum.INNER_ORDER.getCode()) || approve.getVersion().equals(VesionEnum.OUTER_ORDER.getCode())) {
            return new PageList<>(
                    mapper.queryByPageGroup(approve), mapper.countGroup(approve), approve.getPageNo(), approve.getPageSize(), mapper.queryGroupTotalMap(approve));
        } else {
            return new PageList<>(
                    mapper.queryByPage(approve), mapper.count(approve), approve.getPageNo(), approve.getPageSize(), mapper.queryTotalMap(approve));
        }
    }

    private PageList<BmptApproveView> findPage(BmptApproveQueryParam approve) {
        return new PageList<>(
                bmptApproveMapper.queryByPage(approve), bmptApproveMapper.count(approve), approve.getPageNo(), approve.getPageSize(), bmptApproveMapper.queryTotalMap(approve));
    }

    @Override
    public ReturnT<PageList> mergePage(ProductApproveMergeQueryParam param) {
        String email = param.getSessionUser().getEmail();
        Map<String, String> map = usersMapper.getStoreCodeByEmail(email);
        param.setJgno(map != null ? map.get("CODE") : email);
        PageList pageList;
        if (param.getVersion().equals(VesionEnum.INNER_ORDER.getCode()) || param.getVersion().equals(VesionEnum.OUTER_ORDER.getCode())) {
            pageList = new PageList<>(mapper.queryByPageDHHTotalGroup(param), mapper.countDHHTotalGroup(param), param.getPageNo(), param.getPageSize(), mapper.queryDHHGroupTotalMap(param));
        } else {
            pageList = new PageList<>(mapper.queryByPageJmTotalGroup(param), mapper.countJmTotalGroup(param), param.getPageNo(), param.getPageSize(), mapper.queryJmGroupTotalMap(param));
        }
        return new ReturnT<>().sucessData(pageList);
    }

    @Override
    public ReturnT<ProductApproveReturnView> insertProductApprove(AddProductApproveParam param) {
        ProductApprove approve = new ProductApprove();
        BeanUtils.copyProperties(param, approve);
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
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnT().failureData(e.getMessage());
        }
        Map<String, Object> map = new HashedMap();
        map.put("id", id);
        mapper.getScorder(map);
        ProductApproveReturnView view = new ProductApproveReturnView(map.get("R_MESSAGE").toString());
        view.setProductApproveId(id);
        ReturnT<ProductApproveReturnView> returnT = new ReturnT<>();
        returnT.setData(view);
        return returnT.successDefault();
    }

    @Override
    public ReturnT updateProductApproveList(Long[] ids) {
        //return new ReturnT().failureData("删除功能暂时关闭，有疑问请联系工作人员！");
        if (ids.length == 0) {
            return new ReturnT().failureData("请选择订单！");
        }
        for (Long id : ids) {
            List<ProductApproveTotalView> viewList = mapper.getByPageDHHTotalGroup(id);
            for (ProductApproveTotalView view : viewList) {
                List<ProductApprove> list = mapper.selectByView(view);
                if (list != null && list.size() > 0) {
                    for (ProductApprove approve : list) {
                        if (IsApproveEnum.APPROVE_SUCCESS.getCode().equals(approve.getIsapprove())) {
                            return new ReturnT().failureData("已审核的订单不能删除！ 订单序号：" + id + "！");
                        }
                        mapper.delById(approve.getId());
                    }
                }
                List<BmptApprove> bmptList = bmptApproveMapper.selectByView(view);
                if (bmptList != null && bmptList.size() > 0) {
                    for (BmptApprove approve : bmptList) {
                        if (IsApproveEnum.APPROVE_SUCCESS.getCode().equals(approve.getIsapprove())) {
                            return new ReturnT().failureData("已审核的订单不能删除！ 订单序号：" + id + "！");
                        }
                        bmptApproveMapper.delById(approve.getId());
                    }
                }
            }
        }
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT<ProductApproveReturnView> addProductDefault(AddProductApproveParam param) {
        ProductApprove approve = new ProductApprove();
        BeanUtils.copyProperties(param, approve);
        approve.setFhDate(dimNewMapper.getSendDate());
        Map<String, String> userMap = usersMapper.getStoreCodeByEmail(param.getSessionUser().getEmail());
        approve.setJgno(userMap != null ? userMap.get("CODE") : param.getSessionUser().getEmail());
        approve.setCzDate(DateUtils.formatNowDate(DateUtils.FORMAT_YYYYMMDD));
        //加锁设置单据编号
        //approve.setDocno(mapper.getProductApproveDocno());
        approve.setIsapprove(IsApproveEnum.DEFAULT.getCode());
        approve.setIsactive(IsActiveEnum.NO.getCode());
        Long userId = param.getSessionUser().getUserId();
        approve.setOwnerid(userId);
        approve.setModifierid(userId);
        approve.setAdClientId(37l);
        approve.setAdOrgId(27l);
        approve.setJxwValue("0");
        approve.setSjxcValue("0");
        approve.setIssource(SourceEnum.DEFALUT.getCode());
        Long id = mapper.getProductApproveSeq();
        approve.setId(id);
        Map<String, Object> map = new HashedMap();
        map.put("id", id);
        mapper.addProductDefault(approve);
        mapper.addProductDefaultAc(map);
        ProductApproveReturnView view = new ProductApproveReturnView(map.get("R_MESSAGE").toString());
        view.setProductApproveId(id);
        ReturnT<ProductApproveReturnView> returnT = new ReturnT<>();
        returnT.setData(view);
        return returnT.successDefault();
    }

    @Override
    public ReturnT confirmProductApprove(ConfirmProductApproveParam param) {
        ProductApprove productApprove = new ProductApprove();
        if (param.getId() != null) {
            productApprove.setId(param.getId());
            productApprove.setIsactive(IsActiveEnum.YES.getCode());
            mapper.updateProductApproveById(productApprove);
            mapper.updateProductApproveByApproveId(productApprove);
        }
        if (param.getApproveIds() != null && param.getApproveIds().length > 0) {
            for (Long id : param.getApproveIds()) {
                productApprove = new ProductApprove();
                productApprove.setIsactive(IsActiveEnum.YES.getCode());
                productApprove.setId(id);
                mapper.updateProductApproveById(productApprove);
                mapper.updateProductApproveByApproveId(productApprove);
            }
        }
        if (param.getBmptIds() != null && param.getBmptIds().length > 0) {
            for (Long id : param.getBmptIds()) {
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
            Map<String, String> userMap = usersMapper.getStoreCodeByEmail(param.getSessionUser().getEmail());
            String code = userMap != null ? userMap.get("CODE") : param.getSessionUser().getEmail();
            JSONArray bmptArray = JSONObject.parseObject(param.getParamJson()).getJSONArray("addDpGroupBmptParamList");
            Iterator<Object> it = bmptArray.iterator();
            while (it.hasNext() && bmptArray.size() > 0) {
                String jsonStr = it.next().toString();
                Gson gson = new Gson();
                AddDpGroupBmptParam bmptParam = gson.fromJson(jsonStr, AddDpGroupBmptParam.class);
                if (bmptParam.getSum() != null && bmptParam.getSum() > 0) {
                    Long id = bmptApproveMapper.getBmptApproveSeq();
                    bmptApproveMapper.insertBmptApprove(id, code, bmptParam.getmProductId(),
                            bmptParam.getSizeId(), bmptParam.getColorId(), bmptParam.getSum(), SourceEnum.WITH.getCode());
                    bmptApproveMapper.bmptApproveAcm(id);
                    bmptIds.add(id);
                }
            }
            //定制下单
            JSONArray approveArray = JSONObject.parseObject(param.getParamJson()).getJSONArray("addDpGroupApproveParamList");
            Iterator<Object> iterator = approveArray.iterator();
            while (iterator.hasNext() && approveArray.size() > 0) {
                String json = iterator.next().toString();
                Gson gson = new Gson();
                AddDpGroupApproveParam approveParam = gson.fromJson(json, AddDpGroupApproveParam.class);
                if (approveParam.getSum() != null && approveParam.getSum() > 0) {
                    ProductApprove approve = new ProductApprove();
                    BeanUtils.copyProperties(approveParam, approve);
                    buildDimNew(approveParam, approve);
                    approve.setFhDate(dimNewMapper.getSendDate());
                    approve.setJgno(code);
                    approve.setCzDate(DateUtils.formatNowDate(DateUtils.FORMAT_YYYYMMDD));
                    approve.setNo(mapper.getMaxNo(code, approve.getCzDate()));
                    //approve.setDocno(mapper.getProductApproveDocno());
                    approve.setIsapprove(IsApproveEnum.DEFAULT.getCode());
                    approve.setIsactive(IsActiveEnum.NO.getCode());
                    Long userId = param.getSessionUser().getUserId();
                    approve.setOwnerid(userId);
                    approve.setModifierid(userId);
                    approve.setAdClientId(37l);
                    approve.setAdOrgId(27l);
                    approve.setJxwValue("0");
                    approve.setSjxcValue("0");
                    approve.setCustomer("YYW");
                    approve.setIssource(SourceEnum.WITH.getCode());
                    Long id = mapper.getProductApproveSeq();
                    approve.setId(id);
                    Map<String, Object> map = new HashedMap();
                    map.put("id", id);
                    mapper.addProductDefault(approve);
                    mapper.add_product_dp_group(map);
                    approveIds.add(id);
                }
            }
        } catch (Exception e) {
            LOGGER.error("搭配下单出错！result:{}", e.getMessage());
            String msg = "";
            String msg1 = e.getMessage().substring(
                    e.getMessage().indexOf("ORA-") + 10,
                    e.getMessage().length());
            if (msg1.indexOf("ORA-") > -1)
                msg = msg1.substring(0, msg1.indexOf("ORA-"));
            else {
                msg = msg1;
            }
            return new ReturnT().failureData(msg);
        }
        DpGroupReturnView view = new DpGroupReturnView();
        if (bmptIds.size() > 0) {
            view.setBmptIds(bmptIds);
        }
        if (approveIds.size() > 0) {
            view.setApproveIds(approveIds);
        }
        ReturnT returnT = new ReturnT();
        returnT.setData(view);
        return returnT.successDefault();
    }

    public void buildDimNew(AddDpGroupApproveParam approveParam, ProductApprove productApprove) {
        PzsJsonQueryParam pzsJsonQueryParam = new PzsJsonQueryParam();
        pzsJsonQueryParam.setFlag("2");
        pzsJsonQueryParam.setProductId(approveParam.getmProductId());
        pzsJsonQueryParam.setmDimNew14Id(approveParam.getmDimNew14Id());
        String result = dimNewMapper.getpzsJson(pzsJsonQueryParam);
        if (StringUtils.isNoneEmpty(result)) {
            result = result.replaceAll("'", "\"");
            JSONObject zzJson = (JSONObject) JSONObject.parseArray(JSONObject.parseObject(result).getString("value")).get(0);
            productApprove.setmDimNew15Id(Long.valueOf(zzJson.get("id").toString()));
        }
        pzsJsonQueryParam.setFlag("4");
        pzsJsonQueryParam.setmDimNew15Id(productApprove.getmDimNew15Id());
        pzsJsonQueryParam.setmDimNew16Id(approveParam.getmDimNew16Id());
        result = dimNewMapper.getpzsJson(pzsJsonQueryParam);
        if (StringUtils.isNoneEmpty(result)) {
            result = result.replaceAll("'", "\"");
            JSONObject zzJson = (JSONObject) JSONObject.parseArray(JSONObject.parseObject(result).getString("value")).get(0);
            productApprove.setmDimNew17Id(Long.valueOf(zzJson.get("id").toString()));
        }
    }

    @Override
    public ReturnT productApproveMergeInfoList(ProductApproveMergeInfoQueryParam param) {
        if (param.getIds().length == 0) {
            return new ReturnT().failureData("请选择订单！");
        }
        Map<String, Object> result = new HashMap<>();
        List<ProductApprove> list = new ArrayList<>();
        List<BmptApprove> bmptList = new ArrayList<>();
        for (Long id : param.getIds()) {
            List<ProductApproveTotalView> viewList = null;
            if (param.getVersion().equals(VesionEnum.INNER_ORDER.getCode()) || param.getVersion().equals(VesionEnum.OUTER_ORDER.getCode())) {
                viewList = mapper.getByPageDHHTotalGroup(id);
            } else {
                viewList = mapper.getByPageJMTotalGroup(id);
            }
            for (ProductApproveTotalView view : viewList) {
                List<ProductApprove> templist = mapper.selectByView(view);
                List<BmptApprove> tempbmptList = bmptApproveMapper.selectByView(view);
                if (templist.size() > 0) {
                    list.addAll(templist);
                }
                if (tempbmptList.size() > 0) {
                    bmptList.addAll(tempbmptList);
                }
            }
        }
        Map<String, String> userMap = usersMapper.getStoreCodeByEmail(param.getSessionUser().getEmail());
        String code = userMap != null ? userMap.get("CODE") : param.getSessionUser().getEmail();
        if (list.size() > 0) {
            Long[] approveIds = new Long[list.size()];
            for (int i = 0; i < list.size(); i++) {
                approveIds[i] = list.get(i).getId();
            }
            List<ProductApproveInfoView> productResultList = mapper.queryProductApproveInfoList(approveIds,code);
            for (ProductApproveInfoView view :productResultList){
                view.setViewType(1);
                Long[] mDimNew22Ids = {56L,57L,58L,59L,355L};
                if (view.getmDimNew12Id() != null && Arrays.binarySearch(mDimNew22Ids, view.getmDimNew12Id()) > 0){
                    view.setViewType(2);
                }
                if (view.getmDimNew22Id() != null && view.getmDimNew22Id().equals(131L)){
                    view.setViewType(3);
                }
                if (view.getmDimNew12Id() != null && view.getmDimNew12Id().equals(55L)){
                    view.setViewType(4);
                }
            }
            result.put("product", productResultList);
        }

        if (bmptList.size() > 0) {
            Long[] bmptIds = new Long[bmptList.size()];
            for (int i = 0; i < bmptList.size(); i++) {
                bmptIds[i] = bmptList.get(i).getId();
            }
            List<BmptApproveInfoView> bmptResultList = bmptApproveMapper.queryBmptApproveInfoList(bmptIds,code);
            result.put("bmpt", bmptResultList);
        }
        ReturnT returnT = new ReturnT();
        returnT.setData(result);
        return returnT.successDefault();
    }
}
