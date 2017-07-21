package com.dky.web.controller;

import com.dky.business.repository.biz.BootService;
import com.dky.business.repository.biz.ProductService;
import com.dky.common.bean.Boot;
import com.dky.common.param.BootQueryParam;
import com.dky.common.param.ProductQueryBaseParam;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by wonpera on 2017/1/3.
 */
@RestController
@RequestMapping("boot")
public class BootController {

    @Autowired
    private BootService bootService;
    @Autowired
    private ProductService productService;


    /**
     * 查询有效的启动页
     * @param param
     * @return
     */
    @RequestMapping(value = "queryValid",name = "查询有效的启动页")
    public ReturnT<List<Boot>> queryValid(BootQueryParam param){
        return bootService.queryValid(param);
    }

    @RequestMapping(value = "insert",name = "新增启动页",method = RequestMethod.POST)
    public ReturnT inert(Boot boot){
        bootService.insertSelective(boot);
        return new ReturnT().sucessData(boot);
    }

    @RequestMapping("page")
    public ModelAndView pageHtml(){
        return new ModelAndView("page");
    }

    @RequestMapping(value = "pageList",name = "样衣查询分页")
    public ReturnT<PageList<ProductView>> queryPage(ProductQueryBaseParam productQueryParam){
        return productService.findByPage(productQueryParam);
    }
}
