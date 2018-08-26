package com.dky.common.response.view;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dky.common.constats.GlobConts;
import com.dky.common.response.ResultObjectBase;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

/**
 * Created by hang on 2017/1/4 0004.
 * @decription 搭配
 */
public class DpGroupView extends ResultObjectBase {

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
     * 尺寸：大 默认值
     */
    private String xwValue;
    /**
     * 袖长
     */
    private String xcValue;
    /**
     * 尺寸：大
     * 胸围下拉框
     */
    private JSONArray xwArrayJson;
    /**
     * 尺寸：长
     */
    private String ycValue;
    /**
     * 工艺袖长
     */
    private String hzxcValue;
    /**
     * 是否配置衣长
     * 值为“Y”时，请选择收腰下拉框下面的长[文本框]不可编辑
     */
    private String isYcAffix;
    /**
     * 图片
     */
    private String imgUrl;
    /**
     * 品种默认值
     */
    private Long mDimNew14Id;
    /**
     * 针型默认值
     */
    private Long mDimNew16Id;
    /**
     * 肩型
     */
    private Long mDimNew22Id;
    /**
     * 品种列表
     */
    private JSONArray pzJsonstr;
    /**
     * 针型列表
     */
    private JSONArray zxJsonstr;
    /**
     * 品类列表
     */
    private JSONArray pinList;
    /**
     * 颜色列表
     */
    private List<ProductColorView> colorViewList;
    /**
     * 设计师推荐颜色列表
     */
    private List<ProductColorView> colorRangeViewList;
    /**
     * 尺寸列表
     */
    private List<ProductSizeView> sizeViewList;
    /**
     * 收藏状体：1-未收藏，2-已收藏
     */
    private Integer iscollect;

    private BigDecimal price;
    /**
     * 品类默认值
     */
    private Long mDim16Id;
    /**
     * 排序字段
     */
    private int orderNum;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        if (imgUrl != null){
            this.imgUrl = GlobConts.IMAGE_ROOT_URL+imgUrl.replace("img","DP_XQ").replace("#","")+"?random="+ new Random().nextInt(100);
        }
    }

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

    public List<ProductColorView> getColorViewList() {
        return colorViewList;
    }

    public void setColorViewList(List<ProductColorView> colorViewList) {
        this.colorViewList = colorViewList;
    }

    public List<ProductSizeView> getSizeViewList() {
        return sizeViewList;
    }

    public void setSizeViewList(List<ProductSizeView> sizeViewList) {
        this.sizeViewList = sizeViewList;
    }

    public Long getmDimNew14Id() {
        return mDimNew14Id;
    }

    public void setmDimNew14Id(Long mDimNew14Id) {
        this.mDimNew14Id = mDimNew14Id;
    }

    public Long getmDimNew16Id() {
        return mDimNew16Id;
    }

    public void setmDimNew16Id(Long mDimNew16Id) {
        this.mDimNew16Id = mDimNew16Id;
    }

    public JSONArray getXwArrayJson() {
        return xwArrayJson;
    }

    public void setXwArrayJson(String xwArrayJson) {
        this.xwArrayJson = JSONObject.parseArray(xwArrayJson);
    }

    public JSONArray getPzJsonstr() {
        return pzJsonstr;
    }

    public void setPzJsonstr(String pzJsonstr) {
        this.pzJsonstr = JSONArray.parseObject(pzJsonstr).getJSONArray("value");
    }

    public JSONArray getZxJsonstr() {
        return zxJsonstr;
    }

    public void setZxJsonstr(String zxJsonstr) {
        this.zxJsonstr = JSONArray.parseObject(zxJsonstr).getJSONArray("value");
    }

    public String getIsYcAffix() {
        return isYcAffix;
    }

    public void setIsYcAffix(String isYcAffix) {
        this.isYcAffix = isYcAffix;
    }

    public String getXcValue() {
        return xcValue;
    }

    public void setXcValue(String xcValue) {
        this.xcValue = xcValue;
    }

    public Integer getIscollect() {
        return iscollect;
    }

    public void setIscollect(Integer iscollect) {
        this.iscollect = iscollect;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public JSONArray getPinList() {
        return pinList;
    }

    public void setPinList(JSONArray pinList) {
        this.pinList = pinList;
    }

    public List<ProductColorView> getColorRangeViewList() {
        return colorRangeViewList;
    }

    public void setColorRangeViewList(List<ProductColorView> colorRangeViewList) {
        this.colorRangeViewList = colorRangeViewList;
    }

    public Long getmDim16Id() {
        return mDim16Id;
    }

    public void setmDim16Id(Long mDim16Id) {
        this.mDim16Id = mDim16Id;
    }

    public Long getmDimNew22Id() {
        return mDimNew22Id;
    }

    public void setmDimNew22Id(Long mDimNew22Id) {
        this.mDimNew22Id = mDimNew22Id;
    }

    public String getHzxcValue() {
        return hzxcValue;
    }

    public void setHzxcValue(String hzxcValue) {
        this.hzxcValue = hzxcValue;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
}
