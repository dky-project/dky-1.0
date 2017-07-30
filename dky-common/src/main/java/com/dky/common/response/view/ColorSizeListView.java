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
    private List<String> colorList;
    /**
     * 尺寸列表
     */
    private List<String> sizeList;

    public List<String> getSizeList() {
        return sizeList;
    }

    public void setSizeList(List<String> sizeList) {
        this.sizeList = sizeList;
    }

    public List<String> getColorList() {
        return colorList;
    }

    public void setColorList(List<String> colorList) {
        this.colorList = colorList;
    }
}
