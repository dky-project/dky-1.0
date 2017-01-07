package com.dky.business.repository.repository;

import com.dky.common.bean.ProductApprove;
import com.dky.common.response.view.ProductApproveInfoView;
import com.dky.common.response.view.ProductApproveView;

import java.util.List;

@MyBatisRepository
public interface ProductApproveMapper {
    List<ProductApproveView> queryByPage(ProductApprove productApprove);

    int count(ProductApprove productApprove);

    List<ProductApproveInfoView> queryProductApproveInfoList(Long[] ids);

    Long insertProductApprove(ProductApprove productApprove);

    int updateProductApproveById(ProductApprove productApprove);
}