package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.UserService;
import com.dky.business.repository.repository.StoreMapper;
import com.dky.business.repository.repository.UsersMapper;
import com.dky.common.bean.Store;
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

    @Autowired
    private StoreMapper storeMapper;


    @Override
    public ReturnT loginUser(LoginUserParam param) {
        ReturnT result = new ReturnT<>();
        Users users = usersMapper.selectByEmail(param.getEmail());
        if(users == null){//如果用户不存在，查询store
            //return result.failureData(ResultCodeEnum.USER_LOGIN_ERROR);
            Store store = storeMapper.selectByCode(param.getEmail());
            if(store == null){
                return result.failureData(ResultCodeEnum.USER_LOGIN_ERROR);
            }
            if(!param.getPassword().equals(store.getPassword())){
                return result.failureData(ResultCodeEnum.LOGIN_PASSWORD_ERROR);
            }
            result.setData(store);
            return result.successDefault();
        }
        if (users == null || !users.getPasswordhash().equals(param.getPassword())){
            return result.failureData(ResultCodeEnum.LOGIN_PASSWORD_ERROR);
        }
        result.setData(users);
        return result.successDefault();
    }

    @Override
    public ReturnT<String> getVipName(String phone) {
        ReturnT returnT = new ReturnT();
        returnT.setData(usersMapper.getVipName(phone));
        return returnT.successDefault();
    }
}
