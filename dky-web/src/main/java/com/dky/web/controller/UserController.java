package com.dky.web.controller;

import com.dky.business.repository.biz.UserService;
import com.dky.business.repository.session.SessionProcess;
import com.dky.common.bean.SessionUser;
import com.dky.common.bean.Users;
import com.dky.common.constats.GlobConts;
import com.dky.common.param.LoginUserParam;
import com.dky.common.response.ReturnT;
import com.dky.common.utils.DkyUtils;
import com.dky.common.utils.ThreadLocalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
        ReturnT<Users> returnT = userService.loginUser(param);
        if (!returnT.isSuccess()) {
            return returnT;
        }
        SessionUser sessionUser = new SessionUser();
        sessionUser.setEmail(returnT.getData().getEmail());
        sessionUser.setcCustomerId(returnT.getData().getcCustomerId());
        sessionUser.setcStoreId(returnT.getData().getcStoreId());
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
}
