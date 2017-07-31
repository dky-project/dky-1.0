package com.dky.web.controller;

import com.dky.business.repository.biz.PdtBasepriceService;
import com.dky.business.repository.biz.ProductService;
import com.dky.common.bean.PdtBaseprice;
import com.dky.common.param.ProductMadeQueryParam;
import com.dky.common.param.ProductQueryParam;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ColorSizeListView;
import com.dky.common.response.view.ProductInfoView;
import com.dky.common.response.view.ProductValueView;
import com.dky.common.response.view.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 样衣查询congtroller
 * Created by wangpeng on 2017/1/5.
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private PdtBasepriceService pdtBasepriceService;

    @RequestMapping(value = "page",name = "样衣查询分页")
    public ReturnT<PageList<ProductView>> queryPage(ProductQueryParam productQueryParam){
        return productService.findByPage(productQueryParam);
    }

    /**
     * 样衣详细信息查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/getProductInfo" ,name="样衣详细信息查询")
    public ReturnT<ProductInfoView> getProductInfo(@RequestParam(value = "id",required = false) Long id){
        if(id == null){
            return new ReturnT<>().failureData("id不能为空");
        }
        return productService.getProductInfo(id);
    }

    /**
     * 查询胸围、衣长、肩宽、袖长列表
     * @param mProductId
     * @return
     */
    @RequestMapping(value = "/queryValueList",name = "查询胸围、衣长、肩宽、袖长列表")
    public ReturnT<List<ProductValueView>> getProductValue(@RequestParam(value = "mProductId",required = false)Long mProductId){
        if(mProductId == null){
            return new ReturnT<>().failureData("mProductId不能为空");
        }
        return productService.queryValueList(mProductId);
    }

    /**
     * 查询价格列表
     * @param mProductId
     * @return
     */
    @RequestMapping(value = "/queryPriceList",name = "查询价格列表")
    public ReturnT<List<PdtBaseprice>> queryPriceListByProductId(@RequestParam(value = "mProductId",required = false)Long mProductId){
        if(mProductId == null){
            return new ReturnT<>().failureData("mProductId不能为空");
        }
        return pdtBasepriceService.queryPriceListByProductId(mProductId);
    }

    /**
     * 查询颜色尺寸矩阵列表
     * @param param
     * @return
     */
    @RequestMapping(value = "/queryColorSizeList",name = "查询颜色尺寸矩阵列表")
    public ReturnT<ColorSizeListView> queryPriceListByProductId(ProductMadeQueryParam param){
        return productService.getColorSizeList(param);
    }
}
