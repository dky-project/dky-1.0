package com.dky.common.response.view;

import com.dky.common.constats.GlobConts;
import com.dky.common.response.ResultObjectBase;

import java.util.Date;

/**
 * Created by hang on 2017/1/4 0004.
 * @decription 陈列
 */
public class ClGroupView extends ResultObjectBase {

    private String gh;
    private String hallName;
    private String attribname;
    private Long no1ProductId;
    private Long no2ProductId;
    private Long no3ProductId;
    private Long no4ProductId;
    private Long no5ProductId;
    private Long no6ProductId;
    private Long no7ProductId;
    private Long no8ProductId;
    private Long no9ProductId;
    private Long no10ProductId;
    private Long no11ProductId;
    private Long no12ProductId;
    private Long no13ProductId;
    private Long no14ProductId;
    private Long no15ProductId;
    private String groupNo1;
    private String groupNo2;
    private String groupNo3;
    private String groupNo4;
    private String groupNo5;
    private String groupNo6;
    private Date modifieddate;

    private String clImgUrl;
    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Long getNo1ProductId() {
        return no1ProductId;
    }

    public void setNo1ProductId(Long no1ProductId) {
        this.no1ProductId = no1ProductId;
    }

    public Long getNo2ProductId() {
        return no2ProductId;
    }

    public void setNo2ProductId(Long no2ProductId) {
        this.no2ProductId = no2ProductId;
    }

    public Long getNo3ProductId() {
        return no3ProductId;
    }

    public void setNo3ProductId(Long no3ProductId) {
        this.no3ProductId = no3ProductId;
    }

    public Long getNo4ProductId() {
        return no4ProductId;
    }

    public void setNo4ProductId(Long no4ProductId) {
        this.no4ProductId = no4ProductId;
    }

    public Long getNo5ProductId() {
        return no5ProductId;
    }

    public void setNo5ProductId(Long no5ProductId) {
        this.no5ProductId = no5ProductId;
    }

    public Long getNo6ProductId() {
        return no6ProductId;
    }

    public void setNo6ProductId(Long no6ProductId) {
        this.no6ProductId = no6ProductId;
    }

    public Long getNo7ProductId() {
        return no7ProductId;
    }

    public void setNo7ProductId(Long no7ProductId) {
        this.no7ProductId = no7ProductId;
    }

    public Long getNo8ProductId() {
        return no8ProductId;
    }

    public void setNo8ProductId(Long no8ProductId) {
        this.no8ProductId = no8ProductId;
    }

    public Long getNo9ProductId() {
        return no9ProductId;
    }

    public void setNo9ProductId(Long no9ProductId) {
        this.no9ProductId = no9ProductId;
    }

    public Long getNo10ProductId() {
        return no10ProductId;
    }

    public void setNo10ProductId(Long no10ProductId) {
        this.no10ProductId = no10ProductId;
    }

    public Long getNo11ProductId() {
        return no11ProductId;
    }

    public void setNo11ProductId(Long no11ProductId) {
        this.no11ProductId = no11ProductId;
    }

    public Long getNo12ProductId() {
        return no12ProductId;
    }

    public void setNo12ProductId(Long no12ProductId) {
        this.no12ProductId = no12ProductId;
    }

    public Long getNo13ProductId() {
        return no13ProductId;
    }

    public void setNo13ProductId(Long no13ProductId) {
        this.no13ProductId = no13ProductId;
    }

    public Long getNo14ProductId() {
        return no14ProductId;
    }

    public void setNo14ProductId(Long no14ProductId) {
        this.no14ProductId = no14ProductId;
    }

    public Long getNo15ProductId() {
        return no15ProductId;
    }

    public void setNo15ProductId(Long no15ProductId) {
        this.no15ProductId = no15ProductId;
    }

    public String getClImgUrl() {
        return clImgUrl;
    }

    public void setClImgUrl(String clImgUrl) {
        this.clImgUrl = clImgUrl;
    }

    public Date getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        this.clImgUrl = GlobConts.IMAGE_ROOT_URL+"/CL_SL/"+this.gh+".jpg?modifieddate="+ modifieddate.getTime();
        this.modifieddate = modifieddate;
    }

    public String getGroupNo1() {
        return groupNo1;
    }

    public void setGroupNo1(String groupNo1) {
        this.groupNo1 = groupNo1;
    }

    public String getGroupNo2() {
        return groupNo2;
    }

    public void setGroupNo2(String groupNo2) {
        this.groupNo2 = groupNo2;
    }

    public String getGroupNo3() {
        return groupNo3;
    }

    public void setGroupNo3(String groupNo3) {
        this.groupNo3 = groupNo3;
    }

    public String getGroupNo4() {
        return groupNo4;
    }

    public void setGroupNo4(String groupNo4) {
        this.groupNo4 = groupNo4;
    }

    public String getGroupNo5() {
        return groupNo5;
    }

    public void setGroupNo5(String groupNo5) {
        this.groupNo5 = groupNo5;
    }

    public String getGroupNo6() {
        return groupNo6;
    }

    public void setGroupNo6(String groupNo6) {
        this.groupNo6 = groupNo6;
    }

    public String getAttribname() {
        return attribname;
    }

    public void setAttribname(String attribname) {
        this.attribname = attribname;
    }
}
