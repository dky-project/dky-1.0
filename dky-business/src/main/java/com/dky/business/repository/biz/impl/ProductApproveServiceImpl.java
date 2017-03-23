package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.ProductApproveService;
import com.dky.business.repository.repository.ProductApproveMapper;
import com.dky.business.repository.repository.UsersMapper;
import com.dky.common.bean.ProductApprove;
import com.dky.common.enums.IsApproveEnum;
import com.dky.common.param.AddProductApproveParam;
import com.dky.common.param.BMptApproveSaveParam;
import com.dky.common.param.ProductApproveQueryParam;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ProductApproveInfoView;
import com.dky.common.response.view.ProductApproveView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    private UsersMapper usersMapper;

    @Override
    public ReturnT<PageList<ProductApproveView>> findByPage(ProductApproveQueryParam param) {
        String email = param.getSessionUser().getEmail();
        ProductApprove approve = new ProductApprove();
        Map<String,String> map = usersMapper.getStoreCodeByEmail(email);
        BeanUtils.copyProperties(param,approve);
        approve.setJgno(map.get("CODE"));
        return new ReturnT<>().sucessData(findPage(approve));
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

    @Override
    public ReturnT insertProductApprove(AddProductApproveParam param) {
        ProductApprove approve = new ProductApprove();
        BeanUtils.copyProperties(param,approve);
        approve.setIsapprove(IsApproveEnum.DEFAULT.getCode());
        approve.setIsactive("Y");
        Date now = new Date();
        approve.setCreationdate(now);
        approve.setModifieddate(now);
        Long userId = param.getSessionUser().getUserId();
        approve.setOwnerid(userId);
        approve.setModifierid(userId);
        Long id = mapper.insertProductApprove(approve);
        mapper.productApproveAc(id);
        String message = mapper.getScorder(id);
        return new ReturnT().sucessDataMsg(message);
    }

    @Override
    public ReturnT updateProductApprove() {
        return null;
    }
}
