package com.dky.business.repository.repository;

import com.dky.common.bean.Users;

@MyBatisRepository
public interface UsersMapper {
    Users selectByEmail(String email);
}