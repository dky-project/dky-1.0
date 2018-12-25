package com.dky.business.repository.repository;

import com.dky.common.response.view.PdtPriceView;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@MyBatisRepository
public interface PdtBasepriceMapper {

    List<PdtPriceView> queryPriceListByProductId(@Param("mProductId") Long mProductId, @Param("floatRate") BigDecimal floatRate);

    List<PdtPriceView> queryChildPriceListByProductId(@Param("mProductId") Long mProductId, @Param("floatRate") BigDecimal floatRate);

    List<PdtPriceView> queryBabyPriceListByProductId(@Param("mProductId") Long mProductId, @Param("floatRate") BigDecimal floatRate);

    String getDhPrice(Long mProductId);

    BigDecimal getFloatRateByCode(String code);
}