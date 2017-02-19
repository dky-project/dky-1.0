package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;


/**
 * Created by hang on 2017/1/10.
 */
public class ProductColorView extends ResultObjectBase {

    /**
     * 颜色ID
     */
    private Long colorId;
    /**
     * 颜色名称
     */
    private String colorName;
    /**
     * 颜色value
     */
    private String colorValue;
    /**
     * 颜色描述
     */
    private String colorDesc;

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorValue() {
        return colorValue;
    }

    public void setColorValue(String colorValue) {
        this.colorValue = colorValue;
    }

    public String getColorDesc() {
        return colorDesc;
    }

    public void setColorDesc(String colorDesc) {
        this.colorDesc = colorDesc;
    }
}
