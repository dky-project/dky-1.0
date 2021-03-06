package com.dky.common.bean;

import java.io.Serializable;

/**
 * Created by wangpeng on 2017/1/4.
 */
public class SessionUser implements Serializable {

    private static final long serialVersionUID = -6736961910288444407L;

    private Long userId;

    private String email;

    private Long cStoreId;

    private Long cCustomerId;

    private Boolean isUser = Boolean.TRUE;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getcStoreId() {
        return cStoreId;
    }

    public void setcStoreId(Long cStoreId) {
        this.cStoreId = cStoreId;
    }

    public Long getcCustomerId() {
        return cCustomerId;
    }

    public void setcCustomerId(Long cCustomerId) {
        this.cCustomerId = cCustomerId;
    }

    public Boolean getIsUser() {
        return isUser;
    }

    public void setIsUser(Boolean user) {
        isUser = user;
    }
}
