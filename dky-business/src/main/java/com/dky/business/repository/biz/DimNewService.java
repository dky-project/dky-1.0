package com.dky.business.repository.biz;

import com.dky.common.param.ProductApproveDetailParam;
import com.dky.common.param.PzsJsonQueryParam;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.DimNewView;
import com.dky.common.response.view.ProductApproveTitleView;

import java.util.List;

/**
 * Created by wangpeng on 2017/1/10.
 */
public interface DimNewService {

    ReturnT<List<DimNewView>> queryByDimFlag(String dimFlag);

    ReturnT<List<DimNewView>> queryByDimText(String dimText);

    ReturnT<ProductApproveTitleView> getProductApproveTitle(ProductApproveDetailParam param);

    String getpzsJson(PzsJsonQueryParam param);
}
