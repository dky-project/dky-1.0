package com.dky.web.controller;

import com.dky.business.repository.biz.BootService;
import com.dky.common.bean.Boot;
import com.dky.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by wonpera on 2017/1/3.
 */
@RestController
@RequestMapping("boot")
public class BootController {

    @Autowired
    private BootService bootService;

    @RequestMapping("getById")
    public ReturnT<Boot> getById(){
        return new ReturnT<>().sucessData(bootService.selectByPrimaryKey(1L));
    }

    @RequestMapping("insert")
    public ReturnT inert(){
        Boot boot = new Boot();
        boot.setId(1l);
        Date now = new Date();
        boot.setCreationdate(now);
        boot.setIsactive("0");
        boot.setImageurl("sadsadasdasdad");
        bootService.insertSelective(boot);
        return new ReturnT().sucessData(boot);
    }
}
