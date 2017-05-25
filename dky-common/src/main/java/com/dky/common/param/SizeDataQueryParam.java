package com.dky.common.param;

import com.dky.common.session.BaseParameter;

import javax.validation.constraints.NotNull;

/**
 * Created by wonpera on 2017/2/26.
 */
public class SizeDataQueryParam extends BaseParameter {

    @NotNull(message = "款号名称不能为空！")
    private String pdt;

    private String xwValue;

    public String getPdt() {
        return pdt;
    }

    public void setPdt(String pdt) {
        this.pdt = pdt;
    }

    public String getXwValue() {
        return xwValue;
    }

    public void setXwValue(String xwValue) {
        this.xwValue = xwValue;
    }
}
