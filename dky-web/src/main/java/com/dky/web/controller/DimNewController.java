package com.dky.web.controller;

import com.dky.business.repository.biz.DimNewService;
import com.dky.common.enums.DimFlagEnum;
import com.dky.common.param.DimNewParam;
import com.dky.common.response.ReturnT;
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


    @RequestMapping(value = "getSexEnum",name = "获取性别枚举")
    public ReturnT<List<DimNewView>> getSexEnum(){
        return dimNewService.queryByDimFlag(DimFlagEnum.SEX.getCode());
    }


    @RequestMapping(value = "getBigClassEnum",name = "获取大类枚举")
    public ReturnT<List<DimNewView>> getBigClassEnum(){
        return dimNewService.queryByDimFlag(DimFlagEnum.BIG_CLASS.getCode());
    }

    @RequestMapping(value = "getAllDimList",name = "获取属性枚举")
    public ReturnT<List<DimNewView>> getBigClassEnum(DimNewParam param){
        return dimNewService.queryByDimFlag(param.getDimFlagNew());
    }
}
