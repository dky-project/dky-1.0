package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.PdtBasepriceService;
import com.dky.business.repository.repository.PdtBasepriceMapper;
import com.dky.business.repository.repository.UsersMapper;
import com.dky.common.bean.SessionUser;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.PdtPriceView;
import com.dky.common.utils.DkyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wonpera on 2017/1/6.
 */
@Service
public class PdtBasepriceServiceImpl implements PdtBasepriceService {

    @Autowired
    private PdtBasepriceMapper mapper;
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public ReturnT<List<PdtPriceView>> queryPriceListByProductId(Long mProductId) {
        SessionUser user = DkyUtils.getCurrentUser();
        Map<String,String> userMap = usersMapper.getStoreCodeByEmail(user.getEmail());
        String code = userMap!=null?userMap.get("CODE"):user.getEmail();
        return new ReturnT<>().sucessData(mapper.queryPriceListByProductId(mProductId,code));
    }
}
