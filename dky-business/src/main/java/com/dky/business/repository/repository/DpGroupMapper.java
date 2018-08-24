package com.dky.business.repository.repository;

import com.dky.common.bean.DpGroup;
import com.dky.common.param.ClGroupQueryParam;
import com.dky.common.response.view.ClGroupResultView;
import com.dky.common.response.view.ClGroupView;
import com.dky.common.response.view.DpGroupReturnView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisRepository
public interface DpGroupMapper {

    List<DpGroup> selectByGroupNo(@Param("groupNo") String groupNo,@Param("requestCount")Integer requestCount,@Param("requestOffset")Integer requestOffset);

    int count(@Param("groupNo") String groupNo);

    int countByDefault(@Param("groupNo") String groupNo,@Param("isDefault") String isDefault);

    List<ClGroupView> selectByGh(ClGroupQueryParam param);

    int clCount(ClGroupQueryParam param);

    List<String> getGroupNoList();

    List<String> getGhList();
}