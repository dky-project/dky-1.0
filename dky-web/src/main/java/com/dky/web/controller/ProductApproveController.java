package com.dky.web.controller;

import com.dky.business.repository.biz.DimNewService;
import com.dky.business.repository.biz.ProductApproveService;
import com.dky.business.repository.biz.ProductService;
import com.dky.common.param.BMptApproveSaveParam;
import com.dky.common.param.ProductApproveDetailParam;
import com.dky.common.param.ProductApproveQueryParam;
import com.dky.common.param.ProductMadeQueryParam;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ProductApproveInfoView;
import com.dky.common.response.view.ProductApproveTitleView;
import com.dky.common.response.view.ProductApproveView;
import com.dky.common.response.view.ProductMadePageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 订单controller
 * Created by wonpera on 2017/1/6.
 */
@RestController
@RequestMapping("productApprove")
public class ProductApproveController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductApproveController.class);

    @Autowired
    private ProductApproveService approveService;
    @Autowired
    private DimNewService dimNewService;
    @Autowired
    private ProductService productService;


    /**
     * 查询订单，分页
     * @param param
     * @return
     */
    @RequestMapping(value = "page",name = "订单分页查询")
    public ReturnT<PageList<ProductApproveView>> page(ProductApproveQueryParam param){
        return approveService.findByPage(param);
    }


    @RequestMapping(value = "productApproveInfoList",name = "查询订单详情")
    public ReturnT<List<ProductApproveInfoView>> queryProductApproveInfoList(Long[] ids){
        return approveService.queryProductApproveInfoList(ids);
    }

    @RequestMapping(value = "getProductApproveTitle",name = "定制页面第一步")
    public ReturnT<ProductApproveTitleView> getProductApproveTitle(ProductApproveDetailParam param){
        return dimNewService.getProductApproveTitle(param);
    }

    @RequestMapping(value = "getMadeInfoByProductName",name = "定制页面第一步")
    public ReturnT<ProductMadePageView> getMadeInfoByProductName(ProductMadeQueryParam param){
        return productService.getMadeInfoByProductName(param);
    }

    @RequestMapping(value = "bMptApproveSave",name = "下单保存大货类型订单接口")
    public ReturnT bMptApproveSave(BMptApproveSaveParam param){
        return approveService.bMptApproveSave(param);
    }
}
