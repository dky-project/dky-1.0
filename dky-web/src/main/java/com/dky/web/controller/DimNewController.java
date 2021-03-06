package com.dky.web.controller;

import com.dky.business.repository.biz.DimNewService;
import com.dky.common.enums.DimFlagEnum;
import com.dky.common.param.*;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.DimNewListView;
import com.dky.common.response.view.ProductColorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wangpeng on 2017/1/10.
 */
@RestController
@RequestMapping("dimNew")
public class DimNewController {

    @Autowired
    private DimNewService dimNewService;

    @RequestMapping(value = "getDimNewList",name = "获取属性枚举")
    public ReturnT<DimNewListView> getBigClassEnum(DimNewParam param){
        ReturnT<DimNewListView> result = new ReturnT<>();
        DimNewListView view = new DimNewListView();
        view.setSexList(dimNewService.queryByDimFlag(DimFlagEnum.SEX.getCode()).getData());
        view.setBigClassList(dimNewService.queryByDimFlag(DimFlagEnum.BIG_CLASS.getCode()).getData());
        view.setPzList(dimNewService.queryByDimFlag(DimFlagEnum.PZ_FLAG.getCode()).getData());
        view.setZzList(dimNewService.queryByDimFlag(DimFlagEnum.ZZ_FLAG.getCode()).getData());
        view.setZxList(dimNewService.queryByDimFlag(DimFlagEnum.ZX_FLAG.getCode()).getData());
        view.setSyList(dimNewService.queryByDimFlag(DimFlagEnum.SY_FLAG.getCode()).getData());
        view.setLxList(dimNewService.queryByDimFlag(DimFlagEnum.LX_FLAG.getCode()).getData());
        view.setXxList(dimNewService.queryByDimFlag(DimFlagEnum.XX_FLAG.getCode()).getData());
        view.setYearList(dimNewService.queryDefaultDimByDimText(DimFlagEnum.YEAR_FLAG.getCode()).getData());
        view.setPinList(dimNewService.queryByDimText(DimFlagEnum.PIN_FLAG.getCode()).getData());
        result.setData(view);
        return result.successDefault();
    }


    /**
     * 1、	选择品种下拉框接口  flag:1
     * 2、	选择组织下拉框接口  flag:2
     * 3、	选择针型下拉框接口  flag:3
     * 4、	选择支别下拉框接口  flag:4
     * @param param
     * @return
     */
    @RequestMapping(value = "getPzsJson",name = "选择下拉框接口")
    public ReturnT getPzsJson(PzsJsonQueryParam param){
        return dimNewService.getpzsJson(param);
    }

    @RequestMapping(value = "getColorList",name = "选择颜色列表")
    public ReturnT<List<ProductColorView>> getColorList(ColorQueryParam param){
        return dimNewService.getColorList(param);
    }

    @RequestMapping(value = "getColorDimList",name = "选择颜色品种列表")
    public ReturnT getColorDimList(ColorDimQueryParam param){
        return dimNewService.getColorDimList(param);
    }

    @RequestMapping(value = "getSizeData",name = "根据胸围获取尺寸数据")
    public ReturnT getSizeData(SizeDataQueryParam param){
        return dimNewService.getSizeData(param);
    }

    @RequestMapping(value = "getAttribnameList",name = "获取系列")
    public ReturnT getAttribnameList(){
        return dimNewService.getAttribnameList();
    }
}
