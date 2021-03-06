package com.dky.web.controller;

import com.dky.business.repository.biz.DimNewService;
import com.dky.business.repository.biz.PdtBasepriceService;
import com.dky.business.repository.biz.ProductService;
import com.dky.common.param.*;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.*;
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
    @Autowired
    private DimNewService dimNewService;

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
    public ReturnT<ProductInfoView> getProductInfo(@RequestParam(value = "id",required = false) Long id,@RequestParam(value = "isBuy",required = false) String isBuy,@RequestParam(value = "version",required = false) String versionNo){
        if(id == null){
            return new ReturnT<>().failureData("id不能为空");
        }
        return productService.getProductInfo(id,isBuy,versionNo);
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
    public ReturnT<List<PdtPriceView>> queryPriceListByProductId(@RequestParam(value = "mProductId",required = false)Long mProductId){
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

    /**
     * 搭配详情
     * @param param
     * @return
     */
    @RequestMapping(value = "/getProductListByGroupNo",name = "搭配详情")
    public ReturnT getProductListByGroupNo(DpGroupQueryParam param){
        return productService.getProductListByGroupNo(param);
    }

    /**
     * 陈列详情
     * @param param
     * @return
     */
    @RequestMapping(value = "/getProductListByGh",name = "陈列详情")
    public ReturnT getProductListByGh(ClGroupQueryParam param){
        return productService.getProductListByGh(param);
    }

    /**
     * 搭配列表
     * @param param
     * @return
     */
    @RequestMapping(value = "/getProductGroupPage",name = "搭配列表")
    public ReturnT getProductGroupPage(DpGroupQueryParam param){
        return productService.getProductGroupPage(param);
    }

    /**
     * 陈列列表
     * @param param
     * @return
     */
    @RequestMapping(value = "/getProductListGhPage",name = "陈列列表")
    public ReturnT getProductListGhPage(ClGroupQueryParam param){
        return productService.getProductListGhPage(param);
    }

    @RequestMapping(value = "getProductPrice",name = "获取价格")
    public ReturnT getProductPrice(ProductPriceQueryParam param){
        return dimNewService.getProductPrice(param);
    }
}
