package com.dky.business.repository.repository;

import com.dky.common.bean.PdtBaseprice;

import java.util.List;

@MyBatisRepository
public interface PdtBasepriceMapper {

    List<PdtBaseprice> queryPriceListByProductId(Long mProductId);

    Double getDhPrice(Long mProductId);
}