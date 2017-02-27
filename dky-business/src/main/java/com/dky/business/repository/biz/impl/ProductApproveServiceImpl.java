package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.ProductApproveService;
import com.dky.business.repository.repository.ProductApproveMapper;
import com.dky.business.repository.repository.UsersMapper;
import com.dky.common.bean.ProductApprove;
import com.dky.common.param.ProductApproveQueryParam;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.ProductApproveInfoView;
import com.dky.common.response.view.ProductApproveView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wonpera on 2017/1/6.
 */
@Service
public class ProductApproveServiceImpl implements ProductApproveService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductApproveServiceImpl.class);

    @Autowired
    private ProductApproveMapper mapper;
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public ReturnT<PageList<ProductApproveView>> findByPage(ProductApproveQueryParam param) {
        String email = param.getSessionUser().getEmail();
        ProductApprove approve = new ProductApprove();
        Map<String,String> map = usersMapper.getStoreCodeByEmail(email);
        BeanUtils.copyProperties(param,approve);
        approve.setJgno(map.get("CODE"));
        return new ReturnT<>().sucessData(findPage(approve));
    }

    @Override
    public ReturnT<List<ProductApproveInfoView>> queryProductApproveInfoList(Long[] ids) {
        return new ReturnT<>().sucessData(mapper.queryProductApproveInfoList(ids));
    }

    private PageList<ProductApproveView> findPage(ProductApprove approve){
        return new PageList<ProductApproveView>(
                mapper.queryByPage(approve),mapper.count(approve),
                approve.getPageNo(),approve.getPageSize());
    }

    @Override
    public ReturnT insertProductApprove() {
        return null;
    }

    @Override
    public ReturnT updateProductApprove() {
        return null;
    }
}
