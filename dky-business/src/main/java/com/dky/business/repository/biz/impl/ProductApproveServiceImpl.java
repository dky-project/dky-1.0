package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.ProductApproveService;
import com.dky.business.repository.repository.ProductApproveMapper;
import com.dky.common.bean.ProductApprove;
import com.dky.common.param.ProductApproveQueryParam;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ProductApproveView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wonpera on 2017/1/6.
 */
@Service
public class ProductApproveServiceImpl implements ProductApproveService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductApproveServiceImpl.class);

    @Autowired
    private ProductApproveMapper mapper;

    @Override
    public ReturnT<PageList<ProductApproveView>> findByPage(ProductApproveQueryParam param) {
        ProductApprove approve = new ProductApprove();
        BeanUtils.copyProperties(param,approve);
        return new ReturnT<>().sucessData(findPage(approve));
    }

    private PageList<ProductApproveView> findPage(ProductApprove approve){
        return new PageList<ProductApproveView>(
                mapper.queryByPage(approve),mapper.count(approve),
                approve.getPageNo(),approve.getPageSize());
    }

    @Override
    public ReturnT insertProductApprove() {
        return null;
    }

    @Override
    public ReturnT updateProductApprove() {
        return null;
    }
}
