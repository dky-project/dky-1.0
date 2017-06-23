package com.dky.common.response.view;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dky.common.response.ResultObjectBase;

/**
 * Created by hang on 2017/1/4 0004.
 * @decription 组织、针型、支别json列表
 */
public class PzJsonResultView extends ResultObjectBase {

    /**
     * 组织
     */
    private JSONArray zzJson;
    /**
     * 针型
     */
    private JSONArray zxJson;
    /**
     * 支别
     */
    private JSONArray zbJson;

    public JSONArray getZzJson() {
        return zzJson;
    }

    public void setZzJson(String zzJson) {
        this.zzJson = JSONObject.parseArray(zzJson);
    }

    public JSONArray getZxJson() {
        return zxJson;
    }

    public void setZxJson(String zxJson) {
        this.zxJson = JSONObject.parseArray(zxJson);
    }

    public JSONArray getZbJson() {
        return zbJson;
    }

    public void setZbJson(String zbJson) {
        this.zbJson = JSONObject.parseArray(zbJson);
    }
}
