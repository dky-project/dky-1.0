package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;

import java.util.List;
import java.util.Random;

/**
 * Created by hang on 2017/1/4 0004.
 * @decription 搭配
 */
public class DpGroupView extends ResultObjectBase {

    /**
     * 款号ID
     */
    private Long mProductId;
    /**
     * 款号名称
     */
    private String productName;
    /**
     * 商品所属类别
     */
    private String mptbelongtype;
    /**
     * 尺寸：大
     * 请选择胸围
     */
    private String xwValue;
    /**
     * 尺寸：大
     * 胸围下拉框
     */
    private String xwArray;
    /**
     * 尺寸：长
     */
    private String ycValue;
    /**
     * 图片
     */
    private String imgUrl;
    /**
     * 品种
     */
    private Long mDimNew14Id;
    /**
     * 颜色列表
     */
    private List<ProductColorView> colorViewList;
    /**
     * 尺寸列表
     */
    private List<ProductSizeView> sizeViewList;

    public String getImgUrl() {
        if (this.imgUrl != null){
            this.imgUrl =this.imgUrl+"?random="+ new Random().nextInt(100);
        }
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getmProductId() {
        return mProductId;
    }

    public void setmProductId(Long mProductId) {
        this.mProductId = mProductId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMptbelongtype() {
        return mptbelongtype;
    }

    public void setMptbelongtype(String mptbelongtype) {
        this.mptbelongtype = mptbelongtype;
    }

    public String getXwValue() {
        return xwValue;
    }

    public void setXwValue(String xwValue) {
        this.xwValue = xwValue;
    }

    public String getYcValue() {
        return ycValue;
    }

    public void setYcValue(String ycValue) {
        this.ycValue = ycValue;
    }

    public List<ProductColorView> getColorViewList() {
        return colorViewList;
    }

    public void setColorViewList(List<ProductColorView> colorViewList) {
        this.colorViewList = colorViewList;
    }

    public List<ProductSizeView> getSizeViewList() {
        return sizeViewList;
    }

    public void setSizeViewList(List<ProductSizeView> sizeViewList) {
        this.sizeViewList = sizeViewList;
    }

    public Long getmDimNew14Id() {
        return mDimNew14Id;
    }

    public void setmDimNew14Id(Long mDimNew14Id) {
        this.mDimNew14Id = mDimNew14Id;
    }

    public String getXwArray() {
        return xwArray;
    }

    public void setXwArray(String xwArray) {
        this.xwArray = xwArray;
    }
}
