package com.dky.business.repository.repository;

import com.dky.common.response.view.ProductInfoView;


@MyBatisRepository
public interface ProductMapper {

    ProductInfoView getProductInfo(Long id);
}