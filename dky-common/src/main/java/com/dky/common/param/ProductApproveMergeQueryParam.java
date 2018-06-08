package com.dky.common.param;

import com.dky.common.session.WebPageParameter;

/**
 * Created by wonpera on 2017/1/6.
 */
public class ProductApproveMergeQueryParam extends WebPageParameter {


    /**
     * 传真日期
     */
    private String jgno;

    /**
     * 传真日期
     */
    private String czDate;
    /**
     * 来源样衣
     */
    private String pdt;
    /**
     * 客户
     */
    private String customer;
    /**
     * 审核状态
     */
    private Integer isapprove;
    /**
     * 颜色
     */
    private String colorName;

    private String size;
    /**
     * 来源
     */
    private Integer issource;

    public String getCzDate() {
        return czDate;
    }

    public void setCzDate(String czDate) {
        this.czDate = czDate;
    }

    public String getPdt() {
        return pdt;
    }

    public void setPdt(String pdt) {
        this.pdt = pdt;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Integer getIsapprove() {
        return isapprove;
    }

    public void setIsapprove(Integer isapprove) {
        this.isapprove = isapprove;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getJgno() {
        return jgno;
    }

    public void setJgno(String jgno) {
        this.jgno = jgno;
    }

    public Integer getIssource() {
        return issource;
    }

    public void setIssource(Integer issource) {
        this.issource = issource;
    }
}
