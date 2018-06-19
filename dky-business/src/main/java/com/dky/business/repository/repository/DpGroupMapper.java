package com.dky.business.repository.repository;

import com.dky.common.bean.DpGroup;
import com.dky.common.param.ClGroupQueryParam;
import com.dky.common.response.view.ClGroupView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisRepository
public interface DpGroupMapper {

    List<DpGroup> selectByGroupNo(@Param("groupNo") String groupNo,@Param("requestCount")Integer requestCount,@Param("requestOffset")Integer requestOffset);

    int count(@Param("groupNo") String groupNo);

    List<ClGroupView> selectByGh(ClGroupQueryParam param);

    int clCount(ClGroupQueryParam param);

}