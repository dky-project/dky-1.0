package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;


/**
 * Created by wangpeng on 2017/1/10.
 */
public class ProductApproveTitleView extends ResultObjectBase {

    /**
     * 机构号
     */
    private String code;
    /**
     * 传真日期
     */
    private String czDate;
    /**
     * 发货日期
     */
    private String sendDate;
    /**
     * 操作者
     */
    private String userName;
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 下拉框json字符串
     */
    private String dimList;
    /**
     * 静态下拉框json字符串
     */
    private String staticDimList;
    /**
     * 编号
     */
    private String no;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCzDate() {
        return czDate;
    }

    public void setCzDate(String czDate) {
        this.czDate = czDate;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getDimList() {
        return dimList;
    }

    public void setDimList(String dimList) {
        this.dimList = dimList.replaceAll("'","\"");
    }

    public String getStaticDimList() {
        return staticDimList;
    }

    public void setStaticDimList(String staticDimList) {
        this.staticDimList = staticDimList;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
