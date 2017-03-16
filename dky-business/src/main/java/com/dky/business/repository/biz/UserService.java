package com.dky.business.repository.biz;

import com.dky.common.param.LoginUserParam;
import com.dky.common.response.ReturnT;

/**
 * Created by hang on 2017/1/4 0004.
 */
public interface UserService {

    ReturnT loginUser(LoginUserParam param);

    ReturnT<String> getVipName(String phone);
}
