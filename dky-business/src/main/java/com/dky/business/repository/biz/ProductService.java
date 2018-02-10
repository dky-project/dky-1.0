package com.dky.business.repository.biz;

import com.dky.common.param.*;
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
    ReturnT<ProductInfoView> getProductInfo(Long id,String isBuy);

    ReturnT<PageList<ProductView>> findByPage(ProductQueryParam productQueryParam);

    ReturnT<PageList<ProductView>> findByPage(ProductQueryBaseParam productQueryParam);

    ReturnT<List<ProductValueView>> queryValueList(Long mProductId);

    ReturnT<ProductMadePageView> getMadeInfoByProductName(ProductMadeQueryParam param);

    ReturnT<ColorSizeListView> getColorSizeList(ProductMadeQueryParam param);

    ReturnT getProductListByGroupNo(DpGroupQueryParam param);

    ReturnT getProductGroupPage(DpGroupQueryParam param);

    ReturnT getProductListByGh(ClGroupQueryParam param);

    ReturnT getProductListGhPage(ClGroupQueryParam param);
}
