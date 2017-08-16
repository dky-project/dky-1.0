package com.dky.business.repository.biz;

import com.dky.common.param.AddDpGroupParam;
import com.dky.common.param.AddProductApproveParam;
import com.dky.common.param.BMptApproveSaveParam;
import com.dky.common.param.UpdateProductApproveParam;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ProductApproveInfoView;
import com.dky.common.response.view.ProductApproveReturnView;

import java.util.List;

/**
 * Created by wonpera on 2017/1/6.
 */
public interface ProductApproveService {

    ReturnT<PageList> findByPage(Object param);

    ReturnT<ProductApproveReturnView> insertProductApprove(AddProductApproveParam param);

    ReturnT<ProductApproveReturnView> addProductDefault(AddProductApproveParam param);

    ReturnT updateProductApproveList(Long[] ids);

    ReturnT<List<ProductApproveInfoView>>  queryProductApproveInfoList(Long[] ids);

    ReturnT bMptApproveSave(BMptApproveSaveParam param);

    ReturnT bMptApproveInsert(BMptApproveSaveParam param);

    ReturnT confirmProductApprove(UpdateProductApproveParam param);

    ReturnT addProductDpGroup(AddDpGroupParam param);
}
