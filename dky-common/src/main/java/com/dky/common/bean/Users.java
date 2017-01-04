package com.dky.common.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Users extends PageObjectBase {
    private Long id;

    private Long adClientId;

    private Long adOrgId;

    private String isactive;

    private Long supervisorId;

    private Long paGoalprivateId;

    private Long cBpartnerId;

    private String processing;

    private Long cBpartnerLocationId;

    private Long cGreetingId;

    private Integer lastcontact;

    private Integer birthday;

    private Long adOrgtrxId;

    private String isldapauthorized;

    private Long modifierid;

    private Date creationdate;

    private Date modifieddate;

    private Long ownerid;

    private String passwordhash;

    private Short isenabled;

    private Short isemployee;

    private Short isadmin;

    private Short usertype;

    private String truename;

    private String name;

    private String description;

    private String password;

    private String email;

    private String emailuser;

    private String emailuserpw;

    private String title;

    private String comments;

    private String phone;

    private String phone2;

    private String fax;

    private String lastresult;

    private String emailverify;

    private Long cDepartmentId;

    private String language;

    private String isOtp;

    private Short otpLength;

    private Short otpSeconds;

    private String otpSecret;

    private BigDecimal otpCounter;

    private String isOtpOnly;

    private Date otpCdate;

    private String loginIpRule;

    private String issms;

    private String isOut;

    private Long assigneeId;

    private String issaler;

    private Long cStoreId;

    private BigDecimal discountlimit;

    private String isopr;

    private String saasvendor;

    private String saasuser;

    private Long hrEmployeeId;

    private Long cCustomerId;

    private Long cCustomerupId;

    private Long areamngId;

    private Short sgrade;

    private Long cPriceregionId;

    private Long cSupplierId;

    private String subsystems;

    private Date passwordexpirationdate;

    private String passwordreset;

    private String isret;

    private String webposPer;

    private Long hrPostId;

    private String issys;

    private String isSysUser;

    private String mac;

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

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive == null ? null : isactive.trim();
    }

    public Long getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Long supervisorId) {
        this.supervisorId = supervisorId;
    }

    public Long getPaGoalprivateId() {
        return paGoalprivateId;
    }

    public void setPaGoalprivateId(Long paGoalprivateId) {
        this.paGoalprivateId = paGoalprivateId;
    }

    public Long getcBpartnerId() {
        return cBpartnerId;
    }

    public void setcBpartnerId(Long cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public String getProcessing() {
        return processing;
    }

    public void setProcessing(String processing) {
        this.processing = processing == null ? null : processing.trim();
    }

    public Long getcBpartnerLocationId() {
        return cBpartnerLocationId;
    }

    public void setcBpartnerLocationId(Long cBpartnerLocationId) {
        this.cBpartnerLocationId = cBpartnerLocationId;
    }

    public Long getcGreetingId() {
        return cGreetingId;
    }

    public void setcGreetingId(Long cGreetingId) {
        this.cGreetingId = cGreetingId;
    }

    public Integer getLastcontact() {
        return lastcontact;
    }

    public void setLastcontact(Integer lastcontact) {
        this.lastcontact = lastcontact;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public Long getAdOrgtrxId() {
        return adOrgtrxId;
    }

    public void setAdOrgtrxId(Long adOrgtrxId) {
        this.adOrgtrxId = adOrgtrxId;
    }

    public String getIsldapauthorized() {
        return isldapauthorized;
    }

    public void setIsldapauthorized(String isldapauthorized) {
        this.isldapauthorized = isldapauthorized == null ? null : isldapauthorized.trim();
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

    public Long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Long ownerid) {
        this.ownerid = ownerid;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public void setPasswordhash(String passwordhash) {
        this.passwordhash = passwordhash == null ? null : passwordhash.trim();
    }

    public Short getIsenabled() {
        return isenabled;
    }

    public void setIsenabled(Short isenabled) {
        this.isenabled = isenabled;
    }

    public Short getIsemployee() {
        return isemployee;
    }

    public void setIsemployee(Short isemployee) {
        this.isemployee = isemployee;
    }

    public Short getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Short isadmin) {
        this.isadmin = isadmin;
    }

    public Short getUsertype() {
        return usertype;
    }

    public void setUsertype(Short usertype) {
        this.usertype = usertype;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename == null ? null : truename.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getEmailuser() {
        return emailuser;
    }

    public void setEmailuser(String emailuser) {
        this.emailuser = emailuser == null ? null : emailuser.trim();
    }

    public String getEmailuserpw() {
        return emailuserpw;
    }

    public void setEmailuserpw(String emailuserpw) {
        this.emailuserpw = emailuserpw == null ? null : emailuserpw.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2 == null ? null : phone2.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getLastresult() {
        return lastresult;
    }

    public void setLastresult(String lastresult) {
        this.lastresult = lastresult == null ? null : lastresult.trim();
    }

    public String getEmailverify() {
        return emailverify;
    }

    public void setEmailverify(String emailverify) {
        this.emailverify = emailverify == null ? null : emailverify.trim();
    }

    public Long getcDepartmentId() {
        return cDepartmentId;
    }

    public void setcDepartmentId(Long cDepartmentId) {
        this.cDepartmentId = cDepartmentId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getIsOtp() {
        return isOtp;
    }

    public void setIsOtp(String isOtp) {
        this.isOtp = isOtp == null ? null : isOtp.trim();
    }

    public Short getOtpLength() {
        return otpLength;
    }

    public void setOtpLength(Short otpLength) {
        this.otpLength = otpLength;
    }

    public Short getOtpSeconds() {
        return otpSeconds;
    }

    public void setOtpSeconds(Short otpSeconds) {
        this.otpSeconds = otpSeconds;
    }

    public String getOtpSecret() {
        return otpSecret;
    }

    public void setOtpSecret(String otpSecret) {
        this.otpSecret = otpSecret == null ? null : otpSecret.trim();
    }

    public BigDecimal getOtpCounter() {
        return otpCounter;
    }

    public void setOtpCounter(BigDecimal otpCounter) {
        this.otpCounter = otpCounter;
    }

    public String getIsOtpOnly() {
        return isOtpOnly;
    }

    public void setIsOtpOnly(String isOtpOnly) {
        this.isOtpOnly = isOtpOnly == null ? null : isOtpOnly.trim();
    }

    public Date getOtpCdate() {
        return otpCdate;
    }

    public void setOtpCdate(Date otpCdate) {
        this.otpCdate = otpCdate;
    }

    public String getLoginIpRule() {
        return loginIpRule;
    }

    public void setLoginIpRule(String loginIpRule) {
        this.loginIpRule = loginIpRule == null ? null : loginIpRule.trim();
    }

    public String getIssms() {
        return issms;
    }

    public void setIssms(String issms) {
        this.issms = issms == null ? null : issms.trim();
    }

    public String getIsOut() {
        return isOut;
    }

    public void setIsOut(String isOut) {
        this.isOut = isOut == null ? null : isOut.trim();
    }

    public Long getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(Long assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getIssaler() {
        return issaler;
    }

    public void setIssaler(String issaler) {
        this.issaler = issaler == null ? null : issaler.trim();
    }

    public Long getcStoreId() {
        return cStoreId;
    }

    public void setcStoreId(Long cStoreId) {
        this.cStoreId = cStoreId;
    }

    public BigDecimal getDiscountlimit() {
        return discountlimit;
    }

    public void setDiscountlimit(BigDecimal discountlimit) {
        this.discountlimit = discountlimit;
    }

    public String getIsopr() {
        return isopr;
    }

    public void setIsopr(String isopr) {
        this.isopr = isopr == null ? null : isopr.trim();
    }

    public String getSaasvendor() {
        return saasvendor;
    }

    public void setSaasvendor(String saasvendor) {
        this.saasvendor = saasvendor == null ? null : saasvendor.trim();
    }

    public String getSaasuser() {
        return saasuser;
    }

    public void setSaasuser(String saasuser) {
        this.saasuser = saasuser == null ? null : saasuser.trim();
    }

    public Long getHrEmployeeId() {
        return hrEmployeeId;
    }

    public void setHrEmployeeId(Long hrEmployeeId) {
        this.hrEmployeeId = hrEmployeeId;
    }

    public Long getcCustomerId() {
        return cCustomerId;
    }

    public void setcCustomerId(Long cCustomerId) {
        this.cCustomerId = cCustomerId;
    }

    public Long getcCustomerupId() {
        return cCustomerupId;
    }

    public void setcCustomerupId(Long cCustomerupId) {
        this.cCustomerupId = cCustomerupId;
    }

    public Long getAreamngId() {
        return areamngId;
    }

    public void setAreamngId(Long areamngId) {
        this.areamngId = areamngId;
    }

    public Short getSgrade() {
        return sgrade;
    }

    public void setSgrade(Short sgrade) {
        this.sgrade = sgrade;
    }

    public Long getcPriceregionId() {
        return cPriceregionId;
    }

    public void setcPriceregionId(Long cPriceregionId) {
        this.cPriceregionId = cPriceregionId;
    }

    public Long getcSupplierId() {
        return cSupplierId;
    }

    public void setcSupplierId(Long cSupplierId) {
        this.cSupplierId = cSupplierId;
    }

    public String getSubsystems() {
        return subsystems;
    }

    public void setSubsystems(String subsystems) {
        this.subsystems = subsystems == null ? null : subsystems.trim();
    }

    public Date getPasswordexpirationdate() {
        return passwordexpirationdate;
    }

    public void setPasswordexpirationdate(Date passwordexpirationdate) {
        this.passwordexpirationdate = passwordexpirationdate;
    }

    public String getPasswordreset() {
        return passwordreset;
    }

    public void setPasswordreset(String passwordreset) {
        this.passwordreset = passwordreset == null ? null : passwordreset.trim();
    }

    public String getIsret() {
        return isret;
    }

    public void setIsret(String isret) {
        this.isret = isret == null ? null : isret.trim();
    }

    public String getWebposPer() {
        return webposPer;
    }

    public void setWebposPer(String webposPer) {
        this.webposPer = webposPer == null ? null : webposPer.trim();
    }

    public Long getHrPostId() {
        return hrPostId;
    }

    public void setHrPostId(Long hrPostId) {
        this.hrPostId = hrPostId;
    }

    public String getIssys() {
        return issys;
    }

    public void setIssys(String issys) {
        this.issys = issys == null ? null : issys.trim();
    }

    public String getIsSysUser() {
        return isSysUser;
    }

    public void setIsSysUser(String isSysUser) {
        this.isSysUser = isSysUser == null ? null : isSysUser.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }
}