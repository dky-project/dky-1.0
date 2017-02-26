package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;

import java.util.List;


/**
 * Created by wangpeng on 2017/1/10.
 */
public class DimNewListView extends ResultObjectBase {

    private List<DimNewView> sexList;
    private List<DimNewView> bigClassList;
    private List<DimNewView> pzList;
    private List<DimNewView> zzList;
    private List<DimNewView> zxList;
    private List<DimNewView> syList;
    private List<DimNewView> lxList;
    private List<DimNewView> xxList;
    private List<DimNewView> yearList;

    public List<DimNewView> getSexList() {
        return sexList;
    }

    public void setSexList(List<DimNewView> sexList) {
        this.sexList = sexList;
    }

    public List<DimNewView> getBigClassList() {
        return bigClassList;
    }

    public void setBigClassList(List<DimNewView> bigClassList) {
        this.bigClassList = bigClassList;
    }

    public List<DimNewView> getPzList() {
        return pzList;
    }

    public void setPzList(List<DimNewView> pzList) {
        this.pzList = pzList;
    }

    public List<DimNewView> getZzList() {
        return zzList;
    }

    public void setZzList(List<DimNewView> zzList) {
        this.zzList = zzList;
    }

    public List<DimNewView> getZxList() {
        return zxList;
    }

    public void setZxList(List<DimNewView> zxList) {
        this.zxList = zxList;
    }

    public List<DimNewView> getSyList() {
        return syList;
    }

    public void setSyList(List<DimNewView> syList) {
        this.syList = syList;
    }

    public List<DimNewView> getLxList() {
        return lxList;
    }

    public void setLxList(List<DimNewView> lxList) {
        this.lxList = lxList;
    }

    public List<DimNewView> getXxList() {
        return xxList;
    }

    public void setXxList(List<DimNewView> xxList) {
        this.xxList = xxList;
    }

    public List<DimNewView> getYearList() {
        return yearList;
    }

    public void setYearList(List<DimNewView> yearList) {
        this.yearList = yearList;
    }
}
