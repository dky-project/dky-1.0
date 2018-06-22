package com.dky.business.repository.repository;

import com.dky.common.bean.DimNew;
import com.dky.common.param.PzsJsonQueryParam;
import com.dky.common.response.view.DataAnalysisView;
import com.dky.common.response.view.DimNewView;
import com.dky.common.response.view.ProductColorView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@MyBatisRepository
public interface DimNewMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DimNew record);

    int insertSelective(DimNew record);

    DimNew selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DimNew record);

    int updateByPrimaryKey(DimNew record);

    List<DimNewView> queryByDimFlag(@Param(value = "dimFlag")String dimFlag);

    String getSendDate();

    String getDimClob();

    List<DimNewView> queryDimByDimText(@Param(value = "dimText")String dimText);

    String getpzsJson(PzsJsonQueryParam param);

    String getSizeData(@Param("pdt")String pdt,@Param("xwValue")String xwValue);

    List<ProductColorView> getColorListByDimIdAndProductId(@Param("mProductId")Long mProductId, @Param("mDimNew14Id")Long mDimNew14Id);

    String getColorRangeDefault(@Param("mProductId")Long mProductId, @Param("mDimNew14Id")Long mDimNew14Id);

    String getColorDefaultByGroupNo(@Param("groupNo")String groupNo, @Param("mProductId")Long mProductId, @Param("mDimNew14Id")Long mDimNew14Id);

    List<DataAnalysisView> getDataAnalysisList(@Param("tableName")String tableName,@Param("code")String code);

    Map<String,Object> getDataAnalysisMap(@Param("code")String code);
}