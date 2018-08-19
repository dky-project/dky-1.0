package com.dky.common.param;

import com.dky.common.session.WebPageParameter;

/**
 * Created by hang on 2017/2/26.
 */
public class ClGroupQueryParam extends WebPageParameter {

    /**
     * 杆位
     */
    private String gh;
    /**
     * 厅位
     */
    private String hallName;
    /**
     * 系列
     */
    private String attribname;

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getAttribname() {
        return attribname;
    }

    public void setAttribname(String attribname) {
        this.attribname = attribname;
    }
}
