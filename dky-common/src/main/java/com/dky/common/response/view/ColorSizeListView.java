package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;

import java.util.List;


/**
 * Created by hang on 2017/1/10.
 */
public class ColorSizeListView extends ResultObjectBase {

    /**
     * 颜色列表
     */
    private List<ColorSizeView> colorList;
    /**
     * 尺寸列表
     */
    private List<ColorSizeView> sizeList;

    private Long mProductId;

    public List<ColorSizeView> getColorList() {
        return colorList;
    }

    public void setColorList(List<ColorSizeView> colorList) {
        this.colorList = colorList;
    }

    public List<ColorSizeView> getSizeList() {
        return sizeList;
    }

    public void setSizeList(List<ColorSizeView> sizeList) {
        this.sizeList = sizeList;
    }

    public Long getmProductId() {
        return mProductId;
    }

    public void setmProductId(Long mProductId) {
        this.mProductId = mProductId;
    }
}
