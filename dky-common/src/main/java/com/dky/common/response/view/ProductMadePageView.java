package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;

import java.util.List;


/**
 * Created by hang on 2017/1/10.
 */
public class ProductMadePageView extends ResultObjectBase {

    private ProductMadeInfoView productMadeInfoView;

    private List<ProductColorView> colorViewList;

    private List<ProductColorView> colorRangeViewList;

    private List<ProductSizeView> sizeViewList;

    private ProductCusmptcateView productCusmptcateView;

    public ProductMadeInfoView getProductMadeInfoView() {
        return productMadeInfoView;
    }

    public void setProductMadeInfoView(ProductMadeInfoView productMadeInfoView) {
        this.productMadeInfoView = productMadeInfoView;
    }

    public List<ProductColorView> getColorViewList() {
        return colorViewList;
    }

    public void setColorViewList(List<ProductColorView> colorViewList) {
        this.colorViewList = colorViewList;
    }

    public List<ProductColorView> getColorRangeViewList() {
        return colorRangeViewList;
    }

    public void setColorRangeViewList(List<ProductColorView> colorRangeViewList) {
        this.colorRangeViewList = colorRangeViewList;
    }

    public List<ProductSizeView> getSizeViewList() {
        return sizeViewList;
    }

    public void setSizeViewList(List<ProductSizeView> sizeViewList) {
        this.sizeViewList = sizeViewList;
    }

    public ProductCusmptcateView getProductCusmptcateView() {
        return productCusmptcateView;
    }

    public void setProductCusmptcateView(ProductCusmptcateView productCusmptcateView) {
        this.productCusmptcateView = productCusmptcateView;
    }
}
