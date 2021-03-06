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
public class ProductApproveView extends ResultObjectBase {

    /**
     * 序号
     */
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
     * 式样
     */
    private String mDimNew12Text;
    /**
     * 组织
     */
    private String mDimNew15Text;
    /**
     * 针型
     */
    private String mDimNew16Text;
    /**
     * 支别
     */
    private String mDimNew17Text;
    /**
     * 大
     */
    private String xwValue;
    /**
     * 长
     */
    private String ycValue;
    /**
     * 专卖店价 * 数量
     */
    private BigDecimal totalAmount;
    /**
     * 数量
     */
    private Long sum;
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

    private Integer issource;

    private String issourceText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getmDimNew12Text() {
        return mDimNew12Text;
    }

    public void setmDimNew12Text(String mDimNew12Text) {
        this.mDimNew12Text = mDimNew12Text;
    }

    public String getmDimNew15Text() {
        return mDimNew15Text;
    }

    public void setmDimNew15Text(String mDimNew15Text) {
        this.mDimNew15Text = mDimNew15Text;
    }

    public String getmDimNew16Text() {
        return mDimNew16Text;
    }

    public void setmDimNew16Text(String mDimNew16Text) {
        this.mDimNew16Text = mDimNew16Text;
    }

    public String getmDimNew17Text() {
        return mDimNew17Text;
    }

    public void setmDimNew17Text(String mDimNew17Text) {
        this.mDimNew17Text = mDimNew17Text;
    }

    public String getXwValue() {
        return xwValue;
    }

    public void setXwValue(String xwValue) {
        this.xwValue = xwValue;
    }

    public String getYcValue() {
        return ycValue;
    }

    public void setYcValue(String ycValue) {
        this.ycValue = ycValue;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public String getImgUrl() {
        if (this.imgUrl != null){
            this.bigImgUrl = GlobConts.IMAGE_ROOT_URL+this.imgUrl+"?random="+ new Random().nextInt(100);
            this.imgUrl = this.imgUrl.replace("img","img_sl")+"?random="+ new Random().nextInt(100);
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
}
