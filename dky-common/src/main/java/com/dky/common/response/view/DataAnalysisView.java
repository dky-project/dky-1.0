package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;

import java.util.Date;

/**
 * Created by wonpera on 2017/1/7.
 */
public class DataAnalysisView extends ResultObjectBase {

    private Long id;
    /**
     * 数量
     */
    private Long zxQty;
    /**
     * 机构号
     */
    private String code;
    /**
     * 总数
     */
    private Long allSum;
    /**
     * 占比
     */
    private String bfb;
    /**
     * 推荐比例
     */
    private String proportion;
    /**
     * 属性名称
     */
    private String attribname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getZxQty() {
        return zxQty;
    }

    public void setZxQty(Long zxQty) {
        this.zxQty = zxQty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getAllSum() {
        return allSum;
    }

    public void setAllSum(Long allSum) {
        this.allSum = allSum;
    }

    public String getBfb() {
        return bfb;
    }

    public void setBfb(String bfb) {
        this.bfb = bfb;
    }

    public String getAttribname() {
        return attribname;
    }

    public void setAttribname(String attribname) {
        this.attribname = attribname;
    }

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }
}
