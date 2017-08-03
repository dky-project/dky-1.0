package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.ProductApproveService;
import com.dky.business.repository.repository.*;
import com.dky.common.bean.ProductApprove;
import com.dky.common.enums.IsActiveEnum;
import com.dky.common.enums.IsApproveEnum;
import com.dky.common.param.*;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.BmptApproveView;
import com.dky.common.response.view.ProductApproveInfoView;
import com.dky.common.response.view.ProductApproveReturnView;
import com.dky.common.response.view.ProductApproveView;
import com.dky.common.utils.DateUtils;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            mapper.bMptApproveSave(param.getJgNo(),param.getProductName(),
                   param.getSizeId(),param.getColorId());
        } catch (Exception e) {
            return new ReturnT().failureData("保存大货类型订单失败");
        }
        return new ReturnT().successDefault();
    }

    private PageList<ProductApproveView> findPage(ProductApprove approve){
        return new PageList<ProductApproveView>(
                mapper.queryByPage(approve),mapper.count(approve),
                approve.getPageNo(),approve.getPageSize());
    }

    private PageList<BmptApproveView> findPage(BmptApproveQueryParam approve){
        return new PageList<BmptApproveView>(
                bmptApproveMapper.queryByPage(approve),bmptApproveMapper.count(approve),
                approve.getPageNo(),approve.getPageSize());
    }

    @Override
    public ReturnT<ProductApproveReturnView> insertProductApprove(AddProductApproveParam param) {
        ProductApprove approve = new ProductApprove();
        BeanUtils.copyProperties(param,approve);
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
        try {
            mapper.addProductDefault(approve);
            mapper.addProductDefaultAc(map);
        }catch (Exception e){
            //e.printStackTrace();
            LOGGER.error("样衣详情下单出错！result:{}",e.getMessage());
            return new ReturnT().failureData(e.getMessage());
        }
        ProductApproveReturnView view = new ProductApproveReturnView(map.get("R_MESSAGE").toString());
        view.setProductApproveId(id);
        ReturnT<ProductApproveReturnView> returnT = new ReturnT<>();
        returnT.setData(view);
        return returnT.successDefault();
    }

    @Override
    public ReturnT confirmProductApprove(UpdateProductApproveParam param) {
        ProductApprove productApprove = new ProductApprove();
        productApprove.setId(param.getId());
        productApprove.setIsactive(IsActiveEnum.YES.getCode());
        mapper.updateProductApproveById(productApprove);
        return new ReturnT().successDefault();
    }

}
