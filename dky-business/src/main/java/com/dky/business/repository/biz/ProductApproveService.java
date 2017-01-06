package com.dky.business.repository.biz;

import com.dky.common.param.ProductApproveQueryParam;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ProductApproveInfoView;
import com.dky.common.response.view.ProductApproveView;

import java.util.List;

/**
 * Created by wonpera on 2017/1/6.
 */
public interface ProductApproveService {

    ReturnT<PageList<ProductApproveView>> findByPage(ProductApproveQueryParam param);


    ReturnT<List<ProductApproveInfoView>>  queryProductApproveInfoList(Long[] ids);
}
