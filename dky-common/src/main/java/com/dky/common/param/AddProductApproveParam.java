package com.dky.common.param;

import com.dky.common.session.SessionParameter;

import java.math.BigDecimal;

/**
 * Created by hang on 2017/1/6.
 */
public class AddProductApproveParam extends SessionParameter {
    /**
     * 款号名称
     */
    private String pdt;
    /**
     * 机构号
     */
    private String jgno;
    /**
     * 客户
     */
    private String customer;
    /**
     * 编号
     */
    private String no;
    /**
     * 传真日期
     */
    private String czDate;
    /**
     * 要求发货日期
     */
    private String fhDate;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 主颜色ID（第一个勾选的颜色）
     */
    private Long colorValue;
    /**
     * 颜色群（多个颜色用英文分号拼接的字符串）
     */
    private String colorArr;
    /**
     * 花型（多个花型英文分号拼接）
     * 如果花型后面带有文本框，需要单独做拼接
     * 为挑花时单独拼接：挑花（文本框-文本框），例如：挑花(1-2)
     * 为绞花时单独拼接：绞花（文本框-文本框），例如：绞花(1-2)
     * 为抽条时单独拼接：抽条（文本框抽文本框）,例如：抽条(1-2)
     */
    private String huax;
    /**
     * 口袋（多个口袋英文分号拼接）
     * 选中其他时获取其他后面的文本框拼接
     */
    private String koud;
    /**
     * 附件（多个附件英文分号拼接）
     * 选中其他时获取其他后面的文本框拼接
     */
    private String fuj;
    /**
     * 特殊工艺（多个特殊工艺英文分号拼接）
     * 选中其他时获取其他后面的文本框拼接
     */
    private String tesgy;
    /**
     * 烫珠（多个烫珠英文分号拼接）
     * 选中烫珠、绣花、串珠需要单独进行一次拼接：例如：烫珠(1-2#)
     * 为空时：(-#)
     */
    private String tangz;
    /**
     * 式样
     */
    private Long mDimNew12Id;
    /**
     * 性别
     */
    private Long mDimNew13Id;
    /**
     * 品种
     */
    private Long mDimNew14Id;
    /**
     *  组织
     */
    private Long mDimNew15Id;
    /**
     *   针型
     */
    private Long mDimNew16Id;
    /**
     *   支别
     */
    private Long mDimNew17Id;
    /**
     *   挂肩袖肥
     */
    private Long mDimNew18Id;
    /**
     *   收腰
     */
    private Long mDimNew19Id;
    /**
     *   肩型
     */
    private Long mDimNew22Id;
    /**
     *   领型
     */
    private Long mDimNew25Id;
    /**
     *   领边
     */
    private Long mDimNew26Id;
    /**
     *   领边层
     */
    private Long mDimNew28Id;
    /**
     *   下边
     */
    private Long mDimNew10Id;
    /**
     *   袖口
     */
    private Long mDimNew32Id;
    /**
     *   加穗
     */
    private Long mDimNew37Id;
    /**
     *   裤类别
     */
    private Long mDimNew38Id;
    /**
     *   开口
     */
    private Long mDimNew39Id;
    /**
     *   加裆
     */
    private Long mDimNew1Id;
    /**
     *   裙类别
     */
    private Long mDimNew3Id;
    /**
     *   钉扣拉链
     */
    private Long mDimNew4Id;
    /**
     *   门襟
     */
    private Long mDimNew6Id;
    /**
     *   第二袖型
     */
    private Long mDimNew9Id1;
    /**
     *   门襟组织
     */
    private Long mDimNew7Id;
    /**
     *   配套
     */
    private Long mDimNew41Id;
    /**
     *   第一袖型
     */
    private Long mDimNew9Id;
    /**
     *   第三袖型
     */
    private Long mDimNew9Id2;
    /**
     *  大（尺寸）
     */
    private String xwValue;
    /**
     *  长（尺寸）
     */
    private String ycValue;
    /**
     *  肩宽
     */
    private String qtjxValue;
    /**
     *  其他肩型
     */
    private BigDecimal jkValue;
    /**
     *  袖长
     */
    private BigDecimal xcValue;
    /**
     * 备忘录
     */
    private String shRemark;
    /**
     * 袖边组织
     */
    private Long xbzzValue;
    /**
     * 领：尺寸
     */
    private BigDecimal lingCcValue;
    /**
     *  袖边
     */
    private Long xbValue;
    /**
     *  袖边：袖边长
     */
    private BigDecimal xbcValue;
    /**
     *  袖边：其他袖边组织
     */
    private String qtxbzzValue;
    /**
     *  领
     */
    private String lingValue;
    /**
     *  领：样衣编码1(文本框)
     */
    private String lingNumber1Value;
    /**
     *  领：样衣编码2(文本框)
     */
    private String lingNumber2Value;
    /**
     *  领：其他备注
     */
    private Long qtLingOther;
    /**
     *  领：其他领边
     */
    private String qtlbValue;
    /**
     * 领：领型属性1
     */
    private String lxsx1Value;
    /**
     * 领：领型属性2
     */
    private String lxsx2Value;
    /**
     * 领：领型属性3
     */
    private String lxsx3Value;
    /**
     * 领：粒扣
     */
    private String lxsx4Value;
    /**
     *  领：备注
     */
    private String lxsx5Value;
    /**
     * 	下边：其他下边
     */
    private String qtxbValue;
    /**
     * 	下边：下边尺寸cm
     */
    private BigDecimal xbccValue;
    /**
     * 	加注
     */
    private String jzValue;
    /**
     * 	袖口：袖口尺寸
     */
    private BigDecimal xkccValue;
    /**
     * 	袖口：其他袖口
     */
    private String qtxkValue;
    /**
     * 	式样：工艺袖长
     */
    private BigDecimal hzxcValue;
    /**
     * 	肩型：工艺袖长
     */
    private BigDecimal hzxc1Value;
    /**
     * 	式样：带长
     */
    private BigDecimal dc1Value;
    /**
     * 	式样：档长
     */
    private BigDecimal dcValue;
    /**
     * 	式样：门襟宽
     */
    private BigDecimal mjkValue;
    /**
     * 	式样：门襟长
     */
    private BigDecimal mjcValue;
    /**
     * 	式样：其他门禁1（带长前面的文本框1）
     */
    private String amjValue;
    /**
     * 	式样：其他门禁2（带长前面的文本框2）
     */
    private String qtmjValue;
    /**
     * 式样：钉【】扣#
     */
    private String dkNumber;
    /**
     * 袖型：其他袖型1
     */
    private String qtxxValue;
    /**
     * 袖型：其他袖型2
     */
    private String qtxxValue1;
    /**
     * 袖型：其他袖型3
     */
    private String qtxxValue2;
    /**
     * 净尺寸：净胸围
     */
    private String jxwValue;
    /**
     * 净尺寸：实际袖长
     */
    private String sjxcValue;

    public String getPdt() {
        return pdt;
    }

    public void setPdt(String pdt) {
        this.pdt = pdt;
    }

    public String getJgno() {
        return jgno;
    }

    public void setJgno(String jgno) {
        this.jgno = jgno;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getCzDate() {
        return czDate;
    }

    public void setCzDate(String czDate) {
        this.czDate = czDate;
    }

    public String getFhDate() {
        return fhDate;
    }

    public void setFhDate(String fhDate) {
        this.fhDate = fhDate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getColorValue() {
        return colorValue;
    }

    public void setColorValue(Long colorValue) {
        this.colorValue = colorValue;
    }

    public String getColorArr() {
        return colorArr;
    }

    public void setColorArr(String colorArr) {
        this.colorArr = colorArr;
    }

    public String getHuax() {
        return huax;
    }

    public void setHuax(String huax) {
        this.huax = huax;
    }

    public String getKoud() {
        return koud;
    }

    public void setKoud(String koud) {
        this.koud = koud;
    }

    public String getFuj() {
        return fuj;
    }

    public void setFuj(String fuj) {
        this.fuj = fuj;
    }

    public String getTesgy() {
        return tesgy;
    }

    public void setTesgy(String tesgy) {
        this.tesgy = tesgy;
    }

    public String getTangz() {
        return tangz;
    }

    public void setTangz(String tangz) {
        this.tangz = tangz;
    }

    public Long getmDimNew12Id() {
        return mDimNew12Id;
    }

    public void setmDimNew12Id(Long mDimNew12Id) {
        this.mDimNew12Id = mDimNew12Id;
    }

    public Long getmDimNew13Id() {
        return mDimNew13Id;
    }

    public void setmDimNew13Id(Long mDimNew13Id) {
        this.mDimNew13Id = mDimNew13Id;
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

    public Long getmDimNew18Id() {
        return mDimNew18Id;
    }

    public void setmDimNew18Id(Long mDimNew18Id) {
        this.mDimNew18Id = mDimNew18Id;
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

    public Long getmDimNew25Id() {
        return mDimNew25Id;
    }

    public void setmDimNew25Id(Long mDimNew25Id) {
        this.mDimNew25Id = mDimNew25Id;
    }

    public Long getmDimNew26Id() {
        return mDimNew26Id;
    }

    public void setmDimNew26Id(Long mDimNew26Id) {
        this.mDimNew26Id = mDimNew26Id;
    }

    public Long getmDimNew28Id() {
        return mDimNew28Id;
    }

    public void setmDimNew28Id(Long mDimNew28Id) {
        this.mDimNew28Id = mDimNew28Id;
    }

    public Long getmDimNew10Id() {
        return mDimNew10Id;
    }

    public void setmDimNew10Id(Long mDimNew10Id) {
        this.mDimNew10Id = mDimNew10Id;
    }

    public Long getmDimNew32Id() {
        return mDimNew32Id;
    }

    public void setmDimNew32Id(Long mDimNew32Id) {
        this.mDimNew32Id = mDimNew32Id;
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

    public Long getmDimNew9Id1() {
        return mDimNew9Id1;
    }

    public void setmDimNew9Id1(Long mDimNew9Id1) {
        this.mDimNew9Id1 = mDimNew9Id1;
    }

    public Long getmDimNew7Id() {
        return mDimNew7Id;
    }

    public void setmDimNew7Id(Long mDimNew7Id) {
        this.mDimNew7Id = mDimNew7Id;
    }

    public Long getmDimNew41Id() {
        return mDimNew41Id;
    }

    public void setmDimNew41Id(Long mDimNew41Id) {
        this.mDimNew41Id = mDimNew41Id;
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

    public String getXwValue() {
        return xwValue;
    }

    public void setXwValue(String xwValue) {
        this.xwValue = xwValue;
    }

    public String getYcValue() {
        return ycValue;
    }

    public void setYcValue(String ycValue) {
        this.ycValue = ycValue;
    }

    public String getQtjxValue() {
        return qtjxValue;
    }

    public void setQtjxValue(String qtjxValue) {
        this.qtjxValue = qtjxValue;
    }

    public BigDecimal getJkValue() {
        return jkValue;
    }

    public void setJkValue(BigDecimal jkValue) {
        this.jkValue = jkValue;
    }

    public BigDecimal getXcValue() {
        return xcValue;
    }

    public void setXcValue(BigDecimal xcValue) {
        this.xcValue = xcValue;
    }

    public String getShRemark() {
        return shRemark;
    }

    public void setShRemark(String shRemark) {
        this.shRemark = shRemark;
    }

    public Long getXbzzValue() {
        return xbzzValue;
    }

    public void setXbzzValue(Long xbzzValue) {
        this.xbzzValue = xbzzValue;
    }

    public BigDecimal getLingCcValue() {
        return lingCcValue;
    }

    public void setLingCcValue(BigDecimal lingCcValue) {
        this.lingCcValue = lingCcValue;
    }

    public Long getXbValue() {
        return xbValue;
    }

    public void setXbValue(Long xbValue) {
        this.xbValue = xbValue;
    }

    public BigDecimal getXbcValue() {
        return xbcValue;
    }

    public void setXbcValue(BigDecimal xbcValue) {
        this.xbcValue = xbcValue;
    }

    public String getQtxbzzValue() {
        return qtxbzzValue;
    }

    public void setQtxbzzValue(String qtxbzzValue) {
        this.qtxbzzValue = qtxbzzValue;
    }

    public String getLingValue() {
        return lingValue;
    }

    public void setLingValue(String lingValue) {
        this.lingValue = lingValue;
    }

    public String getLingNumber1Value() {
        return lingNumber1Value;
    }

    public void setLingNumber1Value(String lingNumber1Value) {
        this.lingNumber1Value = lingNumber1Value;
    }

    public String getLingNumber2Value() {
        return lingNumber2Value;
    }

    public void setLingNumber2Value(String lingNumber2Value) {
        this.lingNumber2Value = lingNumber2Value;
    }

    public Long getQtLingOther() {
        return qtLingOther;
    }

    public void setQtLingOther(Long qtLingOther) {
        this.qtLingOther = qtLingOther;
    }

    public String getQtlbValue() {
        return qtlbValue;
    }

    public void setQtlbValue(String qtlbValue) {
        this.qtlbValue = qtlbValue;
    }

    public String getLxsx1Value() {
        return lxsx1Value;
    }

    public void setLxsx1Value(String lxsx1Value) {
        this.lxsx1Value = lxsx1Value;
    }

    public String getLxsx2Value() {
        return lxsx2Value;
    }

    public void setLxsx2Value(String lxsx2Value) {
        this.lxsx2Value = lxsx2Value;
    }

    public String getLxsx3Value() {
        return lxsx3Value;
    }

    public void setLxsx3Value(String lxsx3Value) {
        this.lxsx3Value = lxsx3Value;
    }

    public String getLxsx4Value() {
        return lxsx4Value;
    }

    public void setLxsx4Value(String lxsx4Value) {
        this.lxsx4Value = lxsx4Value;
    }

    public String getLxsx5Value() {
        return lxsx5Value;
    }

    public void setLxsx5Value(String lxsx5Value) {
        this.lxsx5Value = lxsx5Value;
    }

    public String getQtxbValue() {
        return qtxbValue;
    }

    public void setQtxbValue(String qtxbValue) {
        this.qtxbValue = qtxbValue;
    }

    public BigDecimal getXbccValue() {
        return xbccValue;
    }

    public void setXbccValue(BigDecimal xbccValue) {
        this.xbccValue = xbccValue;
    }

    public String getJzValue() {
        return jzValue;
    }

    public void setJzValue(String jzValue) {
        this.jzValue = jzValue;
    }

    public BigDecimal getXkccValue() {
        return xkccValue;
    }

    public void setXkccValue(BigDecimal xkccValue) {
        this.xkccValue = xkccValue;
    }

    public String getQtxkValue() {
        return qtxkValue;
    }

    public void setQtxkValue(String qtxkValue) {
        this.qtxkValue = qtxkValue;
    }

    public BigDecimal getHzxcValue() {
        return hzxcValue;
    }

    public void setHzxcValue(BigDecimal hzxcValue) {
        this.hzxcValue = hzxcValue;
    }

    public BigDecimal getHzxc1Value() {
        return hzxc1Value;
    }

    public void setHzxc1Value(BigDecimal hzxc1Value) {
        this.hzxc1Value = hzxc1Value;
    }

    public BigDecimal getDc1Value() {
        return dc1Value;
    }

    public void setDc1Value(BigDecimal dc1Value) {
        this.dc1Value = dc1Value;
    }

    public BigDecimal getDcValue() {
        return dcValue;
    }

    public void setDcValue(BigDecimal dcValue) {
        this.dcValue = dcValue;
    }

    public BigDecimal getMjkValue() {
        return mjkValue;
    }

    public void setMjkValue(BigDecimal mjkValue) {
        this.mjkValue = mjkValue;
    }

    public BigDecimal getMjcValue() {
        return mjcValue;
    }

    public void setMjcValue(BigDecimal mjcValue) {
        this.mjcValue = mjcValue;
    }

    public String getAmjValue() {
        return amjValue;
    }

    public void setAmjValue(String amjValue) {
        this.amjValue = amjValue;
    }

    public String getQtmjValue() {
        return qtmjValue;
    }

    public void setQtmjValue(String qtmjValue) {
        this.qtmjValue = qtmjValue;
    }

    public String getDkNumber() {
        return dkNumber;
    }

    public void setDkNumber(String dkNumber) {
        this.dkNumber = dkNumber;
    }

    public String getQtxxValue() {
        return qtxxValue;
    }

    public void setQtxxValue(String qtxxValue) {
        this.qtxxValue = qtxxValue;
    }

    public String getQtxxValue1() {
        return qtxxValue1;
    }

    public void setQtxxValue1(String qtxxValue1) {
        this.qtxxValue1 = qtxxValue1;
    }

    public String getQtxxValue2() {
        return qtxxValue2;
    }

    public void setQtxxValue2(String qtxxValue2) {
        this.qtxxValue2 = qtxxValue2;
    }

    public String getJxwValue() {
        return jxwValue;
    }

    public void setJxwValue(String jxwValue) {
        this.jxwValue = jxwValue;
    }

    public String getSjxcValue() {
        return sjxcValue;
    }

    public void setSjxcValue(String sjxcValue) {
        this.sjxcValue = sjxcValue;
    }
}
