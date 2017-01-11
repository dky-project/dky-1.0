package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.ProductService;
import com.dky.business.repository.repository.ProductMapper;
import com.dky.common.bean.Product;
import com.dky.common.param.ProductQueryParam;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ProductInfoView;
import com.dky.common.response.view.ProductValueView;
import com.dky.common.response.view.ProductView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 样衣查询服务
 * Created by wangpeng on 2017/1/5.
 */
@Service
public class ProductServiceImpl implements ProductService  {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductMapper mapper;


    @Override
    public ReturnT<ProductInfoView> getProductInfo(Long id) {
        ProductInfoView productInfoView = null;
        try {
            productInfoView = mapper.getProductInfo(id);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            return new ReturnT<>().failureData(e.getMessage());
        }
        return new ReturnT<>().sucessData(productInfoView);
    }

    @Override
    public ReturnT<PageList<ProductView>> findByPage(ProductQueryParam productQueryParam) {
        return new ReturnT<>().sucessData(findPage(productQueryParam));
    }


    /**
     * 查询胸围、衣长、肩宽、袖长
     * @param mProductId
     * @return
     */
    @Override
    public ReturnT<List<ProductValueView>> queryValueList(Long mProductId) {
        return new ReturnT<>().sucessData(mapper.queryValueList(mProductId));
    }

    private PageList<ProductView> findPage(ProductQueryParam productQueryParam) {
        Product product = new Product();
        BeanUtils.copyProperties(productQueryParam,product);
        return new PageList<ProductView>(mapper.queryByPage(product), mapper.count(product), productQueryParam.getPageNo(), productQueryParam.getPageSize());
    }

}
