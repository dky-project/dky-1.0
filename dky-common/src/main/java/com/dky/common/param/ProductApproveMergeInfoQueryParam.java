package com.dky.common.param;

import com.dky.common.session.SessionParameter;

/**
 * Created by hang on 2017/2/26.
 */
public class ProductApproveMergeInfoQueryParam extends SessionParameter {

    private Long[] ids;

    public Long[] getIds() {
        return ids;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }
}
