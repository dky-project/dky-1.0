package com.dky.web.controller;

import com.dky.business.repository.biz.UserService;
import com.dky.business.repository.session.SessionProcess;
import com.dky.common.bean.SessionUser;
import com.dky.common.bean.Users;
import com.dky.common.param.LoginUserParam;
import com.dky.common.response.ReturnT;
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
        SessionProcess sessionProcess = new SessionProcess();
        sessionProcess.login(sessionUser, response, 60 * 60 * 24 * 7 * 1000L);
        return new ReturnT().successDefault();
    }
}
