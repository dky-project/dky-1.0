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
     * 备忘录
     */
    private String sh_remark;
    /**
     * 式样
     */
    private Long mDimNew12Id;
}
