package com.dky.common.param;

import com.dky.common.session.BaseParameter;

import javax.validation.constraints.NotNull;

/**
 * Created by wonpera on 2017/2/26.
 */
public class ColorDimQueryParam extends BaseParameter {

    @NotNull(message = "mProductId不能为空")
    private Long mProductId;


    private Long mDimNew14Id;

    public Long getmProductId() {
        return mProductId;
    }

    public void setmProductId(Long mProductId) {
        this.mProductId = mProductId;
    }

    public Long getmDimNew14Id() {
        return mDimNew14Id;
    }

    public void setmDimNew14Id(Long mDimNew14Id) {
        this.mDimNew14Id = mDimNew14Id;
    }
}
