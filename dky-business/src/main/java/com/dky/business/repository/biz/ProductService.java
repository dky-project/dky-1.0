package com.dky.business.repository.biz;

import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ProductInfoView;

/**
 * Created by wangpeng on 2017/1/5.
 */
public interface ProductService {


    /**
     * 查询样衣详情
     * @param id
     * @return
     */
    ReturnT<ProductInfoView> getProductInfo(Long id);
}
