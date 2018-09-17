package com.dky.business.repository.biz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dky.business.repository.biz.ProductService;
import com.dky.business.repository.repository.*;
import com.dky.common.bean.DpGroup;
import com.dky.common.bean.Product;
import com.dky.common.constats.GlobConts;
import com.dky.common.enums.DimFlagEnum;
import com.dky.common.enums.IsActiveEnum;
import com.dky.common.enums.VesionEnum;
import com.dky.common.param.*;
import com.dky.common.response.ImagePageList;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import com.dky.common.response.view.*;
import com.dky.common.utils.ConverImagePathUtils;
import com.dky.common.utils.PropertieUtils;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

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
    public ReturnT<ProductInfoView> getProductInfo(Long id,String isBuy) {
        ProductInfoView productInfoView = null;
        try {
            productInfoView = mapper.getProductInfo(id);
            if (productInfoView == null) {
                return new ReturnT<>().failureData("不存在该款号！");
            }
            String pdtPrice = pdtBasepriceMapper.getDhPrice(id);
            productInfoView.setPdtPrice(pdtPrice == null ? "" : pdtPrice);
            ConverImagePathUtils.convertProductView(productInfoView,isBuy);
            if (productInfoView.getDlValue() != null && "DH".equals(productInfoView.getDlValue())){
                productInfoView.setSizeList(mapper.getSizeList(id));
            }else {
                List<ProductGwView> list = mapper.getColorGwList(id);
                if (list.size() > 1) {
                    return new ReturnT<>().failureData("重复杆位管理！");
                }
                if (list.size() > 0){
                    productInfoView.setGwView(list.get(0));
                }
            }
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
                String url = GlobConts.IMAGE_ROOT_URL + view.getImgUrl1().replace("#","")+ "?modifieddate=" + view.getModifieddate().getTime();
                String imgurl = productQueryParam.getIsBuy().equals("Y")?url.replace("img", "img_s2"):url.replace("img", "img_sl");
                view.setBigImgUrl(url);
                view.setImgUrl1(imgurl);
            }
        }
        return new PageList<>(list, count, productQueryParam.getPageNo(), productQueryParam.getPageSize());
    }
    private PageList<ProductView> findPage(ProductQueryBaseParam productQueryParam) {
        Product product = new Product();
        BeanUtils.copyProperties(productQueryParam, product);
        product.setCode("99999");
        List<ProductView> list = mapper.queryByPage(product);
        for (ProductView view : list){
            if (view.getImgUrl1() != null){
                view.setBigImgUrl(GlobConts.IMAGE_ROOT_URL + view.getImgUrl1()+ "?modifieddate=" + view.getModifieddate().getTime());
            }
        }
        return new PageList<>(list, mapper.count(product), productQueryParam.getPageNo(), productQueryParam.getPageSize());
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
            List<ProductColorView> rangeList = dimNewMapper.getColorListByDimIdAndProductId(product.getId(), madeInfoView.getmDimNew14Id());
            String colorName = dimNewMapper.getColorRangeDefault(product.getId(), madeInfoView.getmDimNew14Id());
            for (ProductColorView rangeView : rangeList){
                if (rangeView.getColorName().equals(colorName)){
                    rangeView.setIsDefault("Y");
                }
            }
            view.setColorRangeViewList(rangeList);
        } else if ("B".equals(product.getMptbelongtype())){
            ProductCusmptcateView productCusmptcateView = mapper.getProductCusmptcateInfo(product.getId());
            view.setProductCusmptcateView(productCusmptcateView);
            madeInfoView = mapper.getMadeInfoByProductId(product.getId());
            if (madeInfoView == null) {
                return new ReturnT<>().failureData("没有查到该款号");
            }
            List<ProductColorView> colorList = mapper.getProductColorListByDimId(madeInfoView.getmDimNew14Id());
            view.setColorViewList(colorList);
            List<ProductColorView> rangeList = dimNewMapper.getColorListByDimIdAndProductId(product.getId(), madeInfoView.getmDimNew14Id());
            String colorName = dimNewMapper.getColorRangeDefault(product.getId(), madeInfoView.getmDimNew14Id());
            for (ProductColorView rangeView : rangeList){
                if (rangeView.getColorName().equals(colorName)){
                    rangeView.setIsDefault("Y");
                }
            }
            view.setColorRangeViewList(rangeList);
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
        resultView.setImgUrl(GlobConts.IMAGE_ROOT_URL+"/img_pad/"+product.getName()+".jpg?random="+new Random().nextInt(100));
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
            return new ReturnT<>().failureData("无数据!");
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
        if (ids.size() == 0){
            return new ReturnT().failureData(param.getGroupNo()+"没有搭配！");
        }
        List<DimNewView> dimList = dimNewMapper.queryDimByDimText(DimFlagEnum.PIN_FLAG.getCode());
        JSONArray jsonArray = new JSONArray();
        if (dimList.size() > 0){
            for (DimNewView dim : dimList){
                jsonArray.add(dim);
            }
        }
        Map<String,String> userMap = usersMapper.getStoreCodeByEmail(param.getSessionUser().getEmail());
        String code = userMap!=null?userMap.get("CODE"):param.getSessionUser().getEmail();
        List<DpGroupView> list = mapper.getProductListByIds(ids,code,param.getGroupNo());
        for (DpGroupView view : list){
            view.setPinList(jsonArray);
            if ("C".equals(view.getMptbelongtype())){
                view.setColorViewList(mapper.getProductColorListByProductId(view.getmProductId()));
                view.setSizeViewList(mapper.getProductSizeList(view.getmProductId()));
                view.setPrice(mapper.getMpdtProductPrice(view.getmProductId()));
            }else{
                view.setColorViewList(mapper.getProductColorListByDimId(view.getmDimNew14Id()));
                List<ProductColorView> rangeList = dimNewMapper.getColorListByDimIdAndProductId(view.getmProductId(),view.getmDimNew14Id());
                String colorName = dimNewMapper.getColorDefaultByGroupNo(param.getGroupNo(), view.getmProductId(),view.getmDimNew14Id());
                for (ProductColorView colorView : rangeList){
                    if (colorView.getColorName().equals(colorName)){
                        colorView.setIsDefault("Y");
                    }
                }
                view.setColorRangeViewList(rangeList);
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
                view.setOrderNum(ids.indexOf(view.getmProductId()));
            }
        }
        Collections.sort(list, new Comparator<DpGroupView>() {
            @Override
            public int compare(DpGroupView o1, DpGroupView o2) {
                return o1.getOrderNum() - o2.getOrderNum();
            }
        });
        ImagePageList page = new ImagePageList(list,dpGroupMapper.count(param.getGroupNo()),param.getPageNo(),param.getPageSize());
        page.setBigImageUrl(GlobConts.IMAGE_ROOT_URL+"/DP/"+param.getGroupNo()+".jpg?random="+ new Random().nextInt(100));
        page.setGroupNoList(dpGroupMapper.getGroupNoList());
        return new ReturnT<>().sucessData(page);
    }

    @Override
    public ReturnT getProductListByGh(ClGroupQueryParam param) {
        param.setHallName(null);
        if ("".equals(param.getGh()) || param.getGh()== null){
            return new ReturnT().failureData("杆号不能为空！");
        }
        param.setPageNo(1);
        param.setPageSize(1);
        param.calculatePageLimit();
        List<ClGroupView> dpList = dpGroupMapper.selectByGh(param);
        if (dpList.size() == 0){
            return new ReturnT<>().failureData("无数据！");
        }
        ClGroupView clGroupView = dpList.get(0);
        List<ClGroupResultView> list = new ArrayList<>();
        if (!"".equals(clGroupView.getGroupNo1()) && null != clGroupView.getGroupNo1()){
            list.add(new ClGroupResultView(clGroupView.getGroupNo1()));
        }
        if (!"".equals(clGroupView.getGroupNo2()) && null != clGroupView.getGroupNo2()){
            list.add(new ClGroupResultView(clGroupView.getGroupNo2()));
        }
        if (!"".equals(clGroupView.getGroupNo3()) && null != clGroupView.getGroupNo3()){
            list.add(new ClGroupResultView(clGroupView.getGroupNo3()));
        }
        if (!"".equals(clGroupView.getGroupNo4()) && null != clGroupView.getGroupNo4()){
            list.add(new ClGroupResultView(clGroupView.getGroupNo4()));
        }
        if (!"".equals(clGroupView.getGroupNo5()) && null != clGroupView.getGroupNo5()){
            list.add(new ClGroupResultView(clGroupView.getGroupNo5()));
        }
        if (!"".equals(clGroupView.getGroupNo6()) && null != clGroupView.getGroupNo6()){
            list.add(new ClGroupResultView(clGroupView.getGroupNo6()));
        }

        List<ClGroupResultView> returnList = new ArrayList<>();
        for (ClGroupResultView view : list){
            int count = dpGroupMapper.countByDefault(view.getGroupNo(),"N");
            if (count == 0){
                returnList.add(view);
            }
        }
        ImagePageList page = new ImagePageList(returnList,dpGroupMapper.clCount(param));
        page.setBigImageUrl(GlobConts.IMAGE_ROOT_URL+"/CL/"+param.getGh()+".jpg?random="+ new Random().nextInt(100));
        page.setGhList(dpGroupMapper.getGhList());
        return new ReturnT<>().sucessData(page);
    }

    @Override
    public ReturnT getProductGroupPage(DpGroupQueryParam param) {
        return new ReturnT().sucessData(new PageList<>(dpGroupMapper.selectByGroupNo(param.getGroupNo(), param.getRequestCount(), param.getRequestOffset()), dpGroupMapper.count(param.getGroupNo()), param.getPageNo(), param.getPageSize()));
    }

    @Override
    public ReturnT getProductListGhPage(ClGroupQueryParam param) {
        if (param.getVersion().equals(VesionEnum.JM_ORDER.getCode()) || param.getVersion().equals(VesionEnum.JM_ORDER.getCode())) {
            param.setAttribname(param.getHallName());
            param.setHallName(null);
        }
        return new ReturnT().sucessData(new PageList<>(dpGroupMapper.selectByGh(param), dpGroupMapper.clCount(param)));

    }
}
