package com.dky.common.bean;

import java.math.BigDecimal;
import java.util.Date;

public class PdtBaseprice extends PojoObjectBase{
    private Long id;

    private Long adClientId;

    private Long adOrgId;

    private Long mProductId;

    private Long mDimNew13Id;

    private Long mDimNew14Id;

    private Long mDimNew16Id;

    private String xwValue;

    private BigDecimal ycValue;

    private Short status;

    private Short closeStatus;

    private Long ownerid;

    private Long modifierid;

    private Date creationdate;

    private Date modifieddate;

    private String isactive;

    private BigDecimal floatRate;

    private BigDecimal price1;

    private Long price;

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

    public Long getmProductId() {
        return mProductId;
    }

    public void setmProductId(Long mProductId) {
        this.mProductId = mProductId;
    }

    public Long getmDimNew13Id() {
        return mDimNew13Id;
    }

    public void setmDimNew13Id(Long mDimNew13Id) {
        this.mDimNew13Id = mDimNew13Id;
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

    public String getXwValue() {
        return xwValue;
    }

    public void setXwValue(String xwValue) {
        this.xwValue = xwValue == null ? null : xwValue.trim();
    }

    public BigDecimal getYcValue() {
        return ycValue;
    }

    public void setYcValue(BigDecimal ycValue) {
        this.ycValue = ycValue;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getCloseStatus() {
        return closeStatus;
    }

    public void setCloseStatus(Short closeStatus) {
        this.closeStatus = closeStatus;
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

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive == null ? null : isactive.trim();
    }

    public BigDecimal getFloatRate() {
        return floatRate;
    }

    public void setFloatRate(BigDecimal floatRate) {
        this.floatRate = floatRate;
    }

    public BigDecimal getPrice1() {
        return price1;
    }

    public void setPrice1(BigDecimal price1) {
        this.price1 = price1;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}