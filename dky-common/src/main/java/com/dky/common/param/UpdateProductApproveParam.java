package com.dky.common.param;

import com.dky.common.session.SessionParameter;
import org.hibernate.validator.constraints.NotEmpty;

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
    /**
     * 删除订单ID
     */
    @NotEmpty(message = "请选择订单！")
    private Long[] ids;

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

    public Long[] getIds() {
        return ids;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }
}
