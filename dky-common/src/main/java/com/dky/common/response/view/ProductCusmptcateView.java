package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;


/**
 * Created by hang on 2017/1/10.
 *
 * @decription 所有结尾是Show的字段都是以逗号分隔的字符串，进行截取返回给客户端的都是字符串数组
 */
public class ProductCusmptcateView extends ResultObjectBase {
    /**
     * 挂件袖肥下拉框
     */
    private String gjxfShow;
    /**
     * 下边下拉框
     */
    private String xbShow;
    /**
     * 袖口下拉框
     */
    private String xkShow;
    /**
     * 门襟组织下拉框
     */
    private String mjzzShow;
    /**
     * 领边下拉框
     */
    private String lbShow;
    /**
     * 胸围下拉框（json字符串，键为value）
     */
    private String xwArray;
    /**
     * 领型下拉框
     */
    private String lxShow;
    /**
     * 肩型下拉框
     */
    private String jxShow;
    /**
     * 袖型下拉框
     */
    private String xxShow;
    /**
     * 式样下拉框
     */
    private String syShow;
    /**
     * 是否配置衣长
     * 值为“Y”时，请选择收腰下拉框下面的长[文本框]不可编辑
     */
    private String isYcAffix;
    /**
     * 是否配置肩宽
     * 值为“Y”时，肩宽：[文本框]cm不可编辑
     */
    private String isJkAffix;
    /**
     * 是否配置袖长
     * 值为“Y”时，袖长：[文本框]cm不可编辑
     */
    private String isXcAffix;
    /**
     * 是否配置衣长
     * 值为“Y”时，花型对应的勾选框都不可编辑
     */
    private String isHxAffix;

    public String getGjxfShow() {
        return gjxfShow;
    }

    public void setGjxfShow(String gjxfShow) {
        this.gjxfShow = gjxfShow.replaceAll("'","\"");
    }

    public String getXbShow() {
        return xbShow;
    }

    public void setXbShow(String xbShow) {
        this.xbShow = xbShow.replaceAll("'","\"");
    }

    public String getXkShow() {
        return xkShow;
    }

    public void setXkShow(String xkShow) {
        this.xkShow = xkShow.replaceAll("'","\"");
    }

    public String getMjzzShow() {
        return mjzzShow;
    }

    public void setMjzzShow(String mjzzShow) {
        this.mjzzShow = mjzzShow.replaceAll("'","\"");
    }

    public String getLbShow() {
        return lbShow;
    }

    public void setLbShow(String lbShow) {
        this.lbShow = lbShow.replaceAll("'","\"");
    }

    public String getXwArray() {
        return xwArray;
    }

    public void setXwArray(String xwArray) {
        this.xwArray = xwArray.replaceAll("'","\"");
    }

    public String getLxShow() {
        return lxShow;
    }

    public void setLxShow(String lxShow) {
        this.lxShow = lxShow.replaceAll("'","\"");
    }

    public String getJxShow() {
        return jxShow;
    }

    public void setJxShow(String jxShow) {
        this.jxShow = jxShow.replaceAll("'","\"");
    }

    public String getXxShow() {
        return xxShow;
    }

    public void setXxShow(String xxShow) {
        this.xxShow = xxShow.replaceAll("'","\"");
    }

    public String getSyShow() {
        return syShow;
    }

    public void setSyShow(String syShow) {
        this.syShow = syShow.replaceAll("'","\"");
    }

    public String getIsYcAffix() {
        return isYcAffix;
    }

    public void setIsYcAffix(String isYcAffix) {
        this.isYcAffix = isYcAffix;
    }

    public String getIsJkAffix() {
        return isJkAffix;
    }

    public void setIsJkAffix(String isJkAffix) {
        this.isJkAffix = isJkAffix;
    }

    public String getIsXcAffix() {
        return isXcAffix;
    }

    public void setIsXcAffix(String isXcAffix) {
        this.isXcAffix = isXcAffix;
    }

    public String getIsHxAffix() {
        return isHxAffix;
    }

    public void setIsHxAffix(String isHxAffix) {
        this.isHxAffix = isHxAffix;
    }
}
