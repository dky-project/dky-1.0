package com.dky.common.bean;

import com.dky.common.convert.SysDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

/**
 * Created by wangpeng on 2016/12/13.
 */
public class SysLog extends  PojoObjectBase{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String orgName;
    private String roleName;
    private String operationType;
    private String modules;
    @JsonSerialize(using=SysDateSerializer.class)
    private Date operationTime;
    private String operation;
    @JsonSerialize(using=SysDateSerializer.class)
    private Date createTime;
    private String remark;
    private String account;
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getOrgName() {
        return this.orgName;
    }
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    public String getRoleName() {
        return this.roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getOperationType() {
        return this.operationType;
    }
    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
    public String getModules() {
        return this.modules;
    }
    public void setModules(String modules) {
        this.modules = modules;
    }
    public Date getOperationTime() {
        return this.operationTime;
    }
    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
    public String getOperation() {
        return this.operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }
    public Date getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getRemark() {
        return this.remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getAccount() {
        return this.account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
}
