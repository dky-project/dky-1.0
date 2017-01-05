package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;

/**
 * Created by hang on 2017/1/4 0004.
 * @decription 样衣查询列表
 */
public class ProductView extends ResultObjectBase {

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
        return imgUrl1;
    }

    public void setImgUrl1(String imgUrl1) {
        this.imgUrl1 = imgUrl1;
    }
}
