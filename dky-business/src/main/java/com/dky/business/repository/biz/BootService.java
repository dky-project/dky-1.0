package com.dky.business.repository.biz;

import com.dky.common.bean.Boot;

/**
 * Created by wonpera on 2017/1/3.
 */
public interface BootService {


    int insert(Boot record);

    int insertSelective(Boot record);

    Boot selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Boot record);

    int updateByPrimaryKey(Boot record);
}
