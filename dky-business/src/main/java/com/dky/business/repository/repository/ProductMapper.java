package com.dky.business.repository.repository;

import com.dky.common.bean.Product;
import com.dky.common.response.view.ProductInfoView;

public interface ProductMapper {

    ProductInfoView getProductInfo(Long id);
}