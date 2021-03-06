package com.dky.business.repository.repository;

import com.dky.common.bean.ProductApprove;
import com.dky.common.param.ProductApproveMergeQueryParam;
import com.dky.common.response.view.ProductApproveInfoView;
import com.dky.common.response.view.ProductApproveTotalView;
import com.dky.common.response.view.ProductApproveView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@MyBatisRepository
public interface ProductApproveMapper {
    List<ProductApproveView> queryByPage(ProductApprove productApprove);

    List<ProductApproveView> queryByPageGroup(ProductApprove productApprove);

    int count(ProductApprove productApprove);

    int countGroup(ProductApprove productApprove);

    List<ProductApproveInfoView> queryProductApproveInfoList(@Param("ids") Long[] ids,@Param("code")String code);

    void insertProductApprove(ProductApprove productApprove);

    void addProductDefault(ProductApprove productApprove);

    Long getProductApproveSeq();

    int updateProductApproveById(ProductApprove productApprove);

    int updateProductApproveByApproveId(ProductApprove productApprove);

    void productApproveAc(@Param("id")Long id);

    void addProductDefaultAc(Map<String,Object> map);

    void add_product_dp_group(Map<String,Object> map);

    String getScorder(Map<String,Object> map);

    String getMaxNo(@Param("code")String code,@Param("czDate")String czDate);

    void updateProductApproveList(@Param("ids") Long[] ids);

    Map<Object,Object> queryTotalMap(ProductApprove productApprove);

    Map<Object,Object> queryGroupTotalMap(ProductApprove productApprove);

    ProductApprove getById(Long id);

    List<ProductApproveTotalView> queryByPageJmTotalGroup(ProductApproveMergeQueryParam param);

    int countJmTotalGroup(ProductApproveMergeQueryParam param);

    Map<Object,Object> queryJmGroupTotalMap(ProductApproveMergeQueryParam param);

    List<ProductApproveTotalView> queryByPageDHHTotalGroup(ProductApproveMergeQueryParam param);

    int countDHHTotalGroup(ProductApproveMergeQueryParam param);

    Map<Object,Object> queryDHHGroupTotalMap(ProductApproveMergeQueryParam param);

    List<ProductApproveTotalView> getByPageDHHTotalGroup(@Param("id")Long id);

    List<ProductApproveTotalView> getByPageJMTotalGroup(@Param("id")Long id);

    List<ProductApprove> selectByView(ProductApproveTotalView view);

    void delById(@Param("id")Long id);

    String getProductApproveDocno();
}