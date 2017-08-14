package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;

import java.util.List;

/**
 * Created by hang on 2017/5/15 0004.
 * @decription 下单保存返回字段
 */
public class DpGroupReturnView extends ResultObjectBase {

    /**
     * 大货订单ID
     */
    private List<Long> bmptIds;
    /**
     * 定制订单ID
     */
    private List<Long> approveIds;

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
