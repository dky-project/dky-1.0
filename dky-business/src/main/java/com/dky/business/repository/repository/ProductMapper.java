package com.dky.business.repository.repository;

import com.dky.common.bean.Product;
import com.dky.common.response.view.*;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


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
     * 根据款号查询定制款号颜色列表
     * @param mProductId
     * @return
     */
    List<ProductColorView> getProductColorListByProductId(Long mProductId);

    /**
     * 根据品种查询定制款号颜色列表
     * @param mDimNew14Id
     * @return
     */
    List<ProductColorView> getProductColorListByDimId(Long mDimNew14Id);

    /**
     * 根据款号查询定制款号颜色列表
     * @param mProductId
     * @return
     */
    List<ProductColorView> getColorDimListByProductId(Long mProductId);

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

    /**
     * 查询颜色尺寸矩阵
     * @param productName
     * @return
     */
    List<ColorSizeView> getColorSizeList(String productName);

    /**
     * 搭配款号列表
     * @param ids
     * @return
     */
    List<DpGroupView> getProductListByIds(@Param("ids") List<Long> ids,@Param("code")String code);

    String getProductImgUrl(Long mProductId);

    String getProductPrice(Map<String,Object> map);

    BigDecimal getMpdtProductPrice(Long mProductId);
}