package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.PdtBasepriceService;
import com.dky.business.repository.repository.PdtBasepriceMapper;
import com.dky.common.bean.PdtBaseprice;
import com.dky.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wonpera on 2017/1/6.
 */
@Service
public class PdtBasepriceServiceImpl implements PdtBasepriceService {


    @Autowired
    private PdtBasepriceMapper mapper;

    @Override
    public ReturnT<List<PdtBaseprice>> queryPriceListByProductId(Long mProductId) {
        return new ReturnT<>().sucessData(mapper.queryPriceListByProductId(mProductId));
    }
}
