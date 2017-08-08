package com.dky.business.repository.repository;

import com.dky.common.bean.DpGroup;

@MyBatisRepository
public interface DpGroupMapper {

    DpGroup selectByGroupNo(String groupNo);

}