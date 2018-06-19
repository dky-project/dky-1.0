package com.dky.common.response.view;

import com.dky.common.constats.GlobConts;
import com.dky.common.enums.SourceEnum;
import com.dky.common.response.ResultObjectBase;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by hang on 2017/1/4 0004.
 * @decription 订单查询列表
 */
public class ProductApproveTotalView extends ResultObjectBase {

    private Long id;
    /**
     * 编号
     */
    private Long no1;
    /**
     * 来源样衣
     */
    private String pdt;
    /**
     * 客户
     */
    private String customer;
    /**
     * 传真日期
     */
    private String czDate;
    /**
     * 大
     */
    private String xwValue;
    /**
     * 长
     */
    private String sizeName;
    /**
     * 专卖店价 * 数量
     */
    private BigDecimal totalAmount;
    /**
     * 数量
     */
    private Long qty;
    /**
     * 小图片
     */
    private String imgUrl;
    /**
     * 大图片
     */
    private String bigImgUrl;
    /**
     * 主颜色
     */
    private String colorName;
    /**(
     * 来源
     */
    private Integer issource;
    /**
     * 审核状态
     */
    private Integer isapprove;

    private String issourceText;

    public Long getNo1() {
        return no1;
    }

    public void setNo1(Long no1) {
        this.no1 = no1;
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

    public String getCzDate() {
        return czDate;
    }

    public void setCzDate(String czDate) {
        this.czDate = czDate;
    }

    public String getXwValue() {
        return xwValue;
    }

    public void setXwValue(String xwValue) {
        this.xwValue = xwValue;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public String getImgUrl() {

        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        if (imgUrl != null){
            this.bigImgUrl = GlobConts.IMAGE_ROOT_URL+imgUrl+"?random="+ new Random().nextInt(100);
            this.imgUrl = this.bigImgUrl.replace("img","img_sl")+"?random="+ new Random().nextInt(100);
        }
    }

    public String getBigImgUrl() {
        return bigImgUrl;
    }

    public void setBigImgUrl(String bigImgUrl) {
        this.bigImgUrl = bigImgUrl;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
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

    public Integer getIsapprove() {
        return isapprove;
    }

    public void setIsapprove(Integer isapprove) {
        this.isapprove = isapprove;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
