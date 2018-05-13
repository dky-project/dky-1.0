package com.dky.common.param;

import com.dky.common.session.SessionParameter;

/**
 * Created by hang on 2017/2/26.
 */
public class AddDpGroupApproveParam extends SessionParameter {

    /**
     * 款号ID
     */
    private Long mProductId;
    /**
     * 款号名称
     */
    private String pdt;
    /**
     * 针型
     */
    private Long mDimNew16Id;
    /**
     * 品种
     */
    private Long mDimNew14Id;
    /**
     *  大（尺寸）
     */
    private String xwValue;
    /**
     *  长（尺寸）
     */
    private String ycValue;
    /**
     *  袖长
     */
    private String xcValue;
    /**
     * 颜色名称
     */
    private String colorArr;
    /**
     * 数量
     */
    private Long sum;
    /**
     * 品类
     */
    private Long mDim16Id;

    private Integer issource;

    public Long getmProductId() {
        return mProductId;
    }

    public void setmProductId(Long mProductId) {
        this.mProductId = mProductId;
    }

    public String getPdt() {
        return pdt;
    }

    public void setPdt(String pdt) {
        this.pdt = pdt;
    }

    public Long getmDimNew14Id() {
        return mDimNew14Id;
    }

    public void setmDimNew14Id(Long mDimNew14Id) {
        this.mDimNew14Id = mDimNew14Id;
    }

    public Long getmDimNew16Id() {
        return mDimNew16Id;
    }

    public void setmDimNew16Id(Long mDimNew16Id) {
        this.mDimNew16Id = mDimNew16Id;
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

    public String getXcValue() {
        return xcValue;
    }

    public void setXcValue(String xcValue) {
        this.xcValue = xcValue;
    }

    public String getColorArr() {
        return colorArr;
    }

    public void setColorArr(String colorArr) {
        this.colorArr = colorArr;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public Long getmDim16Id() {
        return mDim16Id;
    }

    public void setmDim16Id(Long mDim16Id) {
        this.mDim16Id = mDim16Id;
    }

    public Integer getIssource() {
        return issource;
    }

    public void setIssource(Integer issource) {
        this.issource = issource;
    }
}
