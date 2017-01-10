package com.dky.common.enums;

/**
 * Created by wangpeng on 2017/1/10.
 */
public enum  DimFlagEnum {
    SEX("DIMFLAG_NEW13","性别"),
    BIG_CLASS("DIMFLAG_NEW11","大类"),
    ;


    private String code;

    private String message;

    DimFlagEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
