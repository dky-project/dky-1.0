package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;


/**
 * Created by hang on 2017/1/10.
 */
public class ColorSizeView extends ResultObjectBase {

    /**
     * 色号
     */
    private String value1Code;
    /**
     * 颜色名称
     */
    private String value1;
    /**
     * 尺寸
     */
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue1Code() {
        return value1Code;
    }

    public void setValue1Code(String value1Code) {
        this.value1Code = value1Code;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }
}
