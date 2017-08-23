package com.dky.business.repository.biz;

import com.dky.common.param.*;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.DimNewView;
import com.dky.common.response.view.ProductApproveTitleView;
import com.dky.common.response.view.ProductColorView;
import com.dky.common.response.view.PzJsonResultView;

import java.util.List;

/**
 * Created by wangpeng on 2017/1/10.
 */
public interface DimNewService {

    ReturnT<List<DimNewView>> queryByDimFlag(String dimFlag);

    ReturnT<List<DimNewView>> queryByDimText(String dimText);

    ReturnT<ProductApproveTitleView> getProductApproveTitle(ProductApproveDetailParam param);

    ReturnT<PzJsonResultView> getpzsJson(PzsJsonQueryParam param);

    ReturnT<List<ProductColorView>> getColorList(ColorQueryParam param);

    ReturnT<List<ProductColorView>> getColorDimList(ColorDimQueryParam param);

    ReturnT getSizeData(SizeDataQueryParam param);

    ReturnT getProductPrice(ProductPriceQueryParam param);
}
