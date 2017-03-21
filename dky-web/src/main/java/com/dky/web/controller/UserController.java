package com.dky.web.controller;

import com.dky.business.repository.biz.UserService;
import com.dky.business.repository.session.SessionProcess;
import com.dky.common.bean.SessionUser;
import com.dky.common.bean.Store;
import com.dky.common.bean.Users;
import com.dky.common.param.LoginUserParam;
import com.dky.common.response.ReturnT;
import com.dky.common.utils.DkyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by hang on 2017/1/4 0004.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionProcess sessionProcess;

    @RequestMapping(value = "loginUser", name = "登录")
    public ReturnT loginUser(LoginUserParam param, HttpServletResponse response) {
        ReturnT returnT = userService.loginUser(param);
        if (!returnT.isSuccess()) {
            return returnT;
        }
        Object data = returnT.getData();
        SessionUser sessionUser = new SessionUser();
        if(data instanceof Users){
            Users users = (Users) data;
            sessionUser.setUserId(users.getId());
            sessionUser.setEmail(users.getEmail());
            sessionUser.setcCustomerId(users.getcCustomerId());
            sessionUser.setcStoreId(users.getcStoreId());
        }else if(data instanceof Store){
            Store store = (Store)data;
            sessionUser.setUserId(893l);
            sessionUser.setEmail(store.getEmail());
            sessionUser.setcCustomerId(store.getcCustomerId());
            sessionUser.setcStoreId(store.getcStoreId());
        }
        String token = sessionProcess.login(sessionUser, response, 60 * 60 * 24 * 7 * 1000L);
        return new ReturnT().sucessData(token);
    }


    /**
     * 获取当前登陆用户信息
     * @return
     */
    @RequestMapping(value = "getCurrentUser",name = "获取当前登陆用户")
    public ReturnT getCurrentUser(){
        SessionUser sessionUser = DkyUtils.getCurrentUser();//获取当前用户
        return new ReturnT().sucessData(sessionUser);
    }

    /**
     * 获取VIPNAME
     * @return
     */
    @RequestMapping(value = "getVipName",name = "获取当前登陆用户")
    public ReturnT getVipName(@RequestParam("phone")String phone){
        return userService.getVipName(phone);
    }
}
