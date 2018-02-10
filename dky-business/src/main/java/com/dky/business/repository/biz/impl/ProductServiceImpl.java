package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.ProductService;
import com.dky.business.repository.repository.*;
import com.dky.common.bean.DpGroup;
import com.dky.common.bean.Product;
import com.dky.common.constats.GlobConts;
import com.dky.common.enums.IsActiveEnum;
import com.dky.common.param.*;
import com.dky.common.response.ImagePageList;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.*;
import com.dky.common.utils.PropertieUtils;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 样衣查询服务
 * Created by wangpeng on 2017/1/5.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductMapper mapper;
    @Autowired
    private PdtBasepriceMapper pdtBasepriceMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private DpGroupMapper dpGroupMapper;
    @Autowired
    private DimNewMapper dimNewMapper;


    @Override
    public ReturnT<ProductInfoView> getProductInfo(Long id) {
        ProductInfoView productInfoView = null;
        try {
            productInfoView = mapper.getProductInfo(id);
            if (productInfoView == null) {
                return new ReturnT<>().failureData("不存在该款号！");
            }
            String pdtPrice = pdtBasepriceMapper.getDhPrice(id);
            productInfoView.setPdtPrice(pdtPrice == null ? "" : pdtPrice);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return new ReturnT<>().failureData(e.getMessage());
        }
        return new ReturnT<>().sucessData(productInfoView);
    }

    @Override
    public ReturnT<PageList<ProductView>> findByPage(ProductQueryParam productQueryParam) {
        return new ReturnT<>().sucessData(findPage(productQueryParam));
    }

    @Override
    public ReturnT<PageList<ProductView>> findByPage(ProductQueryBaseParam productQueryParam) {
        return new ReturnT<>().sucessData(findPage(productQueryParam));
    }

    /**
     * 查询胸围、衣长、肩宽、袖长
     *
     * @param mProductId
     * @return
     */
    @Override
    public ReturnT<List<ProductValueView>> queryValueList(Long mProductId) {
        return new ReturnT<>().sucessData(mapper.queryValueList(mProductId));
    }

    private PageList<ProductView> findPage(ProductQueryParam productQueryParam) {
        Product product = new Product();
        BeanUtils.copyProperties(productQueryParam, product);
        Map<String,String> userMap = usersMapper.getStoreCodeByEmail(productQueryParam.getSessionUser().getEmail());
        product.setCode(userMap!=null?userMap.get("CODE"):productQueryParam.getSessionUser().getEmail());
        int count = 0;
        if (IsActiveEnum.YES.getCode().equals(productQueryParam.getIsRank())){
            count = mapper.rankCount(product);
        }else {
            count = mapper.count(product);
        }
        List<ProductView> list = mapper.queryByPage(product);
        for (ProductView view : list){
            if (view.getImgUrl1() != null){
                view.setBigImgUrl(GlobConts.IMAGE_ROOT_URL + view.getImgUrl1().replace("img", "img_sl") + "?modifieddate=" + view.getModifieddate().getTime());
                view.setImgUrl1(productQueryParam.getIsBuy().equals("Y")?view.getBigImgUrl().replace("img", "img_s2"):view.getBigImgUrl().replace("img", "img_sl"));
            }
        }
        return new PageList<ProductView>(list, count, productQueryParam.getPageNo(), productQueryParam.getPageSize());
    }
    private PageList<ProductView> findPage(ProductQueryBaseParam productQueryParam) {
        Product product = new Product();
        BeanUtils.copyProperties(productQueryParam, product);
        product.setCode("99999");
        return new PageList<ProductView>(mapper.queryByPage(product), mapper.count(product), productQueryParam.getPageNo(), productQueryParam.getPageSize());
    }

    @Override
    public ReturnT<ProductMadePageView> getMadeInfoByProductName(ProductMadeQueryParam param) {
        Product product = new Product();
        product.setName(param.getProductName());
        product = mapper.get(product);
        if (product == null) {
            return new ReturnT<>().failureData("没有查到该款号");
        }
        ProductMadePageView view = new ProductMadePageView();
        ProductMadeInfoView madeInfoView = new ProductMadeInfoView();
        //商品所属类别为大货
        if ("C".equals(product.getMptbelongtype())) {
            List<ProductColorView> colorList = mapper.getProductColorListByProductId(product.getId());
            List<ProductSizeView> sizeList = mapper.getProductSizeList(product.getId());
            view.setColorViewList(colorList);
            view.setSizeViewList(sizeList);
            //商品类别为基础款
        } else if ("A".equals(product.getMptbelongtype())) {
            madeInfoView = mapper.getMadeInfoByProductId(product.getId());
            if (madeInfoView == null) {
                return new ReturnT<>().failureData("没有查到该款号");
            }
            ProductCusmptcateView productCusmptcateView = mapper.getProductCusmptcateInfo(product.getId());
            view.setProductCusmptcateView(productCusmptcateView);
            List<ProductColorView> colorList = mapper.getProductColorListByDimId(madeInfoView.getmDimNew14Id());
            view.setColorViewList(colorList);
            view.setColorRangeViewList(dimNewMapper.getColorListByDimIdAndProductId(product.getId(),madeInfoView.getmDimNew14Id()));
        } else if ("B".equals(product.getMptbelongtype())){
            ProductCusmptcateView productCusmptcateView = mapper.getProductCusmptcateInfo(product.getId());
            view.setProductCusmptcateView(productCusmptcateView);
            madeInfoView = mapper.getMadeInfoByProductId(product.getId());
            if (madeInfoView == null) {
                return new ReturnT<>().failureData("没有查到该款号");
            }
            List<ProductColorView> colorList = mapper.getProductColorListByDimId(madeInfoView.getmDimNew14Id());
            view.setColorViewList(colorList);
            view.setColorRangeViewList(dimNewMapper.getColorListByDimIdAndProductId(product.getId(),madeInfoView.getmDimNew14Id()));
        }
        madeInfoView.setProductId(product.getId());
        madeInfoView.setMptbelongtype(product.getMptbelongtype());
        List<String> list = new ArrayList<>(3);
        list.add(PropertieUtils.getString("imageBosUrl") + "/pdt_imges/" + param.getProductName() + ".jpg");
        list.add(PropertieUtils.getString("imageBosUrl") + "/pdt_imges_1/" + param.getProductName() + ".jpg");
        list.add(PropertieUtils.getString("imageBosUrl") + "/pdt_imges_2/" + param.getProductName() + ".jpg");
        madeInfoView.setImgUrlList(list);
        madeInfoView.setImgUrl(PropertieUtils.getString("imageBosUrl") + "/pdt_imges/" + param.getProductName() + ".jpg");
        view.setProductMadeInfoView(madeInfoView);
        ReturnT<ProductMadePageView> result = new ReturnT<>();
        result.setData(view);
        return result.successDefault();
    }

    @Override
    public ReturnT<ColorSizeListView> getColorSizeList(ProductMadeQueryParam param) {
        Product product = new Product();
        product.setName(param.getProductName());
        product = mapper.get(product);
        if (product == null) {
            return new ReturnT<>().failureData("没有查到该款号");
        }
        List<ColorSizeView> list = mapper.getColorSizeList(param.getProductName());
        if (list.size() == 0){
            return new ReturnT<>().failureData("该款无可用尺寸颜色！");
        }
        List<ColorSizeView> colorList = new ArrayList<>();
        List<ColorSizeView> sizeList = new ArrayList<>();
        int index=0;
        while(index<list.size()) {
            if (distinct(list,index,Boolean.TRUE)){
                colorList.add(list.get(index));
            }
            if (distinct(list,index,Boolean.FALSE)){
                sizeList.add(list.get(index));
            }
            index ++;
        }
        ReturnT<ColorSizeListView> result = new ReturnT<>();
        ColorSizeListView resultView = new ColorSizeListView();
        resultView.setColorList(colorList);
        resultView.setSizeList(sizeList);
        resultView.setmProductId(product.getId());
        resultView.setImgUrl(mapper.getProductImgUrl(product.getId()));
        result.setData(resultView);
        return result.successDefault();
    }

    public boolean distinct(List<ColorSizeView> list,int index,boolean colorOrSize){
        boolean isSame = true;
        for(int i=index+1;i<list.size();i++){
            if (list.get(i).getValue1Code().equals(list.get(index).getValue1Code()) && colorOrSize){
                isSame =  false;
                break;
            }
            if (list.get(i).getValue().equals(list.get(index).getValue()) && !colorOrSize){
                isSame = false;
                break;
            }
        }
        return isSame;
    }

    @Override
    public ReturnT getProductListByGroupNo(DpGroupQueryParam param) {
        if ("".equals(param.getGroupNo()) || param.getGroupNo()== null){
            return  new ReturnT().failureData("组号不能为空！");
        }
        param.setPageNo(1);
        param.setPageSize(1);
        param.calculatePageLimit();
        List<DpGroup> dGroupList = dpGroupMapper.selectByGroupNo(param.getGroupNo(), param.getRequestCount(), param.getRequestOffset());
        if (dGroupList.size() == 0){
            return new ReturnT<>().failureData("无数据！");
        }
        DpGroup dpGroup = dGroupList.get(0);
        List<Long> ids = new ArrayList<>();
        ids.add(dpGroup.getSyProductId());
        ids.add(dpGroup.getWtProductId());
        ids.add(dpGroup.getXzProductId());
        ids.add(dpGroup.getYdProductId());
        ids.add(dpGroup.getShoesProductId());
        ids.add(dpGroup.getSpProductId());
        ids.add(dpGroup.getBaoProductId());
        ids.add(dpGroup.getWjProductId());
        List<Long> e = new ArrayList<>(1);
        e.add(null);
        ids.removeAll(e);

        Map<String,String> userMap = usersMapper.getStoreCodeByEmail(param.getSessionUser().getEmail());
        String code = userMap!=null?userMap.get("CODE"):param.getSessionUser().getEmail();
        List<DpGroupView> list = mapper.getProductListByIds(ids,code);
        for (DpGroupView view : list){
            if ("C".equals(view.getMptbelongtype())){
                view.setColorViewList(mapper.getProductColorListByProductId(view.getmProductId()));
                view.setSizeViewList(mapper.getProductSizeList(view.getmProductId()));
                view.setPrice(mapper.getMpdtProductPrice(view.getmProductId()));
            }else{
                view.setColorViewList(dimNewMapper.getColorListByDimIdAndProductId(view.getmProductId(),view.getmDimNew14Id()));
                Map<String,Object> map = new HashedMap();
                map.put("V_PZ",view.getmDimNew14Id());
                map.put("V_ZX",view.getmDimNew16Id());
                map.put("V_XW_VALUE",view.getXwValue());
                map.put("V_XC_VALUE",view.getXcValue());
                map.put("V_YC_VALUE1",view.getYcValue());
                map.put("V_JGNO",code);
                map.put("V_PDT",view.getProductName());
                mapper.getProductPrice(map);
                BigDecimal price = new BigDecimal(map.get("v_price_out").toString());
                view.setPrice(price);
            }
        }
        ImagePageList page = new ImagePageList(list,dpGroupMapper.count(param.getGroupNo()),param.getPageNo(),param.getPageSize());
        page.setBigImageUrl(GlobConts.IMAGE_ROOT_URL+"/DP/"+param.getGroupNo()+".jpg?random="+ new Random().nextInt(100));
        return new ReturnT<>().sucessData(page);
    }

    @Override
    public ReturnT getProductListByGh(ClGroupQueryParam param) {
        if ("".equals(param.getGh()) || param.getGh()== null){
            return new ReturnT().failureData("杆号不能为空！");
        }
        param.setPageNo(1);
        param.setPageSize(1);
        param.calculatePageLimit();
        List<ClGroupView> dpList = dpGroupMapper.selectByGh(param.getGh(),param.getRequestCount(),param.getRequestOffset());
        if (dpList.size() == 0){
            return new ReturnT<>().failureData("无数据！");
        }
        ClGroupView clGroupView = dpList.get(0);
        List<Long> ids = new ArrayList<>();
        ids.add(clGroupView.getNo1ProductId());
        ids.add(clGroupView.getNo2ProductId());
        ids.add(clGroupView.getNo3ProductId());
        ids.add(clGroupView.getNo4ProductId());
        ids.add(clGroupView.getNo5ProductId());
        ids.add(clGroupView.getNo6ProductId());
        ids.add(clGroupView.getNo7ProductId());
        ids.add(clGroupView.getNo8ProductId());
        ids.add(clGroupView.getNo9ProductId());
        ids.add(clGroupView.getNo10ProductId());
        ids.add(clGroupView.getNo11ProductId());
        ids.add(clGroupView.getNo12ProductId());
        ids.add(clGroupView.getNo13ProductId());
        ids.add(clGroupView.getNo14ProductId());
        ids.add(clGroupView.getNo15ProductId());
        List<Long> e = new ArrayList<>(1);
        e.add(null);
        ids.removeAll(e);
        Map<String,String> userMap = usersMapper.getStoreCodeByEmail(param.getSessionUser().getEmail());
        String code = userMap!=null?userMap.get("CODE"):param.getSessionUser().getEmail();
        List<ClGroupResultView> list = mapper.getClProductListByIds(ids,code);
        ImagePageList page = new ImagePageList(list,dpGroupMapper.clCount(param.getGh()),param.getPageNo(),param.getPageSize());
        page.setBigImageUrl(GlobConts.IMAGE_ROOT_URL+"/CL/"+param.getGh()+".jpg?random="+ new Random().nextInt(100));
        return new ReturnT<>().sucessData(page);
    }

    @Override
    public ReturnT getProductGroupPage(DpGroupQueryParam param) {
        return new ReturnT().sucessData(new PageList<DpGroup>(dpGroupMapper.selectByGroupNo(param.getGroupNo(), param.getRequestCount(), param.getRequestOffset()), dpGroupMapper.count(param.getGroupNo()), param.getPageNo(), param.getPageSize()));
    }

    @Override
    public ReturnT getProductListGhPage(ClGroupQueryParam param) {
        return new ReturnT().sucessData(new PageList<ClGroupView>(dpGroupMapper.selectByGh(param.getGh(), param.getRequestCount(), param.getRequestOffset()), dpGroupMapper.clCount(param.getGh()), param.getPageNo(), param.getPageSize()));
    }
}
