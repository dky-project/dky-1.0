package com.dky.business.repository.repository;

import com.dky.common.bean.Product;
import com.dky.common.response.view.*;

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


    /**
     * 查询款号默认定制内容
     * @param mProductId
     * @return
     */
    ProductMadeInfoView getMadeInfoByProductId(Long mProductId);

    /**
     * 查询定制款号颜色列表
     * @param mProductId
     * @return
     */
    List<ProductColorView> getProductColorList(Long mProductId);

    /**
     * 查询定制款号尺寸列表
     * @param mProductId
     * @return
     */
    List<ProductSizeView> getProductSizeList(Long mProductId);

    /**
     * 查询定制款号尺寸列表
     * @param mProductId
     * @return
     */
    ProductCusmptcateView getProductCusmptcateInfo(Long mProductId);
}