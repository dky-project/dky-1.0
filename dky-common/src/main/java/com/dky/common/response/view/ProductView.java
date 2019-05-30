package com.dky.common.response.view;

import com.dky.common.constats.GlobConts;
import com.dky.common.response.ResultObjectBase;

import java.util.Date;

/**
 * Created by hang on 2017/1/4 0004.
 * @decription 样衣查询列表
 */
public class ProductView extends ResultObjectBase {


    /**
     * productId
     */
    private Long mProductId;

    /**
     * 款号
     */
    private String name;

    /**
     * 类型
     */
    private String dlValue;
    /**
     * 大类
     */
    private String mDimNew11Text;
    /**
     * 品类
     */
    private String mDim16Text;
    /**
     * 图片1
     */
    private String imgUrl1;
    /**
     * 图片1
     */
    private Date modifieddate;
    /**
     * 是否收藏
     */
    private Integer iscollect;
    /**
     * 是否推荐
     */
    private String isRecommend;

    private String bigImgUrl;

    private Long mDimNew13Id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getmDimNew11Text() {
        return mDimNew11Text;
    }

    public void setmDimNew11Text(String mDimNew11Text) {
        this.mDimNew11Text = mDimNew11Text;
    }

    public String getImgUrl1() {
        return  this.imgUrl1;
    }

    public void setImgUrl1(String imgUrl1) {
        this.imgUrl1 = imgUrl1;
    }

    public Long getmProductId() {
        return mProductId;
    }

    public void setmProductId(Long mProductId) {
        this.mProductId = mProductId;
    }

    public Date getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;

    }

    public Integer getIscollect() {
        return iscollect;
    }

    public void setIscollect(Integer iscollect) {
        this.iscollect = iscollect;
    }

    public String getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(String isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getBigImgUrl() {
        return bigImgUrl;
    }

    public void setBigImgUrl(String bigImgUrl) {
        this.bigImgUrl = bigImgUrl;
    }

    public String getmDim16Text() {
        return mDim16Text;
    }

    public void setmDim16Text(String mDim16Text) {
        this.mDim16Text = mDim16Text;
    }

    public String getDlValue() {
        return dlValue;
    }

    public void setDlValue(String dlValue) {
        this.dlValue = dlValue;
    }

    public Long getmDimNew13Id() {
        return mDimNew13Id;
    }

    public void setmDimNew13Id(Long mDimNew13Id) {
        this.mDimNew13Id = mDimNew13Id;
    }
}
