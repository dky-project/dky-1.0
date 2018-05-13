package com.dky.common.param;

import com.dky.common.session.SessionParameter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by wonpera on 2017/2/26.
 */
public class BMptApproveSaveParam extends SessionParameter {

    /**
     * 款号名称
     */
    @NotEmpty(message = "款号名称productName不能为空")
    private String productName;

    /**
     * 尺寸
     */
    @NotNull(message = "尺寸sizeId不能为空")
    private Long sizeId;

    /**
     * 颜色
     */
    @NotNull(message = "颜色colorId不能为空")
    private Long colorId;

    /**
     * 颜色
     */
    @NotNull(message = "款号不能为空")
    private Long pdtId;

    private Long qty;

    private Integer issource;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getSizeId() {
        return sizeId;
    }

    public void setSizeId(Long sizeId) {
        this.sizeId = sizeId;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public Long getPdtId() {
        return pdtId;
    }

    public void setPdtId(Long pdtId) {
        this.pdtId = pdtId;
    }

    public Integer getIssource() {
        return issource;
    }

    public void setIssource(Integer issource) {
        this.issource = issource;
    }
}
