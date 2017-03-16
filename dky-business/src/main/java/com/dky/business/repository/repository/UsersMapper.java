package com.dky.business.repository.repository;

import com.dky.common.bean.Users;

import java.util.Map;

@MyBatisRepository
public interface UsersMapper {
    Users selectByEmail(String email);

    Map<String,String> getStoreCodeByEmail(String email);

    String getVipName(String phone);
}