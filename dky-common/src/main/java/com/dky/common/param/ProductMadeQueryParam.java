package com.dky.common.param;

import com.dky.common.session.BaseParameter;
import com.dky.common.session.SessionParameter;

import javax.validation.constraints.NotNull;


/**
 * 定制款号查询对象
 * Created by hang 2017/2/19.
 */
public class ProductMadeQueryParam extends SessionParameter {

    /**
     * 款号名称
     */
    @NotNull(message = "款号不能为空！")
    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
