package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.UserService;
import com.dky.business.repository.cache.RedisCacheManager;
import com.dky.business.repository.repository.UsersMapper;
import com.dky.common.bean.Users;
import com.dky.common.enums.ResultCodeEnum;
import com.dky.common.param.LoginUserParam;
import com.dky.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hang on 2017/1/4 0004.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private RedisCacheManager redisCacheManager;

    @Override
    public ReturnT loginUser(LoginUserParam param) {
        Users users = usersMapper.selectByEmail(param.getEmail());
        if (users == null || !users.getPassword().equals(param.getPassword())){
            return new ReturnT().failureData(ResultCodeEnum.USER_LOGIN_ERROR.getCode(),ResultCodeEnum.USER_LOGIN_ERROR.getMessage());
        }
        return null;
    }
}
