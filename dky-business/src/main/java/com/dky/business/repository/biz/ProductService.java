package com.dky.business.repository.biz;

import com.dky.common.bean.Product;
import com.dky.common.param.ProductMadeQueryParam;
import com.dky.common.param.ProductQueryParam;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.*;

import java.util.List;

/**
 * Created by wangpeng on 2017/1/5.
 */
public interface ProductService{


    /**
     * 查询样衣详情
     * @param id
     * @return
     */
    ReturnT<ProductInfoView> getProductInfo(Long id);

    ReturnT<PageList<ProductView>> findByPage(ProductQueryParam productQueryParam);

    ReturnT<List<ProductValueView>> queryValueList(Long mProductId);

    ReturnT<ProductMadePageView> getMadeInfoByProductName(ProductMadeQueryParam param);
}
