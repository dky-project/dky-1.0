package com.dky.web.interceptor;


import com.dky.business.repository.session.SessionProcess;
import com.dky.common.bean.SessionUser;
import com.dky.common.enums.ResultCodeEnum;
import com.dky.common.exception.NoLoginException;
import com.dky.common.utils.DkyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * session拦截器
 * Created by wangpeng on 2017/1/10.
 */
public class SessionInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SessionProcess sessionProcess;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String accessToken = sessionProcess.getAcessToken(request);
        if(StringUtils.isEmpty(accessToken)){
            throw new NoLoginException(ResultCodeEnum.NOLOGIN.getMessage());
        }
        DkyUtils.putCurrentToken(accessToken);
        SessionUser user = sessionProcess.getSessionUser(accessToken);
        if(user == null){
            throw new NoLoginException(ResultCodeEnum.NOLOGIN.getMessage());
        }
        DkyUtils.putCurrentUser(user);//加入当前登陆用户
        return super.preHandle(request, response, handler);
    }
}
