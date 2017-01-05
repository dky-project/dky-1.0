package com.dky.common.param;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by hang on 2017/1/4 0004.
 */
public class LoginUserParam implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 登录邮箱
     */
    @NotEmpty(message = "不能为空")
    private String email;
    /**
     * 登录密码
     */
    @NotEmpty(message = "密码不能为空")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
