package com.dky.business.repository.repository;

import com.dky.common.response.view.PdtPriceView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisRepository
public interface PdtBasepriceMapper {

    List<PdtPriceView> queryPriceListByProductId(@Param("mProductId") Long mProductId, @Param("code") String code);

    List<PdtPriceView> queryChildPriceListByProductId(@Param("mProductId") Long mProductId, @Param("code") String code);

    List<PdtPriceView> queryBabyPriceListByProductId(@Param("mProductId") Long mProductId, @Param("code") String code);

    String getDhPrice(Long mProductId);
}