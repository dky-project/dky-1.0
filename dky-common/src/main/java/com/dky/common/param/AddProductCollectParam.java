package com.dky.common.param;

import com.dky.common.session.SessionParameter;

import javax.validation.constraints.NotNull;

/**
 * Created by hang on 2017/1/6.
 */
public class AddProductCollectParam extends SessionParameter {
    /**
     * 款号ID
     */
    @NotNull(message = "款号不能为空！")
    private Long productId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
