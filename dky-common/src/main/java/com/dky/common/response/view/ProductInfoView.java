package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;

/**
 * Created by hang on 2017/1/4 0004.
 * @decription 样衣详情
 */
public class ProductInfoView extends ResultObjectBase {

    /**
     * 款号
     */
    private String name;
    /**
     * 大类
     */
    private String mDimNew11Text;
    /**
     * 领子
     */
    private String mDimNew13Text;
    /**
     * 温馨提示
     */
    private String description3;
    /**
     * 设计说明
     */
    private String description5;
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
    /**
     * 所属类别
     */
    private String mptbelongtypeText;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getmDimNew13Text() {
        return mDimNew13Text;
    }

    public void setmDimNew13Text(String mDimNew13Text) {
        this.mDimNew13Text = mDimNew13Text;
    }

    public String getmDimNew11Text() {
        return mDimNew11Text;
    }

    public void setmDimNew11Text(String mDimNew11Text) {
        this.mDimNew11Text = mDimNew11Text;
    }

    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public String getDescription5() {
        return description5;
    }

    public void setDescription5(String description5) {
        this.description5 = description5;
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

    public String getMptbelongtypeText() {
        return mptbelongtypeText;
    }

    public void setMptbelongtypeText(String mptbelongtypeText) {
        this.mptbelongtypeText = mptbelongtypeText;
    }
}
