package com.dky.web.controller;

import com.dky.business.repository.biz.DimNewService;
import com.dky.common.enums.DimFlagEnum;
import com.dky.common.param.DimNewParam;
import com.dky.common.param.PzsJsonQueryParam;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.DimNewListView;
import com.dky.common.response.view.DimNewView;
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
        view.setYearList(dimNewService.queryByDimText(DimFlagEnum.YEAR_FLAG.getCode()).getData());
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
    public String getPzsJson(PzsJsonQueryParam param){
        return dimNewService.getpzsJson(param);
    }
}
