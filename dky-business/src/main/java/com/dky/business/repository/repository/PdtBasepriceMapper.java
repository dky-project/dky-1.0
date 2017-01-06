package com.dky.business.repository.repository;

import com.dky.common.bean.PdtBaseprice;

import java.util.List;

public interface PdtBasepriceMapper {

    List<PdtBaseprice> queryPriceListByProductId(Long mProductId);
}