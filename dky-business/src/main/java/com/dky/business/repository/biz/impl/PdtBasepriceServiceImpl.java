package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.PdtBasepriceService;
import com.dky.business.repository.repository.PdtBasepriceMapper;
import com.dky.business.repository.repository.ProductMapper;
import com.dky.business.repository.repository.UsersMapper;
import com.dky.common.bean.Product;
import com.dky.common.bean.SessionUser;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.PdtPriceView;
import com.dky.common.utils.DkyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wonpera on 2017/1/6.
 */
@Service
public class PdtBasepriceServiceImpl implements PdtBasepriceService {

    @Autowired
    private PdtBasepriceMapper mapper;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ReturnT<List<PdtPriceView>> queryPriceListByProductId(Long mProductId) {
        SessionUser user = DkyUtils.getCurrentUser();
        Map<String,String> userMap = usersMapper.getStoreCodeByEmail(user.getEmail());
        String code = userMap!=null?userMap.get("CODE"):user.getEmail();
        Product product = productMapper.getById(mProductId);

        BigDecimal floatRate = mapper.getFloatRateByCode(code);
        Integer retailTypeId = mapper.getRetailTypeIdByCode(code);
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("mProductId",mProductId);
        paramMap.put("floatRate",floatRate);
        paramMap.put("retailTypeId",retailTypeId);
        if (product.getmDimNew13Id() == 21 || product.getmDimNew13Id() == 20){
            return new ReturnT<>().sucessData(mapper.queryPriceListByProductId(paramMap));
        } else if (product.getmDimNew13Id() == 249 || product.getmDimNew13Id() == 250){
            return new ReturnT<>().sucessData(mapper.queryChildPriceListByProductId(paramMap));
        } else {
            return new ReturnT<>().sucessData(mapper.queryBabyPriceListByProductId(paramMap));
        }

    }
}
