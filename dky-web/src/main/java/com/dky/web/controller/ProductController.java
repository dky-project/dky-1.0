package com.dky.web.controller;

import com.dky.business.repository.biz.PdtBasepriceService;
import com.dky.business.repository.biz.ProductService;
import com.dky.common.bean.PdtBaseprice;
import com.dky.common.param.ProductQueryParam;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ProductInfoView;
import com.dky.common.response.view.ProductValueView;
import com.dky.common.response.view.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping(value = "/getProductInfo/{id}" ,name="样衣详细信息查询")
    public ReturnT<ProductInfoView> getProductInfo(@PathVariable(value = "id") Long id){
        return productService.getProductInfo(id);
    }


    /**
     * 查询胸围、衣长、肩宽、袖长列表
     * @param mProductId
     * @return
     */
    @RequestMapping(value = "/queryValueList/{mProductId}",name = "查询胸围、衣长、肩宽、袖长列表")
    public ReturnT<List<ProductValueView>> getProductValue(@PathVariable(value = "mProductId")Long mProductId){
        return productService.queryValueList(mProductId);
    }


    /**
     * 查询价格列表
     * @param mProductId
     * @return
     */
    @RequestMapping(value = "/queryPriceList/{mProductId}",name = "查询价格列表")
    public ReturnT<List<PdtBaseprice>> queryPriceListByProductId(@PathVariable(value = "mProductId")Long mProductId){
        return pdtBasepriceService.queryPriceListByProductId(mProductId);
    }
}
