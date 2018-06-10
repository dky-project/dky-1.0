package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;

import java.util.Objects;


/**
 * Created by hang on 2017/1/10.
 */
public class CLDPView extends ResultObjectBase {

    private Long mProductId;

    private String groupNo;

    public CLDPView(Long mProductId, String groupNo) {
        this.mProductId = mProductId;
        this.groupNo = groupNo;
    }

    public Long getmProductId() {
        return mProductId;
    }

    public void setmProductId(Long mProductId) {
        this.mProductId = mProductId;
    }

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CLDPView cldpView = (CLDPView) o;
        return Objects.equals(mProductId, cldpView.mProductId) &&
                Objects.equals(groupNo, cldpView.groupNo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(mProductId, groupNo);
    }
}
