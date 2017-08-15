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
    /**
     * 大货订单ID
     */
    private Long[] bmptIds;
    /**
     * 定制订单ID
     */
    private Long[] approveIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long[] getBmptIds() {
        return bmptIds;
    }

    public void setBmptIds(Long[] bmptIds) {
        this.bmptIds = bmptIds;
    }

    public Long[] getApproveIds() {
        return approveIds;
    }

    public void setApproveIds(Long[] approveIds) {
        this.approveIds = approveIds;
    }
}
