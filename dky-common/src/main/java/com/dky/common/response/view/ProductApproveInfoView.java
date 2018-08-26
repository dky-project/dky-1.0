package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;

/**
 * Created by hang on 2017/1/4 0004.
 * @decription 订单详情列表
 */
public class ProductApproveInfoView extends ResultObjectBase {

    /**
     * 编号
     */
    private Long no1;
    /**
     * 机构
     */
    private String jgNo;
    /**
     * 交期
     */
    private String fhDate;
    /**
     * 品名
     */
    private String productValue;
    /**
     * 款号
     */
    private String pdt;
    /**
     * 客户
     */
    private String customer;
    /**
     * 颜色
     */
    private String colorArr;
    /**
     * 胸围
     */
    private String xwValue;
    /**
     * 衣长
     */
    private String ycValue;
    /**
     * 肩
     */
    private String jkValue;
    /**
     * 袖长
     */
    private String xcValue;
    /**
     * 下边
     */
    private String mDimNew10Text;
    /**
     * 袖口
     */
    private String mDimNew32Text;
    /**
     * 针型
     */
    private String mDimNew16Text;
    /**
     * 肩型
     */
    private String mDimNew22Text;
    /**
     * 性别
     */
    private String mDimNew13Text;
    /**
     * 花型
     */
    private String huax;
    /**
     * 领
     */
    private String lingValue;
    /**
     * 式样
     */
    private String mDimNew12Text;
    /**
     * 附件
     */
    private String fuj;
    /**
     * 袖型
     */
    private String xxTxt;
    /**
     * 袋
     */
    private String dTxt;
    /**
     * 后道
     */
    private String hdTxt;
    /**
     * 领txt
     */
    private String lTxt;
    /**
     * 袖边
     */
    private String xTxt;
    /**
     * 袖口txt
     */
    private String xkTxt;
    /**
     * 下边txt
     */
    private String xbTxt;
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
    private String remark;
    /**
     * 肩型ID
     */
    private Long mDimNew22Id;
    /**
     * 式样ID
     */
    private Long mDimNew12Id;
    /**
     * 工艺袖长
     */
    private String hzxcValue;

    /**
     * 类型样式
     */
    private int viewType;

    public Long getNo1() {
        return no1;
    }

    public void setNo1(Long no1) {
        this.no1 = no1;
    }

    public String getJgNo() {
        return jgNo;
    }

    public void setJgNo(String jgNo) {
        this.jgNo = jgNo;
    }

    public String getFhDate() {
        return fhDate;
    }

    public void setFhDate(String fhDate) {
        this.fhDate = fhDate;
    }

    public String getProductValue() {
        return productValue;
    }

    public void setProductValue(String productValue) {
        this.productValue = productValue;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getColorArr() {
        return colorArr;
    }

    public void setColorArr(String colorArr) {
        this.colorArr = colorArr;
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

    public String getmDimNew10Text() {
        return mDimNew10Text;
    }

    public void setmDimNew10Text(String mDimNew10Text) {
        this.mDimNew10Text = mDimNew10Text;
    }

    public String getmDimNew32Text() {
        return mDimNew32Text;
    }

    public void setmDimNew32Text(String mDimNew32Text) {
        this.mDimNew32Text = mDimNew32Text;
    }

    public String getLingValue() {
        return lingValue;
    }

    public void setLingValue(String lingValue) {
        this.lingValue = lingValue;
    }

    public String getmDimNew12Text() {
        return mDimNew12Text;
    }

    public void setmDimNew12Text(String mDimNew12Text) {
        this.mDimNew12Text = mDimNew12Text;
    }

    public String getFuj() {
        return fuj;
    }

    public void setFuj(String fuj) {
        this.fuj = fuj;
    }

    public String getXxTxt() {
        return xxTxt;
    }

    public void setXxTxt(String xxTxt) {
        this.xxTxt = xxTxt;
    }

    public String getdTxt() {
        return dTxt;
    }

    public void setdTxt(String dTxt) {
        this.dTxt = dTxt;
    }

    public String getHdTxt() {
        return hdTxt;
    }

    public void setHdTxt(String hdTxt) {
        this.hdTxt = hdTxt;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPdt() {
        return pdt;
    }

    public void setPdt(String pdt) {
        this.pdt = pdt;
    }

    public String getmDimNew16Text() {
        return mDimNew16Text;
    }

    public void setmDimNew16Text(String mDimNew16Text) {
        this.mDimNew16Text = mDimNew16Text;
    }

    public String getmDimNew22Text() {
        return mDimNew22Text;
    }

    public void setmDimNew22Text(String mDimNew22Text) {
        this.mDimNew22Text = mDimNew22Text;
    }

    public String getHuax() {
        return huax;
    }

    public void setHuax(String huax) {
        this.huax = huax;
    }

    public String getlTxt() {
        return lTxt;
    }

    public void setlTxt(String lTxt) {
        this.lTxt = lTxt;
    }

    public Long getmDimNew22Id() {
        return mDimNew22Id;
    }

    public void setmDimNew22Id(Long mDimNew22Id) {
        this.mDimNew22Id = mDimNew22Id;
    }

    public String getmDimNew13Text() {
        return mDimNew13Text;
    }

    public void setmDimNew13Text(String mDimNew13Text) {
        this.mDimNew13Text = mDimNew13Text;
    }

    public Long getmDimNew12Id() {
        return mDimNew12Id;
    }

    public void setmDimNew12Id(Long mDimNew12Id) {
        this.mDimNew12Id = mDimNew12Id;
    }

    public String getxTxt() {
        return xTxt;
    }

    public void setxTxt(String xTxt) {
        this.xTxt = xTxt;
    }

    public String getHzxcValue() {
        return hzxcValue;
    }

    public void setHzxcValue(String hzxcValue) {
        this.hzxcValue = hzxcValue;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getXkTxt() {
        return xkTxt;
    }

    public void setXkTxt(String xkTxt) {
        this.xkTxt = xkTxt;
    }

    public String getXbTxt() {
        return xbTxt;
    }

    public void setXbTxt(String xbTxt) {
        this.xbTxt = xbTxt;
    }
}
