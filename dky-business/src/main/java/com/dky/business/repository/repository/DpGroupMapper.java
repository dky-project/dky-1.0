package com.dky.business.repository.repository;

import com.dky.common.bean.DpGroup;
import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface DpGroupMapper {

    DpGroup selectByGroupNo(@Param("groupNo") String groupNo,@Param("requestCount")Integer requestCount,@Param("requestOffset")Integer requestOffset);

    int count(@Param("groupNo") String groupNo);

}