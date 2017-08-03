package com.dky.business.repository.repository;

import com.dky.common.param.BmptApproveQueryParam;
import com.dky.common.response.view.BmptApproveView;

import java.util.List;

@MyBatisRepository
public interface BmptApproveMapper {

    List<BmptApproveView> queryByPage(BmptApproveQueryParam bmptApprove);

    int count(BmptApproveQueryParam bmptApprove);
}