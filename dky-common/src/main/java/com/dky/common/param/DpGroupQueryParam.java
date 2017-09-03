package com.dky.common.param;

import com.dky.common.session.WebPageParameter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by hang on 2017/2/26.
 */
public class DpGroupQueryParam extends WebPageParameter {

    @NotBlank(message = "组号不能为空！")
    private String groupNo;

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }
}
