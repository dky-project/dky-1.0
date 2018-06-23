package com.dky.business.repository.biz;

import com.dky.common.param.AddProductBatchCollectParam;
import com.dky.common.param.AddProductCollectParam;
import com.dky.common.param.ProductCollectQueryParam;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ProductView;

/**
 * Created by wonpera on 2017/1/6.
 */
public interface ProductCollectService {

    ReturnT mergeIntoProductCollect(AddProductCollectParam param);

    ReturnT addProductBatchCollect(AddProductBatchCollectParam param);

    ReturnT delProductCollect(AddProductCollectParam param);

    ReturnT<PageList<ProductView>> findByPage(ProductCollectQueryParam param);
}
