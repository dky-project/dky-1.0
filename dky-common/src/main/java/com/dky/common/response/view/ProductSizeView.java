package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;


/**
 * Created by hang on 2017/1/10.
 */
public class ProductSizeView extends ResultObjectBase {

    private Long sizeId;

    private String sizeName;

    public Long getSizeId() {
        return sizeId;
    }

    public void setSizeId(Long sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }
}
