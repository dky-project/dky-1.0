package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;

/**
 * Created by hang on 2017/1/4 0004.
 * @decription 定制款零售基础价
 */
public class PdtPriceView extends ResultObjectBase {

    /**
     * 性別
     */
    private String mDimNew13Text;
    /**
     * 品种
     */
    private String mDimNew14Text;
    /**
     * 针型
     */
    private String mDimNew16Text;
    /**
     * 专卖店价
     */
    private float price;
    /**
     * 加价率
     */
    private float floatRate;
    /**
     * 商场价
     */
    private float price1;

    public String getmDimNew13Text() {
        return mDimNew13Text;
    }

    public void setmDimNew13Text(String mDimNew13Text) {
        this.mDimNew13Text = mDimNew13Text;
    }

    public String getmDimNew14Text() {
        return mDimNew14Text;
    }

    public void setmDimNew14Text(String mDimNew14Text) {
        this.mDimNew14Text = mDimNew14Text;
    }

    public String getmDimNew16Text() {
        return mDimNew16Text;
    }

    public void setmDimNew16Text(String mDimNew16Text) {
        this.mDimNew16Text = mDimNew16Text;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getFloatRate() {
        return floatRate;
    }

    public void setFloatRate(float floatRate) {
        this.floatRate = floatRate;
    }

    public float getPrice1() {
        return price1;
    }

    public void setPrice1(float price1) {
        this.price1 = price1;
    }
}
