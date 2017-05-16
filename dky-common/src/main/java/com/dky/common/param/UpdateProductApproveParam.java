package com.dky.common.param;

import com.dky.common.session.SessionParameter;


/**
 * 更新订单
 * Created by hang 2017/2/19.
 */
public class UpdateProductApproveParam extends SessionParameter {

    /**
     * 订单ID
     */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
