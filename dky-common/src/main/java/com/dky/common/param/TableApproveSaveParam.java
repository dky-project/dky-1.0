package com.dky.common.param;

import com.dky.common.session.SessionParameter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by hang on 2017/2/26.
 */
public class TableApproveSaveParam extends SessionParameter {


    /**
     * 机构号
     */
    //@NotBlank(message = "客户不能为空")
    private String jgNo;

    /**
     * 款号ID
     */
    @NotNull(message = "款号不能为空")
    private Long pdtId;

    /**
     * 款号名称
     */
    @NotBlank(message = "款号不能为空")
    private String productName;

    private Integer issource;

    private String itemDatas;

    public String getJgNo() {
        return jgNo;
    }

    public void setJgNo(String jgNo) {
        this.jgNo = jgNo;
    }

    public Long getPdtId() {
        return pdtId;
    }

    public void setPdtId(Long pdtId) {
        this.pdtId = pdtId;
    }

    public String getItemDatas() {
        return itemDatas;
    }

    public void setItemDatas(String itemDatas) {
        this.itemDatas = itemDatas;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getIssource() {
        return issource;
    }

    public void setIssource(Integer issource) {
        this.issource = issource;
    }
}
