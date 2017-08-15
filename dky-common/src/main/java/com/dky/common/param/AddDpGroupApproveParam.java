package com.dky.common.param;

import com.dky.common.session.SessionParameter;

import java.math.BigDecimal;

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
    private BigDecimal xcValue;
    /**
     * 颜色名称
     */
    private String colorArr;

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

    public BigDecimal getXcValue() {
        return xcValue;
    }

    public void setXcValue(BigDecimal xcValue) {
        this.xcValue = xcValue;
    }

    public String getColorArr() {
        return colorArr;
    }

    public void setColorArr(String colorArr) {
        this.colorArr = colorArr;
    }
}
