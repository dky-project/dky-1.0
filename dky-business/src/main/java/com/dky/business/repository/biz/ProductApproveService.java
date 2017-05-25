package com.dky.business.repository.biz;

import com.dky.common.param.*;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ProductApproveInfoView;
import com.dky.common.response.view.ProductApproveReturnView;
import com.dky.common.response.view.ProductApproveView;

import java.util.List;

/**
 * Created by wonpera on 2017/1/6.
 */
public interface ProductApproveService {

    ReturnT<PageList<ProductApproveView>> findByPage(ProductApproveQueryParam param);

    ReturnT<ProductApproveReturnView> insertProductApprove(AddProductApproveParam param);

    ReturnT<ProductApproveReturnView> addProductDefault(AddProductApproveParam param);

    ReturnT updateProductApproveList(Long[] ids);

    ReturnT<List<ProductApproveInfoView>>  queryProductApproveInfoList(Long[] ids);

    ReturnT bMptApproveSave(BMptApproveSaveParam param);

    ReturnT confirmProductApprove(UpdateProductApproveParam param);
}
