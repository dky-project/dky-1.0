package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.ProductService;
import com.dky.business.repository.repository.BaseDao;
import com.dky.business.repository.repository.ProductMapper;
import com.dky.common.bean.Product;
import com.dky.common.constats.GlobConts;
import com.dky.common.param.ProductQueryParam;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ProductInfoView;
import com.dky.common.response.view.ProductView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            return new ReturnT<>().failureData(e.getMessage());
        }
        return new ReturnT<>().sucessData(productInfoView);
    }

    @Override
    public ReturnT<PageList<ProductView>> findByPage(ProductQueryParam productQueryParam) {
        return new ReturnT<>().sucessData(findPage(productQueryParam));
    }

    private PageList<ProductView> findPage(ProductQueryParam productQueryParam) {
        Product product = new Product();
        BeanUtils.copyProperties(productQueryParam,product);
        if(product.getRequestOffset() == null && product.getRequestCount() == null){
            product.setRequestOffset(0);
            product.setRequestCount(GlobConts.DEFUALT_PAGE_SIZE);
        }
        return new PageList<ProductView>(mapper.queryByPage(product), mapper.count(product), 0, 0);
    }

}
