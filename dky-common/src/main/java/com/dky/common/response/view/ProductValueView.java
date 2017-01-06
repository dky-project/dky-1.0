package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;

/**
 * Created by hang on 2017/1/4 0004.
 * @decription 胸围、衣长、肩宽、袖长
 */
public class ProductValueView extends ResultObjectBase {

    /**
     * 胸围
     */
    private String xwValue;
    /**
     * 衣长
     */
    private String ycValue;
    /**
     * 肩宽
     */
    private String jkValue;
    /**
     * 袖长
     */
    private String xcValue;

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

    public String getJkValue() {
        return jkValue;
    }

    public void setJkValue(String jkValue) {
        this.jkValue = jkValue;
    }

    public String getXcValue() {
        return xcValue;
    }

    public void setXcValue(String xcValue) {
        this.xcValue = xcValue;
    }
}
