package com.dky.common.param;

import com.dky.common.session.SessionParameter;

import java.util.List;

/**
 * Created by hang on 2017/2/26.
 */
public class AddDpGroupParam extends SessionParameter {

    private List<AddDpGroupApproveParam> addDpGroupApproveParamList;

    private List<AddDpGroupBmptParam> addDpGroupBmptParamList;

    private String paramJson;

    public List<AddDpGroupApproveParam> getAddDpGroupApproveParamList() {
        return addDpGroupApproveParamList;
    }

    public void setAddDpGroupApproveParamList(List<AddDpGroupApproveParam> addDpGroupApproveParamList) {
        this.addDpGroupApproveParamList = addDpGroupApproveParamList;
    }

    public List<AddDpGroupBmptParam> getAddDpGroupBmptParamList() {
        return addDpGroupBmptParamList;
    }

    public void setAddDpGroupBmptParamList(List<AddDpGroupBmptParam> addDpGroupBmptParamList) {
        this.addDpGroupBmptParamList = addDpGroupBmptParamList;
    }

    public String getParamJson() {
        return paramJson;
    }

    public void setParamJson(String paramJson) {
        this.paramJson = paramJson;
    }
}
