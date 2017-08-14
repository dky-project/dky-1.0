package com.dky.common.param;

import com.dky.common.session.SessionParameter;

import java.util.List;


/**
 * 更新订单
 * Created by hang 2017/2/19.
 */
public class UpdateProductApproveParam extends SessionParameter {

    /**
     * 订单ID
     */
    private Long id;

    private List<Long> bmptIds;

    private List<Long> approveIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getBmptIds() {
        return bmptIds;
    }

    public void setBmptIds(List<Long> bmptIds) {
        this.bmptIds = bmptIds;
    }

    public List<Long> getApproveIds() {
        return approveIds;
    }

    public void setApproveIds(List<Long> approveIds) {
        this.approveIds = approveIds;
    }
}
