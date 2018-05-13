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
public class BmptApproveView extends ResultObjectBase {

    /**
     * 序号
     */
    private Long id;
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
     * 金额
     */
    private BigDecimal amount;
    /**
     * 数量
     */
    private Long qty;
    /**
     * 图片
     */
    private String imgUrl;
    /**
     * 大图片
     */
    private String bigImgUrl;

    private Integer issource;

    private String issourceText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public String getImgUrl() {
        if (this.imgUrl != null){
            this.bigImgUrl = GlobConts.IMAGE_ROOT_URL+this.imgUrl+"?random="+ new Random().nextInt(100);
            this.imgUrl =this.imgUrl.replace("img","img_sl")+"?random="+ new Random().nextInt(100);
        }
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getBigImgUrl() {
        return bigImgUrl;
    }

    public void setBigImgUrl(String bigImgUrl) {
        this.bigImgUrl = bigImgUrl;
    }

    public Integer getIssource() {
        return issource;
    }

    public void setIssource(Integer issource) {
        SourceEnum sourceEnum = SourceEnum.getByCode(issource);
        if (sourceEnum != null){
            this.issourceText = sourceEnum.getMessage();
        }
        this.issource = issource;
    }

    public String getIssourceText(){
        return this.issourceText;
    }

    public void setIssourceText(String issourceText) {
        this.issourceText = issourceText;
    }
}
