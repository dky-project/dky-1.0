package com.dky.business.repository.repository;

import com.dky.common.bean.ProductApprove;
import com.dky.common.response.view.ProductApproveView;

import java.util.List;

@MyBatisRepository
public interface ProductApproveMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductApprove record);

    int insertSelective(ProductApprove record);

    ProductApprove selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductApprove record);

    int updateByPrimaryKey(ProductApprove record);


    List<ProductApproveView> queryByPage(ProductApprove productApprove);

    int count(ProductApprove productApprove);
}