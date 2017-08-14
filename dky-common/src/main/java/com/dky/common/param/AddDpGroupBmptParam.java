package com.dky.common.param;

import com.dky.common.session.SessionParameter;

import javax.validation.constraints.NotNull;

/**
 * Created by hang on 2017/2/26.
 */
public class AddDpGroupBmptParam extends SessionParameter {

    /**
     * 款号ID
     */
    private Long mProductId;
    /**
     * 款号名称
     */
    private String pdt;
    /**
     * 尺寸
     */
    @NotNull(message = "尺寸sizeId不能为空")
    private Long sizeId;

    /**
     * 颜色
     */
    @NotNull(message = "颜色colorId不能为空")
    private Long colorId;

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

    public Long getSizeId() {
        return sizeId;
    }

    public void setSizeId(Long sizeId) {
        this.sizeId = sizeId;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }
}
