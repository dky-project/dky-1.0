package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;

import java.util.List;

/**
 * Created by hang on 2017/1/4 0004.
 * @decription 样衣详情
 */
public class ProductInfoView extends ResultObjectBase {

    /**
     * 款号
     */
    private String name;
    /**
     * 大类
     */
    private String mDimNew11Text;
    /**
     * 性别
     */
    private String mDimNew13Text;
    /**
     * 温馨提示
     */
    private String description3;
    /**
     * 领子
     */
    private String description4;
    /**
     * 设计说明
     */
    private String description5;
    /**
     * 商品所属类别
     */
    private String mptbelongtype;
    /**
     * 所属类别
     */
    private String mptbelongtypeText;
    /**
     * 图片1
     */
    private String imgUrl1;
    /**
     * 图片2
     */
    private String imgUrl2;
    /**
     * 图片3
     */
    private String imgUrl3;
    /**
     * 图片4
     */
    private String imgUrl4;
    /**
     * 图片5
     */
    private String imgUrl5;
    /**
     * 图片6
     */
    private String imgUrl6;
    /**
     * 图片7
     */
    private String imgUrl7;
    /**
     * 图片8
     */
    private String imgUrl8;


    //以下为样衣默认项
    /**
     * 品种
     */
    private String mDimNew14Text;
    /**
     * 针型
     */
    private String mDimNew16Text;
    /**
     * 颜色
     */
    private String clrRange;
    /**
     * 胸围
     */
    private String defaultXwValue;
    /**
     * 衣长
     */
    private String defaultYcValue;
    /**
     * 袖长
     */
    private String defaultXcValue;
    //样衣默认项end


    private List<String> imgList;

    private String pdtPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getmDimNew13Text() {
        return mDimNew13Text;
    }

    public void setmDimNew13Text(String mDimNew13Text) {
        this.mDimNew13Text = mDimNew13Text;
    }

    public String getmDimNew11Text() {
        return mDimNew11Text;
    }

    public void setmDimNew11Text(String mDimNew11Text) {
        this.mDimNew11Text = mDimNew11Text;
    }

    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public String getDescription4() {
        return description4;
    }

    public void setDescription4(String description4) {
        this.description4 = description4;
    }

    public String getDescription5() {
        return description5;
    }

    public void setDescription5(String description5) {
        this.description5 = description5;
    }

    public String getMptbelongtype() {
        return mptbelongtype;
    }

    public void setMptbelongtype(String mptbelongtype) {
        this.mptbelongtype = mptbelongtype;
    }

    public String getMptbelongtypeText() {
        return mptbelongtypeText;
    }

    public void setMptbelongtypeText(String mptbelongtypeText) {
        this.mptbelongtypeText = mptbelongtypeText;
    }

    public String getImgUrl1() {
        return imgUrl1;
    }

    public void setImgUrl1(String imgUrl1) {
        this.imgUrl1 = imgUrl1;
    }

    public String getImgUrl2() {
        return imgUrl2;
    }

    public void setImgUrl2(String imgUrl2) {
        this.imgUrl2 = imgUrl2;
    }

    public String getImgUrl3() {
        return imgUrl3;
    }

    public void setImgUrl3(String imgUrl3) {
        this.imgUrl3 = imgUrl3;
    }

    public String getImgUrl4() {
        return imgUrl4;
    }

    public void setImgUrl4(String imgUrl4) {
        this.imgUrl4 = imgUrl4;
    }

    public String getImgUrl5() {
        return imgUrl5;
    }

    public void setImgUrl5(String imgUrl5) {
        this.imgUrl5 = imgUrl5;
    }

    public String getImgUrl6() {
        return imgUrl6;
    }

    public void setImgUrl6(String imgUrl6) {
        this.imgUrl6 = imgUrl6;
    }

    public String getImgUrl7() {
        return imgUrl7;
    }

    public void setImgUrl7(String imgUrl7) {
        this.imgUrl7 = imgUrl7;
    }

    public String getImgUrl8() {
        return imgUrl8;
    }

    public void setImgUrl8(String imgUrl8) {
        this.imgUrl8 = imgUrl8;
    }

    public String getmDimNew14Text() {
        return mDimNew14Text;
    }

    public void setmDimNew14Text(String mDimNew14Text) {
        this.mDimNew14Text = mDimNew14Text;
    }

    public String getmDimNew16Text() {
        return mDimNew16Text;
    }

    public void setmDimNew16Text(String mDimNew16Text) {
        this.mDimNew16Text = mDimNew16Text;
    }

    public String getClrRange() {
        return clrRange;
    }

    public void setClrRange(String clrRange) {
        this.clrRange = clrRange;
    }

    public String getDefaultXwValue() {
        return defaultXwValue;
    }

    public void setDefaultXwValue(String defaultXwValue) {
        this.defaultXwValue = defaultXwValue;
    }

    public String getDefaultYcValue() {
        return defaultYcValue;
    }

    public void setDefaultYcValue(String defaultYcValue) {
        this.defaultYcValue = defaultYcValue;
    }

    public String getDefaultXcValue() {
        return defaultXcValue;
    }

    public void setDefaultXcValue(String defaultXcValue) {
        this.defaultXcValue = defaultXcValue;
    }


    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }

    public String getPdtPrice() {
        return pdtPrice;
    }

    public void setPdtPrice(String pdtPrice) {
        this.pdtPrice = pdtPrice;
    }
}
