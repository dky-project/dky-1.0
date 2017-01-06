package com.dky.web.controller;

import com.dky.business.repository.biz.ProductApproveService;
import com.dky.common.param.ProductApproveQueryParam;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ProductApproveView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    /**
     * 查询订单，分页
     * @param param
     * @return
     */
    @RequestMapping(value = "page",name = "订单分页查询")
    public ReturnT<PageList<ProductApproveView>> page(ProductApproveQueryParam param){
        return approveService.findByPage(param);
    }
}
