package com.dky.common.bean;

import com.dky.common.constats.GlobConts;

import java.util.Date;

public class DpGroup extends PojoObjectBase{
    private Long id;

    private Long adClientId;

    private Long adOrgId;

    private Long ownerid;

    private Long modifierid;

    private Date creationdate;

    private Date modifieddate;

    private String groupNo;

    private Long syProductId;

    private Long wtProductId;

    private Long xzProductId;

    private Long ydProductId;

    private Long spProductId;

    private Long shoesProductId;

    private Long baoProductId;

    private Long wjProductId;

    private String isactive;

    private String dpImgUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(Long adClientId) {
        this.adClientId = adClientId;
    }

    public Long getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(Long adOrgId) {
        this.adOrgId = adOrgId;
    }

    public Long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Long ownerid) {
        this.ownerid = ownerid;
    }

    public Long getModifierid() {
        return modifierid;
    }

    public void setModifierid(Long modifierid) {
        this.modifierid = modifierid;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.dpImgUrl = GlobConts.IMAGE_ROOT_URL+"/DP_SL/"+groupNo+".jpg?modifieddate="+ modifieddate.getTime();
        this.groupNo = groupNo == null ? null : groupNo.trim();
    }

    public Long getSyProductId() {
        return syProductId;
    }

    public void setSyProductId(Long syProductId) {
        this.syProductId = syProductId;
    }

    public Long getWtProductId() {
        return wtProductId;
    }

    public void setWtProductId(Long wtProductId) {
        this.wtProductId = wtProductId;
    }

    public Long getXzProductId() {
        return xzProductId;
    }

    public void setXzProductId(Long xzProductId) {
        this.xzProductId = xzProductId;
    }

    public Long getYdProductId() {
        return ydProductId;
    }

    public void setYdProductId(Long ydProductId) {
        this.ydProductId = ydProductId;
    }

    public Long getSpProductId() {
        return spProductId;
    }

    public void setSpProductId(Long spProductId) {
        this.spProductId = spProductId;
    }

    public Long getShoesProductId() {
        return shoesProductId;
    }

    public void setShoesProductId(Long shoesProductId) {
        this.shoesProductId = shoesProductId;
    }

    public Long getBaoProductId() {
        return baoProductId;
    }

    public void setBaoProductId(Long baoProductId) {
        this.baoProductId = baoProductId;
    }

    public Long getWjProductId() {
        return wjProductId;
    }

    public void setWjProductId(Long wjProductId) {
        this.wjProductId = wjProductId;
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive == null ? null : isactive.trim();
    }

    public String getDpImgUrl() {
        return dpImgUrl;
    }

    public void setDpImgUrl(String dpImgUrl) {
        this.dpImgUrl = dpImgUrl;
    }
}