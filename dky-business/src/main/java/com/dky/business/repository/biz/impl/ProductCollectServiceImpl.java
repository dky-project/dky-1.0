package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.ProductCollectService;
import com.dky.business.repository.repository.ProductCollectMapper;
import com.dky.business.repository.repository.UsersMapper;
import com.dky.common.bean.ProductCollect;
import com.dky.common.enums.IsActiveEnum;
import com.dky.common.param.AddProductCollectParam;
import com.dky.common.param.ProductCollectQueryParam;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by hang on 2017/5/16 0016.
 */
@Service
public class ProductCollectServiceImpl implements ProductCollectService {

    @Autowired
    private ProductCollectMapper mapper;
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public ReturnT mergeIntoProductCollect(AddProductCollectParam param) {
        ProductCollect productCollect = new ProductCollect();
        productCollect.setIsactive(IsActiveEnum.YES.getCode());
        Long userId = param.getSessionUser().getUserId();
        productCollect.setOwnerid(userId);
        productCollect.setModifierid(userId);
        productCollect.setAdClientId(37l);
        productCollect.setAdOrgId(27l);
        productCollect.setmProductId(param.getProductId());
        Map<String,String> userMap = usersMapper.getStoreCodeByEmail(param.getSessionUser().getEmail());
        productCollect.setCode(userMap!=null?userMap.get("CODE"):param.getSessionUser().getEmail());
        mapper.mergeIntoProductCollect(productCollect);
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT delProductCollect(AddProductCollectParam param) {
        ProductCollect productCollect = new ProductCollect();
        productCollect.setIsactive(IsActiveEnum.NO.getCode());
        productCollect.setmProductId(param.getProductId());
        Map<String,String> userMap = usersMapper.getStoreCodeByEmail(param.getSessionUser().getEmail());
        productCollect.setCode(userMap!=null?userMap.get("CODE"):param.getSessionUser().getEmail());
        mapper.mergeIntoProductCollect(productCollect);
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT<PageList<ProductView>> findByPage(ProductCollectQueryParam param) {
        Map<String,String> userMap = usersMapper.getStoreCodeByEmail(param.getSessionUser().getEmail());
        param.setCode(userMap!=null?userMap.get("CODE"):param.getSessionUser().getEmail());
        return new ReturnT<>().sucessData(findPage(param));
    }

    private PageList<ProductView> findPage(ProductCollectQueryParam param) {
        return new PageList<ProductView>(mapper.queryByPage(param), mapper.count(param), param.getPageNo(), param.getPageSize());
    }
}
