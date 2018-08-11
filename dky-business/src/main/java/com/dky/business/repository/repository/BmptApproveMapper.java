package com.dky.business.repository.repository;

import com.dky.common.bean.BmptApprove;
import com.dky.common.param.BmptApproveQueryParam;
import com.dky.common.response.view.BmptApproveInfoView;
import com.dky.common.response.view.BmptApproveView;
import com.dky.common.response.view.ProductApproveTotalView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@MyBatisRepository
public interface BmptApproveMapper {

    List<BmptApproveView> queryByPage(BmptApproveQueryParam bmptApprove);

    int count(BmptApproveQueryParam bmptApprove);

    void bMptApproveSave(@Param("jgNo") String jgNo,
                         @Param("productName") String productName,
                         @Param("sizeId") Long sizeId,
                         @Param("colorId") Long colorId,
                         @Param("issource") Integer issource);

    void bMptApproveInsert(@Param("jgNo") String jgNo,
                           @Param("pdtId") Long pdtId,
                           @Param("sizeId") Long sizeId,
                           @Param("colorId") Long colorId,
                           @Param("qty") Long qty,
                           @Param("issource") Integer issource);

    Long getBmptApproveSeq();

    void insertBmptApprove(@Param("id") Long id,
                           @Param("jgNo") String jgNo,
                           @Param("mProductId") Long mProductId,
                           @Param("sizeId") Long sizeId,
                           @Param("colorId") Long colorId,
                           @Param("qty") Long qty,
                           @Param("issource") Integer issource);

    void bmptApproveAcm(Long id);

    void updateBmptApproveById(BmptApprove bmptApprove);

    Map<Object,Object> queryTotalMap(BmptApproveQueryParam bmptApprove);

    void delById(@Param("id")Long id);

    List<BmptApprove> selectByView(ProductApproveTotalView view);

    List<BmptApproveInfoView> queryBmptApproveInfoList(@Param("ids") Long[] ids);
}