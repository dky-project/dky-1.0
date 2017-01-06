package com.dky.business.repository.biz;

import com.dky.common.bean.PdtBaseprice;
import com.dky.common.response.ReturnT;

import java.util.List;

/**
 * Created by wonpera on 2017/1/6.
 */
public interface PdtBasepriceService {

    ReturnT<List<PdtBaseprice>> queryPriceListByProductId(Long mProductId);
}
