package com.dky.common.response.view;

import com.dky.common.constats.GlobConts;
import com.dky.common.enums.SourceEnum;
import com.dky.common.response.ResultObjectBase;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by hang on 2017/1/4 0004.
 * @decription 大货订单查询列表
 */
public class BmptApproveInfoView extends ResultObjectBase {

    /**
     * 机构号
     */
    private String jgNo;
    /**
     * 款号
     */
    private String productName;
    /**
     * 颜色
     */
    private String colorName;
    /**
     * 尺寸
     */
    private String sizeName;
    /**
     * 数量
     */
    private Long qty;
    /**
     * 性质
     */
    private String fair;
    /**
     * 标准价
     */
    private String pricelist;

    public String getJgNo() {
        return jgNo;
    }

    public void setJgNo(String jgNo) {
        this.jgNo = jgNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public String getFair() {
        return fair;
    }

    public void setFair(String fair) {
        this.fair = fair;
    }

    public String getPricelist() {
        return pricelist;
    }

    public void setPricelist(String pricelist) {
        this.pricelist = pricelist;
    }
}
