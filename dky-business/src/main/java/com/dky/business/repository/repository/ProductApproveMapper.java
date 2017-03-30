package com.dky.business.repository.repository;

import com.dky.common.bean.ProductApprove;
import com.dky.common.response.view.ProductApproveInfoView;
import com.dky.common.response.view.ProductApproveView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@MyBatisRepository
public interface ProductApproveMapper {
    List<ProductApproveView> queryByPage(ProductApprove productApprove);

    int count(ProductApprove productApprove);

    List<ProductApproveInfoView> queryProductApproveInfoList(@Param("ids") Long[] ids);

    void insertProductApprove(ProductApprove productApprove);

    Long getProductApproveSeq();

    int updateProductApproveById(ProductApprove productApprove);

    void bMptApproveSave(@Param("jgNo")Long jgNo,
                         @Param("productName")String productName,
                         @Param("sizeId")Long sizeId,
                         @Param("colorId")Long colorId);

    void productApproveAc(@Param("id")Long id);

    String getScorder(Map<String,Object> map);
}