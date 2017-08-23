package com.dky.common.param;

import com.dky.common.session.SessionParameter;

import javax.validation.constraints.NotNull;

/**
 * Created by hang on 2017/2/26.
 */
public class ProductPriceQueryParam extends SessionParameter {

    /**
     * 款号名称
     */
    private String pdt;
    /**
     * 款号ID
     */
    private Long pdtId;
    /**
     * 商品所属类别
     */
    @NotNull(message = "mptbelongtype can not be null!")
    private String mptbelongtype;
    /**
     * 品种默认值
     */
    private Long mDimNew14Id;
    /**
     * 针型默认值
     */
    private Long mDimNew16Id;
    /**
     * 尺寸：大 默认值
     */
    private String xwValue;
    /**
     * 袖长
     */
    private String xcValue;
    /**
     * 尺寸：长
     */
    private String ycValue;

    public String getPdt() {
        return pdt;
    }

    public void setPdt(String pdt) {
        this.pdt = pdt;
    }

    public Long getPdtId() {
        return pdtId;
    }

    public String getMptbelongtype() {
        return mptbelongtype;
    }

    public void setMptbelongtype(String mptbelongtype) {
        this.mptbelongtype = mptbelongtype;
    }

    public void setPdtId(Long pdtId) {
        this.pdtId = pdtId;
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

    public String getXcValue() {
        return xcValue;
    }

    public void setXcValue(String xcValue) {
        this.xcValue = xcValue;
    }

    public String getYcValue() {
        return ycValue;
    }

    public void setYcValue(String ycValue) {
        this.ycValue = ycValue;
    }
}
