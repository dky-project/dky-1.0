package com.dky.common.param;

import com.dky.common.session.SessionParameter;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 更新订单
 * Created by hang 2017/2/19.
 */
public class UpdateProductApproveParam extends SessionParameter {

    /**
     * 删除订单ID
     */
    @NotEmpty(message = "请选择订单！")
    private Long[] ids;

    public Long[] getIds() {
        return ids;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }
}
