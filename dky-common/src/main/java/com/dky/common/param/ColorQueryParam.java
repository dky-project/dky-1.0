package com.dky.common.param;

import com.dky.common.session.BaseParameter;

import javax.validation.constraints.NotNull;

/**
 * Created by wonpera on 2017/2/26.
 */
public class ColorQueryParam extends BaseParameter {

    @NotNull(message = "mDimNew14Id不能为空")
    private Long mDimNew14Id;

    public Long getmDimNew14Id() {
        return mDimNew14Id;
    }

    public void setmDimNew14Id(Long mDimNew14Id) {
        this.mDimNew14Id = mDimNew14Id;
    }
}
