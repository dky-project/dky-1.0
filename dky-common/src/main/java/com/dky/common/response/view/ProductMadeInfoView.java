package com.dky.common.response.view;

import com.dky.common.response.ResultObjectBase;

/**
 * Created by hang on 2017/1/4 0004.
 * @decription 所有结尾是Show的字段都是以逗号分隔的字符串，进行截取返回给客户端的都是字符串数组
 */
public class ProductMadeInfoView extends ResultObjectBase {

    /**
     * 款号ID
     */
    private Long productId;
    /**
     * 商品所属类别
     */
    private String mptbelongtype;
    /**
     * 性别
     */
    private Long mDimNew13Id;
    /**
     * 抽条
     */
    private String ct;
    /**
     * 抽条1
     */
    private String ct1;
    /**
     * 品种
     */
    private Long mDimNew14Id;
    /**
     * 组织
     */
    private Long mDimNew15Id;
    /**
     * 针型
     */
    private Long mDimNew16Id;
    /**
     * 支别
     */
    private Long mDimNew17Id;
    /**
     * 式样
     */
    private Long mDimNew12Id;
    /**
     * 挂件袖肥
     */
    private Long mDimNew18Id;
    /**
     * 袖边
     */
    private Long mDimNew45Id;
    /**
     * 袖边cm
     */
    private String xbcValue;
    /**
     * 收腰
     */
    private Long mDimNew19Id;
    /**
     * 肩型
     */
    private Long mDimNew22Id;
    /**
     * 袖型
     */
    private Long mDimNew9Id;
    /**
     * 袖型2
     */
    private Long mDimNew9Id2;
    /**
     * 袖型3
     */
    private Long mDimNew9Id3;
    /**
     * 其他备注
     */
    private String qtxRemark;
    /**
     * 其他备注2
     */
    private String qtxRemark2;
    /**
     * 其他备注3
     */
    private String qtxRemark3;
    /**
     * 领边
     */
    private Long mDimNew26Id;
    /**
     * 其他领边
     */
    private String lbqt;
    /**
     * 领边层
     */
    private Long mDimNew28Id;
    /**
     * 领型
     */
    private Long mDimNew25Id;
    /**
     * 下边
     */
    private Long mDimNew10Id;
    /**
     * 下边cm
     */
    private Long xbccValue;
    /**
     * 其他下边
     */
    private String xbRemark;
    /**
     * 袖口
     */
    private Long mDimNew32Id;
    /**
     * 配套
     */
    private Long mDimNew41Id;
    /**
     * 袖边组织
     */
    private Long mDimNew46Id;
    /**
     * 钉扣
     */
    private Long mDimNew4Id;
    /**
     * 门襟
     */
    private Long mDimNew6Id;
    /**
     * 门襟组织
     */
    private Long mDimNew7Id;
    /**
     * 加穗
     */
    private Long mDimNew37Id;
    /**
     * 裤类别
     */
    private Long mDimNew38Id;
    /**
     * 开口
     */
    private Long mDimNew39Id;
    /**
     * 加档
     */
    private Long mDimNew1Id;
    /**
     * 裙类别
     */
    private Long mDimNew3Id;
    /**
     * 领边尺寸
     */
    private String lbccValue;
    /**
     * 花型
     */
    private String[] hxShow;
    /**
     * 领：完全（领下拉框内的值）
     */
    private String lwqt;
    /**
     * 领:领边（领下拉框内的值）
     */
    private String lbt;
    /**
     * 领:领型（领下拉框内的值）
     */
    private String lxt;
    /**
     * 口袋（其他）
     */
    private String qtkdRemark;
    /**
     * 附件（其他）
     */
    private String qtfjRemark;
    /**
     * 特殊工艺（其他）
     */
    private String qttsgyRemark;
    /**
     * 粒扣后面的备注
     */
    private String lxRemark;
    /**
     * 加注
     */
    private String jzValue;
    /**
     * 领型下拉框后面的文本框
     */
    private String dkslValue;
    /**
     * 门襟宽
     */
    private String mjkValue;
    /**
     * 带长
     */
    private String dc1Value;
    /**
     * 工艺袖长
     */
    private String hzxcValue;
    /**
     * 门襟长
     */
    private String mjcValue;
    /**
     * 尺寸：大
     * 请选择胸围
     */
    private String xwValue;
    /**
     * 烫珠（勾选框列表）
     */
    private String[] tzShow;
    /**
     * 烫珠勾选框后面俩个文本框的第二个文本框值
     */
    private String tzRemark;
    /**
     * 绣花勾选框后面俩个文本框的第一个文本框值
     */
    private String tzRemark1;
    /**
     * 串珠勾选框后面俩个文本框的第一个文本框值
     */
    private String tzRemark2;
    /**
     * 口袋（勾选框列表）
     */
    private String[] kdShow;
    /**
     * 附件（勾选框列表）
     */
    private String[] fjShow;
    /**
     * 特殊工艺（勾选框列表）
     */
    private String[] tsgyShow;
    /**
     * 袖口下拉框后面的文本框
     */
    private String xkRemark;
    /**
     * 下边下拉框后面的文本框
     */
    private String xxbRemark;
    /**
     * 钉[文本框]#扣
     */
    private String dkValue;
    /**
     * 实际袖长上面：长[文本框]
     */
    private String ycValue;
    /**
     * 肩宽cm
     */
    private String jkValue;
    /**
     * 袖长cm
     */
    private String xcValue;
    /**
     * 袖口cm
     */
    private String xkccValue;
    /**
     * 尺寸类型
     */
    private String sizeType;
    /**
     * 颜色（以逗号分隔的字符串）
     */
    private String clrRange;
    /**
     * 粒扣 备注
     */
    private String qtlRemark;
    /**
     * 品种json字符串
     */
    private String pzJsonstr;
    /**
     * 组织json字符串
     */
    private String zzJsonstr;
    /**
     * 针型json字符串
     */
    private String zxJsonstr;
    /**
     * 支别json字符串
     */
    private String zbJsonstr;
    /**
     * 图片地址
     */
    private String imgUrl;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getMptbelongtype() {
        return mptbelongtype;
    }

    public void setMptbelongtype(String mptbelongtype) {
        this.mptbelongtype = mptbelongtype;
    }

    public Long getmDimNew13Id() {
        return mDimNew13Id;
    }

    public void setmDimNew13Id(Long mDimNew13Id) {
        this.mDimNew13Id = mDimNew13Id;
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public String getCt1() {
        return ct1;
    }

    public void setCt1(String ct1) {
        this.ct1 = ct1;
    }

    public Long getmDimNew14Id() {
        return mDimNew14Id;
    }

    public void setmDimNew14Id(Long mDimNew14Id) {
        this.mDimNew14Id = mDimNew14Id;
    }

    public Long getmDimNew15Id() {
        return mDimNew15Id;
    }

    public void setmDimNew15Id(Long mDimNew15Id) {
        this.mDimNew15Id = mDimNew15Id;
    }

    public Long getmDimNew16Id() {
        return mDimNew16Id;
    }

    public void setmDimNew16Id(Long mDimNew16Id) {
        this.mDimNew16Id = mDimNew16Id;
    }

    public Long getmDimNew17Id() {
        return mDimNew17Id;
    }

    public void setmDimNew17Id(Long mDimNew17Id) {
        this.mDimNew17Id = mDimNew17Id;
    }

    public Long getmDimNew12Id() {
        return mDimNew12Id;
    }

    public void setmDimNew12Id(Long mDimNew12Id) {
        this.mDimNew12Id = mDimNew12Id;
    }

    public Long getmDimNew18Id() {
        return mDimNew18Id;
    }

    public void setmDimNew18Id(Long mDimNew18Id) {
        this.mDimNew18Id = mDimNew18Id;
    }

    public Long getmDimNew45Id() {
        return mDimNew45Id;
    }

    public void setmDimNew45Id(Long mDimNew45Id) {
        this.mDimNew45Id = mDimNew45Id;
    }

    public String getXbcValue() {
        return xbcValue;
    }

    public void setXbcValue(String xbcValue) {
        this.xbcValue = xbcValue;
    }

    public Long getmDimNew19Id() {
        return mDimNew19Id;
    }

    public void setmDimNew19Id(Long mDimNew19Id) {
        this.mDimNew19Id = mDimNew19Id;
    }

    public Long getmDimNew22Id() {
        return mDimNew22Id;
    }

    public void setmDimNew22Id(Long mDimNew22Id) {
        this.mDimNew22Id = mDimNew22Id;
    }

    public Long getmDimNew9Id() {
        return mDimNew9Id;
    }

    public void setmDimNew9Id(Long mDimNew9Id) {
        this.mDimNew9Id = mDimNew9Id;
    }

    public Long getmDimNew9Id2() {
        return mDimNew9Id2;
    }

    public void setmDimNew9Id2(Long mDimNew9Id2) {
        this.mDimNew9Id2 = mDimNew9Id2;
    }

    public Long getmDimNew9Id3() {
        return mDimNew9Id3;
    }

    public void setmDimNew9Id3(Long mDimNew9Id3) {
        this.mDimNew9Id3 = mDimNew9Id3;
    }

    public String getQtxRemark() {
        return qtxRemark;
    }

    public void setQtxRemark(String qtxRemark) {
        this.qtxRemark = qtxRemark;
    }

    public String getQtxRemark2() {
        return qtxRemark2;
    }

    public void setQtxRemark2(String qtxRemark2) {
        this.qtxRemark2 = qtxRemark2;
    }

    public String getQtxRemark3() {
        return qtxRemark3;
    }

    public void setQtxRemark3(String qtxRemark3) {
        this.qtxRemark3 = qtxRemark3;
    }

    public Long getmDimNew26Id() {
        return mDimNew26Id;
    }

    public void setmDimNew26Id(Long mDimNew26Id) {
        this.mDimNew26Id = mDimNew26Id;
    }

    public String getLbqt() {
        return lbqt;
    }

    public void setLbqt(String lbqt) {
        this.lbqt = lbqt;
    }

    public Long getmDimNew28Id() {
        return mDimNew28Id;
    }

    public void setmDimNew28Id(Long mDimNew28Id) {
        this.mDimNew28Id = mDimNew28Id;
    }

    public Long getmDimNew25Id() {
        return mDimNew25Id;
    }

    public void setmDimNew25Id(Long mDimNew25Id) {
        this.mDimNew25Id = mDimNew25Id;
    }

    public Long getmDimNew10Id() {
        return mDimNew10Id;
    }

    public void setmDimNew10Id(Long mDimNew10Id) {
        this.mDimNew10Id = mDimNew10Id;
    }

    public Long getXbccValue() {
        return xbccValue;
    }

    public void setXbccValue(Long xbccValue) {
        this.xbccValue = xbccValue;
    }

    public String getXbRemark() {
        return xbRemark;
    }

    public void setXbRemark(String xbRemark) {
        this.xbRemark = xbRemark;
    }

    public Long getmDimNew32Id() {
        return mDimNew32Id;
    }

    public void setmDimNew32Id(Long mDimNew32Id) {
        this.mDimNew32Id = mDimNew32Id;
    }

    public Long getmDimNew41Id() {
        return mDimNew41Id;
    }

    public void setmDimNew41Id(Long mDimNew41Id) {
        this.mDimNew41Id = mDimNew41Id;
    }

    public Long getmDimNew46Id() {
        return mDimNew46Id;
    }

    public void setmDimNew46Id(Long mDimNew46Id) {
        this.mDimNew46Id = mDimNew46Id;
    }

    public Long getmDimNew4Id() {
        return mDimNew4Id;
    }

    public void setmDimNew4Id(Long mDimNew4Id) {
        this.mDimNew4Id = mDimNew4Id;
    }

    public Long getmDimNew6Id() {
        return mDimNew6Id;
    }

    public void setmDimNew6Id(Long mDimNew6Id) {
        this.mDimNew6Id = mDimNew6Id;
    }

    public Long getmDimNew7Id() {
        return mDimNew7Id;
    }

    public void setmDimNew7Id(Long mDimNew7Id) {
        this.mDimNew7Id = mDimNew7Id;
    }

    public Long getmDimNew37Id() {
        return mDimNew37Id;
    }

    public void setmDimNew37Id(Long mDimNew37Id) {
        this.mDimNew37Id = mDimNew37Id;
    }

    public Long getmDimNew38Id() {
        return mDimNew38Id;
    }

    public void setmDimNew38Id(Long mDimNew38Id) {
        this.mDimNew38Id = mDimNew38Id;
    }

    public Long getmDimNew39Id() {
        return mDimNew39Id;
    }

    public void setmDimNew39Id(Long mDimNew39Id) {
        this.mDimNew39Id = mDimNew39Id;
    }

    public Long getmDimNew1Id() {
        return mDimNew1Id;
    }

    public void setmDimNew1Id(Long mDimNew1Id) {
        this.mDimNew1Id = mDimNew1Id;
    }

    public Long getmDimNew3Id() {
        return mDimNew3Id;
    }

    public void setmDimNew3Id(Long mDimNew3Id) {
        this.mDimNew3Id = mDimNew3Id;
    }

    public String getLbccValue() {
        return lbccValue;
    }

    public void setLbccValue(String lbccValue) {
        this.lbccValue = lbccValue;
    }

    public String[] getHxShow() {
        return hxShow;
    }

    public void setHxShow(String hxShow) {
        this.hxShow = hxShow.split(",");
    }

    public String getLwqt() {
        return lwqt;
    }

    public void setLwqt(String lwqt) {
        this.lwqt = lwqt;
    }

    public String getLbt() {
        return lbt;
    }

    public void setLbt(String lbt) {
        this.lbt = lbt;
    }

    public String getLxt() {
        return lxt;
    }

    public void setLxt(String lxt) {
        this.lxt = lxt;
    }

    public String getQtkdRemark() {
        return qtkdRemark;
    }

    public void setQtkdRemark(String qtkdRemark) {
        this.qtkdRemark = qtkdRemark;
    }

    public String getQtfjRemark() {
        return qtfjRemark;
    }

    public void setQtfjRemark(String qtfjRemark) {
        this.qtfjRemark = qtfjRemark;
    }

    public String getQttsgyRemark() {
        return qttsgyRemark;
    }

    public void setQttsgyRemark(String qttsgyRemark) {
        this.qttsgyRemark = qttsgyRemark;
    }

    public String getLxRemark() {
        return lxRemark;
    }

    public void setLxRemark(String lxRemark) {
        this.lxRemark = lxRemark;
    }

    public String getJzValue() {
        return jzValue;
    }

    public void setJzValue(String jzValue) {
        this.jzValue = jzValue;
    }

    public String getDkslValue() {
        return dkslValue;
    }

    public void setDkslValue(String dkslValue) {
        this.dkslValue = dkslValue;
    }

    public String getMjkValue() {
        return mjkValue;
    }

    public void setMjkValue(String mjkValue) {
        this.mjkValue = mjkValue;
    }

    public String getDc1Value() {
        return dc1Value;
    }

    public void setDc1Value(String dc1Value) {
        this.dc1Value = dc1Value;
    }

    public String getHzxcValue() {
        return hzxcValue;
    }

    public void setHzxcValue(String hzxcValue) {
        this.hzxcValue = hzxcValue;
    }

    public String getMjcValue() {
        return mjcValue;
    }

    public void setMjcValue(String mjcValue) {
        this.mjcValue = mjcValue;
    }

    public String getXwValue() {
        return xwValue;
    }

    public void setXwValue(String xwValue) {
        this.xwValue = xwValue;
    }

    public String[] getTzShow() {
        return tzShow;
    }

    public void setTzShow(String tzShow) {
        this.tzShow = tzShow.split(",");
    }

    public String getTzRemark() {
        return tzRemark;
    }

    public void setTzRemark(String tzRemark) {
        this.tzRemark = tzRemark;
    }

    public String getTzRemark1() {
        return tzRemark1;
    }

    public void setTzRemark1(String tzRemark1) {
        this.tzRemark1 = tzRemark1;
    }

    public String getTzRemark2() {
        return tzRemark2;
    }

    public void setTzRemark2(String tzRemark2) {
        this.tzRemark2 = tzRemark2;
    }

    public String[] getKdShow() {
        return kdShow;
    }

    public void setKdShow(String kdShow) {
        this.kdShow = kdShow.split(",");
    }

    public String[] getFjShow() {
        return fjShow;
    }

    public void setFjShow(String fjShow) {
        this.fjShow = fjShow.split(",");
    }

    public String[] getTsgyShow() {
        return tsgyShow;
    }

    public void setTsgyShow(String tsgyShow) {
        this.tsgyShow = tsgyShow.split(",");
    }

    public String getXkRemark() {
        return xkRemark;
    }

    public void setXkRemark(String xkRemark) {
        this.xkRemark = xkRemark;
    }

    public String getXxbRemark() {
        return xxbRemark;
    }

    public void setXxbRemark(String xxbRemark) {
        this.xxbRemark = xxbRemark;
    }

    public String getDkValue() {
        return dkValue;
    }

    public void setDkValue(String dkValue) {
        this.dkValue = dkValue;
    }

    public String getYcValue() {
        return ycValue;
    }

    public void setYcValue(String ycValue) {
        this.ycValue = ycValue;
    }

    public String getJkValue() {
        return jkValue;
    }

    public void setJkValue(String jkValue) {
        this.jkValue = jkValue;
    }

    public String getXcValue() {
        return xcValue;
    }

    public void setXcValue(String xcValue) {
        this.xcValue = xcValue;
    }

    public String getXkccValue() {
        return xkccValue;
    }

    public void setXkccValue(String xkccValue) {
        this.xkccValue = xkccValue;
    }

    public String getSizeType() {
        return sizeType;
    }

    public void setSizeType(String sizeType) {
        this.sizeType = sizeType;
    }

    public String getClrRange() {
        return clrRange;
    }

    public void setClrRange(String clrRange) {
        this.clrRange = clrRange;
    }

    public String getQtlRemark() {
        return qtlRemark;
    }

    public void setQtlRemark(String qtlRemark) {
        this.qtlRemark = qtlRemark;
    }

    public String getPzJsonstr() {
        return pzJsonstr;
    }

    public void setPzJsonstr(String pzJsonstr) {
        this.pzJsonstr = pzJsonstr.replaceAll("'","\"");
    }

    public String getZzJsonstr() {
        return zzJsonstr;
    }

    public void setZzJsonstr(String zzJsonstr) {
        this.zzJsonstr = zzJsonstr.replaceAll("'","\"");
    }

    public String getZxJsonstr() {
        return zxJsonstr;
    }

    public void setZxJsonstr(String zxJsonstr) {
        this.zxJsonstr = zxJsonstr.replaceAll("'","\"");
    }

    public String getZbJsonstr() {
        return zbJsonstr;
    }

    public void setZbJsonstr(String zbJsonstr) {
        this.zbJsonstr = zbJsonstr.replaceAll("'","\"");
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
