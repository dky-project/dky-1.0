package com.dky.business.repository.biz;

import com.dky.common.response.ReturnT;
import com.dky.common.response.view.PdtPriceView;

import java.util.List;

/**
 * Created by wonpera on 2017/1/6.
 */
public interface PdtBasepriceService {

    ReturnT<List<PdtPriceView>> queryPriceListByProductId(Long mProductId);
}
