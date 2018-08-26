package com.dky.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dky.business.repository.biz.DimNewService;
import com.dky.business.repository.biz.ProductApproveService;
import com.dky.business.repository.biz.ProductService;
import com.dky.common.enums.SourceEnum;
import com.dky.common.param.*;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ProductApproveInfoView;
import com.dky.common.response.view.ProductApproveReturnView;
import com.dky.common.response.view.ProductApproveTitleView;
import com.dky.common.response.view.ProductMadePageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Source;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public ReturnT<PageList> page(ProductApproveQueryParam param){
        return approveService.findByPage(param);
    }

    /**
     * 查询大货订单，分页
     * @param param
     * @return
     */
    @RequestMapping(value = "bmptPage",name = "订单分页查询")
    public ReturnT<PageList> page(BmptApproveQueryParam param){
        return approveService.findByPage(param);
    }

    /**
     * 订单查询合并
     * @param param
     * @return
     */
    @RequestMapping(value = "mergePage",name = "订单分页合并查询")
    public ReturnT<PageList> mergePage(ProductApproveMergeQueryParam param){
        return approveService.mergePage(param);
    }

    @RequestMapping(value = "productApproveInfoList",name = "查询订单详情")
    public ReturnT<List<ProductApproveInfoView>> queryProductApproveInfoList(Long[] ids) {
        return approveService.queryProductApproveInfoList(ids);
    }

    @RequestMapping(value = "productApproveMergeInfoList",name = "查询订单合并详情")
    public ReturnT productApproveMergeInfoList(ProductApproveMergeInfoQueryParam param){
        return approveService.productApproveMergeInfoList(param);
    }

    @RequestMapping(value = "updateProductApprove",name = "删除订单")
    public ReturnT updateProductApprove(Long[] ids){
        return approveService.updateProductApproveList(ids);
    }

    @RequestMapping(value = "getProductApproveTitle",name = "定制页面第一步")
    public ReturnT<ProductApproveTitleView> getProductApproveTitle(ProductApproveDetailParam param){
        return dimNewService.getProductApproveTitle(param);
    }

    @RequestMapping(value = "getMadeInfoByProductName",name = "定制页面第二步")
    public ReturnT<ProductMadePageView> getMadeInfoByProductName(ProductMadeQueryParam param){
        return productService.getMadeInfoByProductName(param);
    }

    @RequestMapping(value = "bMptApproveSave",name = "下单保存大货类型订单接口")
    public ReturnT bMptApproveSave(BMptApproveSaveParam param){
        return approveService.bMptApproveSave(param);
    }

    @RequestMapping(value = "addProductApprove",name = "下单保存基础款类型订单接口")
    public ReturnT<ProductApproveReturnView> addProductApprove(AddProductApproveParam param){
        if (!judgeContainsStr(param.getNo())){
            return  new ReturnT<>().failureData("编号必须为数字！");
        }
        if (Integer.valueOf(param.getNo()) > 999){
            return  new ReturnT<>().failureData("编号最大不能超过999！");
        }
        return approveService.insertProductApprove(param);
    }

    @RequestMapping(value = "addProductDefault",name = "收藏款号下单")
    public ReturnT<ProductApproveReturnView> addProductDefault(AddProductApproveParam param){
        if (!judgeContainsStr(param.getNo())){
            return  new ReturnT<>().failureData("编号必须为数字！");
        }
        if (Integer.valueOf(param.getNo()) > 999){
            return  new ReturnT<>().failureData("编号最大不能超过999！");
        }
        return approveService.addProductDefault(param);
    }

    @RequestMapping(value = "confirmProductApprove",name = "确认下单")
    public ReturnT confirmProductApprove(UpdateProductApproveParam param){
        return approveService.confirmProductApprove(param);
    }

    @RequestMapping(value = "tableApproveSave",name = "下单保存大货类型订单接口")
    public ReturnT tableApproveSave(TableApproveSaveParam param){
        LOGGER.info("<<<<<<<<<<<<<<<<<<<<<param:{}", JSON.toJSONString(param));
        if (param.getItemDatas() != null && !"".equals(param.getItemDatas())){
            JSONArray array = JSON.parseArray(param.getItemDatas());
            for(int i = 0;i<array.size();i++){
                JSONObject json = (JSONObject) array.get(i);
                BMptApproveSaveParam bMptApproveSaveParam = new BMptApproveSaveParam();
                bMptApproveSaveParam.setProductName(param.getProductName().trim());
                bMptApproveSaveParam.setPdtId(param.getPdtId());
                bMptApproveSaveParam.setColorId(json.getLong("color"));
                bMptApproveSaveParam.setSizeId(json.getLong("size"));
                bMptApproveSaveParam.setQty(json.getLong("qty"));
                if (null == param.getIssource()){
                    bMptApproveSaveParam.setIssource(SourceEnum.DEFALUT.getCode());
                }else {
                    bMptApproveSaveParam.setIssource(param.getIssource());
                }
                bMptApproveSaveParam.setSessionUser(param.getSessionUser());
                if (bMptApproveSaveParam.getQty() > 0){
                    ReturnT returnT = approveService.bMptApproveInsert(bMptApproveSaveParam);
                    if (returnT.isFailed()){
                        return returnT;
                    }
                }
            }
            return new ReturnT().successDefault();
        }else {
            return new ReturnT().failureData("无数据保存！");
        }
    }

    @RequestMapping(value = "addProductDpGroup",name = "搭配款号下单")
    @ResponseBody
    public ReturnT<ProductApproveReturnView> addProductDpGroup(AddDpGroupParam param){
        return approveService.addProductDpGroup(param);
    }

    @RequestMapping(value = "getDataAnalysisList",name = "数据分析")
    public ReturnT getDataAnalysisList(DataAnalysisParam param){
        return dimNewService.getDataAnalysisList(param);
    }

    public boolean judgeContainsStr(String no) {
        //String regex=".*[a-zA-Z]+.*";
        String regex="^\\d+$";
        Matcher m= Pattern.compile(regex).matcher(no);
        return m.matches();
    }
}
