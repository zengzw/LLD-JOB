package com.tsh.job.vo;

import java.io.Serializable;
import java.util.Date;


public class ApplyJobLogVo implements Serializable{
    private static final long serialVersionUID = 1L;

    /**  自增ID*/
    private Long id;
    /**  推送参数*/
    private String params;

    /**  推送时间*/
    private Date createTime;

    /**  推送状态。
0：失败，1：成功*/
    private Long state;

    /**  用户ID*/
    private Long appJobId;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id =id;
    }
    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params =params;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime =createTime;
    }
    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state =state;
    }
    public Long getAppJobId() {
        return appJobId;
    }

    public void setAppJobId(Long appJobId) {
        this.appJobId =appJobId;
    }
}
