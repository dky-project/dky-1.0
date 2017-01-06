package com.dky.business.repository.repository;

import com.dky.common.bean.Product;
import com.dky.common.response.view.ProductInfoView;
import com.dky.common.response.view.ProductValueView;
import com.dky.common.response.view.ProductView;

import java.util.List;


@MyBatisRepository
public interface ProductMapper extends BaseDao<Product,Long> {

    ProductInfoView getProductInfo(Long id);

    List<ProductView> queryByPage(Product product);

    int count(Product product);


    /**
     * 查询胸围、衣长、肩宽、袖长
     * @param mProductId
     * @return
     */
    List<ProductValueView> queryValueList(Long mProductId);
}