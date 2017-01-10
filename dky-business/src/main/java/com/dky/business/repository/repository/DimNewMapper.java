package com.dky.business.repository.repository;

import com.dky.common.bean.DimNew;
import com.dky.common.response.view.DimNewView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisRepository
public interface DimNewMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DimNew record);

    int insertSelective(DimNew record);

    DimNew selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DimNew record);

    int updateByPrimaryKey(DimNew record);

    List<DimNewView> queryByDimFlag(@Param(value = "dimFlag")String dimFlag);
}