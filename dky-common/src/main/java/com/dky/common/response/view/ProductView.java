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
     * 大类
     */
    private String mDimNew11Text;
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
        if (this.imgUrl1 != null){
            this.imgUrl1 = GlobConts.IMAGE_ROOT_URL+this.imgUrl1.replace("img","img_sl")+"?modifieddate="+modifieddate.getTime();
        }
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
}
