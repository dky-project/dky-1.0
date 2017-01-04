package com.dky.common.enums;

/**
 * 返回结果状态枚举
 * Created by wangpeng on 2016/12/13.
 */
public enum  ResultCodeEnum {

    SUCCESS(200,true,"成功"),
    FAILURE(500,false,"失败"),

    USER_LOGIN_ERROR(1001,false,"用户不存在"),
    ;


    private int code;
    private boolean success;
    private String message;

    ResultCodeEnum(int code, boolean success, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
