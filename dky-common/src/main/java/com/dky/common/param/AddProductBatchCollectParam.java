package com.dky.common.param;

import com.dky.common.session.SessionParameter;

import javax.validation.constraints.NotNull;

/**
 * Created by hang on 2017/1/6.
 */
public class AddProductBatchCollectParam extends SessionParameter {
    /**
     * 款号ID
     */
    @NotNull(message = "款号不能为空！")
    private Long[] productIds;
    /**
     * 全部收藏 Y 全部取消 N
     */
    private String cancel;

    public Long[] getProductIds() {
        return productIds;
    }

    public void setProductIds(Long[] productIds) {
        this.productIds = productIds;
    }

    public String getCancel() {
        return cancel;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }
}
