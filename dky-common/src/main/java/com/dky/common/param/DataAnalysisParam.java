package com.dky.common.param;

import com.dky.common.session.SessionParameter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by wonpera on 2017/1/7.
 */
public class DataAnalysisParam extends SessionParameter {

    @NotBlank(message = "类别必须输入！")
    private String dimFlagNew;

    public String getDimFlagNew() {
        return dimFlagNew;
    }

    public void setDimFlagNew(String dimFlagNew) {
        this.dimFlagNew = dimFlagNew;
    }
}
