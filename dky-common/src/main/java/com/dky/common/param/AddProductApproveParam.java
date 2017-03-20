package com.dky.common.param;

import com.dky.common.session.SessionParameter;

/**
 * Created by hang on 2017/1/6.
 */
public class AddProductApproveParam extends SessionParameter {

    /**
     * 主颜色ID（第一个勾选的颜色）
     */
    private Long colorId;
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
    //XC_VALUE1,XBZZ_VALUE,LING_CC_VALUE,XB_VALUE,XBC_VALUE,QTXBZZ_VALUE,LING_VALUE,LING_NUMBER1_VALUE,LING_NUMBER2_VALUE,M_DIM_NEW25_ID,M_DIM_NEW26_ID,LXSX5_VALUE,qtLingOther,QTLB_VALUE,LXSX3_VALUE,LXSX4_VALUE,LXSX1_VALUE,LXSX2_VALUE,M_DIM_NEW28_ID,HUAX,TANGZ,QTXB_VALUE,XBCC_VALUE,M_DIM_NEW10_ID,JZ_VALUE,XKCC_VALUE,QTXK_VALUE,M_DIM_NEW32_ID,HZXC_VALUE,HZXC1_VALUE,DC1_VALUE,M_DIM_NEW37_ID,M_DIM_NEW38_ID,M_DIM_NEW39_ID,M_DIM_NEW1_ID,DC_VALUE,M_DIM_NEW3_ID,M_DIM_NEW4_ID,M_DIM_NEW6_ID,MJK_VALUE,M_DIM_NEW7_ID,MJC_VALUE,QTMJ_VALUE,AMJ_VALUE,M_DIM_NEW41_ID,COLORVALUE,COLORARR,DK_NUMBER,M_DIM_NEW9_ID,QTXX_VALUE,M_DIM_NEW9_ID1,QTXX_VALUE1,M_DIM_NEW9_ID2,QTXX_VALUE2,ISAPPROVE,OWNERID,MODIFIERID,CREATIONDATE,MODIFIEDDATE,jxw_value,sjxc_value,ISACTIVE,PDT,JGNO,customer,NO,CZ_DATE,FH_DATE,remark,mobile
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
    private String jkValue;
    /**
     * 备忘录
     */
    private String sh_remark;
}
