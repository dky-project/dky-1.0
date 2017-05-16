package com.dky.web.controller;

import com.dky.business.repository.biz.ProductCollectService;
import com.dky.common.param.AddProductCollectParam;
import com.dky.common.param.ProductCollectQueryParam;
import com.dky.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 样衣查询congtroller
 * Created by wangpeng on 2017/1/5.
 */
@RestController
@RequestMapping("productCollect")
public class ProductCollectController {

    @Autowired
    private ProductCollectService productCollectService;

    @RequestMapping(value = "page",name = "收藏列表分页")
    public ReturnT findByPage(ProductCollectQueryParam param){
        return productCollectService.findByPage(param);
    }

    @RequestMapping(value = "addProductCollect",name = "收藏")
    public ReturnT addProductCollect(AddProductCollectParam param){
        return productCollectService.mergeIntoProductCollect(param);
    }

    @RequestMapping(value = "delProductCollect",name = "取消收藏")
    public ReturnT delProductCollect(AddProductCollectParam param){
        return productCollectService.delProductCollect(param);
    }

}
