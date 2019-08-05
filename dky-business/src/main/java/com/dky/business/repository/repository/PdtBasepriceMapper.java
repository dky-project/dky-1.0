package com.dky.business.repository.repository;

import com.dky.common.response.view.PdtPriceView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@MyBatisRepository
public interface PdtBasepriceMapper {

    List<PdtPriceView> queryPriceListByProductId(Map<String,Object> map);

    List<PdtPriceView> queryChildPriceListByProductId(Map<String,Object> map);

    List<PdtPriceView> queryBabyPriceListByProductId(Map<String,Object> map);

    String getDhPrice(Long mProductId);

    BigDecimal getFloatRateByCode(String code);

    Integer getRetailTypeIdByCode(String code);
}