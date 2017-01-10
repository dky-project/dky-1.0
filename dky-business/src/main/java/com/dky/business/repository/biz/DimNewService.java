package com.dky.business.repository.biz;

import com.dky.common.response.ReturnT;
import com.dky.common.response.view.DimNewView;

import java.util.List;

/**
 * Created by wangpeng on 2017/1/10.
 */
public interface DimNewService {

    ReturnT<List<DimNewView>> queryByDimFlag(String dimFlag);
}
