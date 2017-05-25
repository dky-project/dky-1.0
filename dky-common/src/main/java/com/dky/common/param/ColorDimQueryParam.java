package com.dky.common.param;

import com.dky.common.session.BaseParameter;

import javax.validation.constraints.NotNull;

/**
 * Created by wonpera on 2017/2/26.
 */
public class ColorDimQueryParam extends BaseParameter {

    @NotNull(message = "mProductId不能为空")
    private Long mProductId;

    public Long getmProductId() {
        return mProductId;
    }

    public void setmProductId(Long mProductId) {
        this.mProductId = mProductId;
    }
}
