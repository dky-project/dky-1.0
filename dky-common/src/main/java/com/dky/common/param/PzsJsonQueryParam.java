package com.dky.common.param;

import com.dky.common.session.BaseParameter;

import javax.validation.constraints.NotNull;

/**
 * Created by wonpera on 2017/2/26.
 */
public class PzsJsonQueryParam extends BaseParameter {


    /**
     * 1、	选择品种下拉框接口  flag:1
     * 2、	选择组织下拉框接口  flag:2
     * 3、	选择针型下拉框接口  flag:3
     * 4、	选择支别下拉框接口  flag:4
     */
    @NotNull(message = "flag不能为空")
    private String flag;

    @NotNull(message = "productId不能为空")
    private Long productId;

    @NotNull(message = "mDimNew14Id不能为空")
    private Long mDimNew14Id;

    @NotNull(message = "mDimNew15Id不能为空")
    private Long mDimNew15Id;

    @NotNull(message = "mDimNew16Id不能为空")
    private Long mDimNew16Id;

    @NotNull(message = "mDimNew17Id不能为空")
    private Long mDimNew17Id;


    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getmDimNew14Id() {
        return mDimNew14Id;
    }

    public void setmDimNew14Id(Long mDimNew14Id) {
        this.mDimNew14Id = mDimNew14Id;
    }

    public Long getmDimNew15Id() {
        return mDimNew15Id;
    }

    public void setmDimNew15Id(Long mDimNew15Id) {
        this.mDimNew15Id = mDimNew15Id;
    }

    public Long getmDimNew16Id() {
        return mDimNew16Id;
    }

    public void setmDimNew16Id(Long mDimNew16Id) {
        this.mDimNew16Id = mDimNew16Id;
    }

    public Long getmDimNew17Id() {
        return mDimNew17Id;
    }

    public void setmDimNew17Id(Long mDimNew17Id) {
        this.mDimNew17Id = mDimNew17Id;
    }
}
