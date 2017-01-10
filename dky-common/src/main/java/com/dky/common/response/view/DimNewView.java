package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;


/**
 * Created by wangpeng on 2017/1/10.
 */
public class DimNewView extends ResultObjectBase {

    private Long id;

    private String attribcode;

    private String attribname;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttribcode() {
        return attribcode;
    }

    public void setAttribcode(String attribcode) {
        this.attribcode = attribcode;
    }

    public String getAttribname() {
        return attribname;
    }

    public void setAttribname(String attribname) {
        this.attribname = attribname;
    }
}
