package com.dky.common.bean;

import java.util.Date;

public class BmptApprove extends PojoObjectBase{
    private Long id;

    private Long adClientId;

    private Long adOrgId;

    private Long cCustomerId;

    private Long cStoreId;

    private Long mProductaliasId;

    private Long mProductId;

    private Long qty;

    private Short isapprove;

    private Long mAttributesetinstanceId;

    private Long ownerid;

    private Long modifierid;

    private Date creationdate;

    private Date modifieddate;

    private Long statuserid;

    private Date statustime;

    private String isactive;

    private Long mPurchaseId;

    private Long noerid;

    private Date notime;

    private Long mColorId;

    private Long mSizeId;

    private Long mDimNew13Id;

    private Short isFair;

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

    public Long getcCustomerId() {
        return cCustomerId;
    }

    public void setcCustomerId(Long cCustomerId) {
        this.cCustomerId = cCustomerId;
    }

    public Long getcStoreId() {
        return cStoreId;
    }

    public void setcStoreId(Long cStoreId) {
        this.cStoreId = cStoreId;
    }

    public Long getmProductaliasId() {
        return mProductaliasId;
    }

    public void setmProductaliasId(Long mProductaliasId) {
        this.mProductaliasId = mProductaliasId;
    }

    public Long getmProductId() {
        return mProductId;
    }

    public void setmProductId(Long mProductId) {
        this.mProductId = mProductId;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public Short getIsapprove() {
        return isapprove;
    }

    public void setIsapprove(Short isapprove) {
        this.isapprove = isapprove;
    }

    public Long getmAttributesetinstanceId() {
        return mAttributesetinstanceId;
    }

    public void setmAttributesetinstanceId(Long mAttributesetinstanceId) {
        this.mAttributesetinstanceId = mAttributesetinstanceId;
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

    public Long getStatuserid() {
        return statuserid;
    }

    public void setStatuserid(Long statuserid) {
        this.statuserid = statuserid;
    }

    public Date getStatustime() {
        return statustime;
    }

    public void setStatustime(Date statustime) {
        this.statustime = statustime;
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive == null ? null : isactive.trim();
    }

    public Long getmPurchaseId() {
        return mPurchaseId;
    }

    public void setmPurchaseId(Long mPurchaseId) {
        this.mPurchaseId = mPurchaseId;
    }

    public Long getNoerid() {
        return noerid;
    }

    public void setNoerid(Long noerid) {
        this.noerid = noerid;
    }

    public Date getNotime() {
        return notime;
    }

    public void setNotime(Date notime) {
        this.notime = notime;
    }

    public Long getmColorId() {
        return mColorId;
    }

    public void setmColorId(Long mColorId) {
        this.mColorId = mColorId;
    }

    public Long getmSizeId() {
        return mSizeId;
    }

    public void setmSizeId(Long mSizeId) {
        this.mSizeId = mSizeId;
    }

    public Long getmDimNew13Id() {
        return mDimNew13Id;
    }

    public void setmDimNew13Id(Long mDimNew13Id) {
        this.mDimNew13Id = mDimNew13Id;
    }

    public Short getIsFair() {
        return isFair;
    }

    public void setIsFair(Short isFair) {
        this.isFair = isFair;
    }
}