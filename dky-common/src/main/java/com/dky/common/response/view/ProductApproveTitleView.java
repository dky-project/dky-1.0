package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;


/**
 * Created by wangpeng on 2017/1/10.
 */
public class ProductApproveTitleView extends ResultObjectBase {

    private String code;

    private String czDate;

    private String sendDate;

    private String userName;

    private String orderNo;

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
}
