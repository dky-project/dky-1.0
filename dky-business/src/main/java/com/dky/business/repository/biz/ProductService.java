package com.dky.business.repository.biz;

import com.dky.common.param.ProductMadeQueryParam;
import com.dky.common.param.ProductQueryBaseParam;
import com.dky.common.param.ProductQueryParam;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ProductInfoView;
import com.dky.common.response.view.ProductMadePageView;
import com.dky.common.response.view.ProductValueView;
import com.dky.common.response.view.ProductView;

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

    ReturnT<PageList<ProductView>> findByPage(ProductQueryBaseParam productQueryParam);

    ReturnT<List<ProductValueView>> queryValueList(Long mProductId);

    ReturnT<ProductMadePageView> getMadeInfoByProductName(ProductMadeQueryParam param);
}
