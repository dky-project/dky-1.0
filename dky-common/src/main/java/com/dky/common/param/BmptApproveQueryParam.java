package com.dky.common.param;

import com.dky.common.session.WebPageParameter;

/**
 * Created by hang on 2017/1/6.
 */
public class BmptApproveQueryParam extends WebPageParameter {


    /**
     * 创建日期
     */
    private String createTime;
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

    private String jgno;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public String getJgno() {
        return jgno;
    }

    public void setJgno(String jgno) {
        this.jgno = jgno;
    }
}
