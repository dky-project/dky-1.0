package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;

import java.util.Random;

/**
 * Created by hang on 2017/1/4 0004.
 * @decription 陈列
 */
public class ClGroupResultView extends ResultObjectBase {

    /**
     * 款号ID
     */
    private Long mProductId;
    /**
     * 款号名称
     */
    private String productName;
    /**
     * 商品所属类别
     */
    private String mptbelongtype;
    /**
     * 收藏状体：1-未收藏，2-已收藏
     */
    private Integer iscollect;
    /**
     * 图片
     */
    private String imgUrl;

    public Long getmProductId() {
        return mProductId;
    }

    public void setmProductId(Long mProductId) {
        this.mProductId = mProductId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMptbelongtype() {
        return mptbelongtype;
    }

    public void setMptbelongtype(String mptbelongtype) {
        this.mptbelongtype = mptbelongtype;
    }

    public Integer getIscollect() {
        return iscollect;
    }

    public void setIscollect(Integer iscollect) {
        this.iscollect = iscollect;
    }

    public String getImgUrl() {
        if (this.imgUrl != null){
            this.imgUrl =this.imgUrl+"?random="+ new Random().nextInt(100);
        }
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}