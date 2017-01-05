package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.UserService;
import com.dky.business.repository.repository.UsersMapper;
import com.dky.common.bean.Users;
import com.dky.common.enums.ResultCodeEnum;
import com.dky.common.param.LoginUserParam;
import com.dky.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hang on 2017/1/4 0004.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public ReturnT<Users> loginUser(LoginUserParam param) {
        ReturnT<Users> result = new ReturnT<>();
        Users users = usersMapper.selectByEmail(param.getEmail());
        if(users == null){
            return result.failureData(ResultCodeEnum.USER_LOGIN_ERROR);
        }
        if (users == null || !users.getPasswordhash().equals(param.getPassword())){
            return result.failureData(ResultCodeEnum.LOGIN_PASSWORD_ERROR);
        }
        result.setData(users);
        return result.successDefault();
    }
}
