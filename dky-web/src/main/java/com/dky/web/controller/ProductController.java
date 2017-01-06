package com.dky.web.controller;

import com.dky.business.repository.biz.ProductService;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ProductInfoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 样衣查询congtroller
 * Created by wangpeng on 2017/1/5.
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;


    /**
     * 样衣详细信息查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/getProductInfo/{id}" ,name="样衣详细信息查询")
    public ReturnT<ProductInfoView> getProductInfo(@PathVariable(value = "id") Long id){
        return productService.getProductInfo(id);
    }
}
