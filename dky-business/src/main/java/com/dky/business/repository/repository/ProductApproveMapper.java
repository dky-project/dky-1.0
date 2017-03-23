package com.dky.business.repository.repository;

import com.dky.common.bean.ProductApprove;
import com.dky.common.response.view.ProductApproveInfoView;
import com.dky.common.response.view.ProductApproveView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisRepository
public interface ProductApproveMapper {
    List<ProductApproveView> queryByPage(ProductApprove productApprove);

    int count(ProductApprove productApprove);

    List<ProductApproveInfoView> queryProductApproveInfoList(@Param("ids") Long[] ids);

    Long insertProductApprove(ProductApprove productApprove);

    int updateProductApproveById(ProductApprove productApprove);

    void bMptApproveSave(@Param("jgNo")Long jgNo,
                         @Param("productName")String productName,
                         @Param("sizeId")Long sizeId,
                         @Param("colorId")Long colorId);

    void productApproveAc(@Param("id")Long id);

    String getScorder(@Param("id")Long id);
}