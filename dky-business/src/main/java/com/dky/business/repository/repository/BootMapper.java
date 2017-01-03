package com.dky.business.repository.repository;

import com.dky.common.bean.Boot;

@MyBatisRepository
public interface BootMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Boot record);

    int insertSelective(Boot record);

    Boot selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Boot record);

    int updateByPrimaryKey(Boot record);
}