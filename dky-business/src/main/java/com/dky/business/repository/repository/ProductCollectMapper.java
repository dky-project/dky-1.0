package com.dky.business.repository.repository;

import com.dky.common.bean.ProductCollect;
import com.dky.common.param.ProductCollectQueryParam;
import com.dky.common.response.view.ProductView;

import java.util.List;

@MyBatisRepository
public interface ProductCollectMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductCollect record);

    int insertSelective(ProductCollect record);

    ProductCollect selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductCollect record);

    int updateByPrimaryKey(ProductCollect record);

    int mergeIntoProductCollect(ProductCollect record);

    List<ProductView> queryByPage(ProductCollectQueryParam param);

    int count(ProductCollectQueryParam param);

    int addProductBatchCollect(ProductCollect record);
}