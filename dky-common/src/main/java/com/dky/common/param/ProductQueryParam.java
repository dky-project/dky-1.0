package com.dky.common.param;

import com.dky.common.session.WebPageParameter;

/**
 * Created by wonpera on 2017/1/6.
 */
public class ProductQueryParam extends WebPageParameter {

    /**
     * 大类
     */
    private Long mDimNew11Id;


    /**
     * 性别
     */
    private Long mDimNew13Id;


    public Long getmDimNew11Id() {
        return mDimNew11Id;
    }

    public void setmDimNew11Id(Long mDimNew11Id) {
        this.mDimNew11Id = mDimNew11Id;
    }

    public Long getmDimNew13Id() {
        return mDimNew13Id;
    }

    public void setmDimNew13Id(Long mDimNew13Id) {
        this.mDimNew13Id = mDimNew13Id;
    }
}
