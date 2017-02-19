package com.dky.common.param;

import com.dky.common.session.BaseParameter;
import com.dky.common.session.SessionParameter;


/**
 * 定制款号查询对象
 * Created by hang 2017/2/19.
 */
public class ProductMadeQueryParam extends SessionParameter {

    /**
     * 款号名称
     */
    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
