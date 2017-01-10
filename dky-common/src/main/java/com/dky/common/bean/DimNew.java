package com.dky.common.bean;

import java.util.Date;

public class DimNew extends PojoObjectBase {
    private Long id;

    private Long adClientId;

    private Long adOrgId;

    private String attribcode;

    private String attribname;

    private String attribEname;

    private Long mDimdefNewId;

    private String dimflag;

    private Long ownerid;

    private Long modifierid;

    private Date creationdate;

    private Date modifieddate;

    private String isactive;

    private Long sorting;

    private String securitytype;

    private String dostandard;

    private Long code;

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

    public String getAttribcode() {
        return attribcode;
    }

    public void setAttribcode(String attribcode) {
        this.attribcode = attribcode == null ? null : attribcode.trim();
    }

    public String getAttribname() {
        return attribname;
    }

    public void setAttribname(String attribname) {
        this.attribname = attribname == null ? null : attribname.trim();
    }

    public String getAttribEname() {
        return attribEname;
    }

    public void setAttribEname(String attribEname) {
        this.attribEname = attribEname == null ? null : attribEname.trim();
    }

    public Long getmDimdefNewId() {
        return mDimdefNewId;
    }

    public void setmDimdefNewId(Long mDimdefNewId) {
        this.mDimdefNewId = mDimdefNewId;
    }

    public String getDimflag() {
        return dimflag;
    }

    public void setDimflag(String dimflag) {
        this.dimflag = dimflag == null ? null : dimflag.trim();
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

    public Long getSorting() {
        return sorting;
    }

    public void setSorting(Long sorting) {
        this.sorting = sorting;
    }

    public String getSecuritytype() {
        return securitytype;
    }

    public void setSecuritytype(String securitytype) {
        this.securitytype = securitytype == null ? null : securitytype.trim();
    }

    public String getDostandard() {
        return dostandard;
    }

    public void setDostandard(String dostandard) {
        this.dostandard = dostandard == null ? null : dostandard.trim();
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }
}