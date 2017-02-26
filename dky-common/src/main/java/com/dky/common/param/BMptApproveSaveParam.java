package com.dky.common.param;

import com.dky.common.session.BaseParameter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by wonpera on 2017/2/26.
 */
public class BMptApproveSaveParam extends BaseParameter {


    /**
     * 机构号
     */
    @NotNull(message = "机构号jgNo不能为空")
    private Long jgNo;


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

    public Long getJgNo() {
        return jgNo;
    }

    public void setJgNo(Long jgNo) {
        this.jgNo = jgNo;
    }

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
}
