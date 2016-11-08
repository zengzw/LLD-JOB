package com.tsh.job.vo;

import java.io.Serializable;
import java.util.Date;


public class JobInfoLogVo implements Serializable{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;
    /**  up:商家：down:下架*/
    private String action;

    /**  操作人*/
    private Long createId;

    /**  操作时间*/
    private Date createTime;

    /**  职位Id*/
    private Long jobInfoId;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id =id;
    }
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action =action;
    }
    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId =createId;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime =createTime;
    }
    public Long getJobInfoId() {
        return jobInfoId;
    }

    public void setJobInfoId(Long jobInfoId) {
        this.jobInfoId =jobInfoId;
    }
}
