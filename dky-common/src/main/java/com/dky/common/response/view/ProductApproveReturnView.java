package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;

/**
 * Created by hang on 2017/5/15 0004.
 * @decription 下单保存返回字段
 */
public class ProductApproveReturnView extends ResultObjectBase {

    /**
     * 订单ID
     */
    private Long productApproveId;
    /**
     * 机构号
     */
    private String jgNo;
    /**
     * 交期
     */
    private String jqDate;
    /**
     * 名
     */
    private String userName;
    /**
     * 性别
     */
    private String sexName;
    /**
     * 颜色
     */
    private String colorName;
    /**
     * 大
     */
    private String xwValue;
    /**
     * 长
     */
    private String ycValue;
    /**
     * 肩
     */
    private String jValue;
    /**
     * 袖
     */
    private String xValue;
    /**
     * 下边
     */
    private String xbValue;
    /**
     * 袖口
     */
    private String xkValue;
    /**
     * 领
     */
    private String lingValue;
    /**
     * 式样
     */
    private String syValue;
    /**
     * 配套
     */
    private String ptValue;
    /**
     * 附件
     */
    private String fjValue;
    /**
     * 袖型
     */
    private String xxValue;
    /**
     * 袋
     */
    private String dValue;
    /**
     * 后道
     */
    private String hdValue;
    /**
     * 净胸围
     */
    private String jxwValue;
    /**
     * 实际袖长
     */
    private String sjxcValue;
    /**
     * 备注
     */
    private String bzValue;
    /**
     * 分隔行（单面，开衫，16S.....）
     */
    private String content;
    /**
     * 订单预览999
     */
    private String no;

    public ProductApproveReturnView(String returnMsg){
        String[] strSp = returnMsg.split("@!");
        this.jgNo = strSp[0];
        this.userName = strSp[1];
        this.jqDate = strSp[2];
        this.colorName = strSp[3];
        this.xwValue = strSp[4];
        this.ycValue = strSp[5];
        this.jValue = strSp[6];
        this.xValue = strSp[7];
        this.xbValue = strSp[8];
        this.xkValue = strSp[9];
        this.lingValue = strSp[10];
        this.syValue = strSp[11];
        this.ptValue = strSp[12];
        this.fjValue = strSp[13];
        this.xxValue = strSp[15];
        this.dValue = strSp[16];
        this.hdValue = strSp[17];
        this.jxwValue = strSp[18];
        this.sjxcValue = strSp[19];
        this.bzValue = strSp[21];
        this.content = strSp[22];
        this.no = strSp[23];
        this.sexName = strSp[24];
    }

    public Long getProductApproveId() {
        return productApproveId;
    }

    public void setProductApproveId(Long productApproveId) {
        this.productApproveId = productApproveId;
    }

    public String getJgNo() {
        return jgNo;
    }

    public void setJgNo(String jgNo) {
        this.jgNo = jgNo;
    }

    public String getJqDate() {
        return jqDate;
    }

    public void setJqDate(String jqDate) {
        this.jqDate = jqDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
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

    public String getjValue() {
        return jValue;
    }

    public void setjValue(String jValue) {
        this.jValue = jValue;
    }

    public String getxValue() {
        return xValue;
    }

    public void setxValue(String xValue) {
        this.xValue = xValue;
    }

    public String getXbValue() {
        return xbValue;
    }

    public void setXbValue(String xbValue) {
        this.xbValue = xbValue;
    }

    public String getXkValue() {
        return xkValue;
    }

    public void setXkValue(String xkValue) {
        this.xkValue = xkValue;
    }

    public String getLingValue() {
        return lingValue;
    }

    public void setLingValue(String lingValue) {
        this.lingValue = lingValue;
    }

    public String getSyValue() {
        return syValue;
    }

    public void setSyValue(String syValue) {
        this.syValue = syValue;
    }

    public String getPtValue() {
        return ptValue;
    }

    public void setPtValue(String ptValue) {
        this.ptValue = ptValue;
    }

    public String getFjValue() {
        return fjValue;
    }

    public void setFjValue(String fjValue) {
        this.fjValue = fjValue;
    }

    public String getXxValue() {
        return xxValue;
    }

    public void setXxValue(String xxValue) {
        this.xxValue = xxValue;
    }

    public String getdValue() {
        return dValue;
    }

    public void setdValue(String dValue) {
        this.dValue = dValue;
    }

    public String getHdValue() {
        return hdValue;
    }

    public void setHdValue(String hdValue) {
        this.hdValue = hdValue;
    }

    public String getJxwValue() {
        return jxwValue;
    }

    public void setJxwValue(String jxwValue) {
        this.jxwValue = jxwValue;
    }

    public String getSjxcValue() {
        return sjxcValue;
    }

    public void setSjxcValue(String sjxcValue) {
        this.sjxcValue = sjxcValue;
    }

    public String getBzValue() {
        return bzValue;
    }

    public void setBzValue(String bzValue) {
        this.bzValue = bzValue;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
