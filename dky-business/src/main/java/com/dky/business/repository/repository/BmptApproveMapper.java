package com.dky.business.repository.repository;

import com.dky.common.bean.BmptApprove;
import com.dky.common.param.BmptApproveQueryParam;
import com.dky.common.response.view.BmptApproveView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisRepository
public interface BmptApproveMapper {

    List<BmptApproveView> queryByPage(BmptApproveQueryParam bmptApprove);

    int count(BmptApproveQueryParam bmptApprove);

    void bMptApproveSave(@Param("jgNo")String jgNo,
                         @Param("productName")String productName,
                         @Param("sizeId")Long sizeId,
                         @Param("colorId")Long colorId);

    Long getBmptApproveSeq();

    void insertBmptApprove(@Param("id")Long id,
                           @Param("jgNo")String jgNo,
                           @Param("mProductId")Long mProductId,
                           @Param("sizeId")Long sizeId,
                           @Param("colorId")Long colorId);

    void bmptApproveAcm(Long id);

    void updateBmptApproveById(BmptApprove bmptApprove);
}