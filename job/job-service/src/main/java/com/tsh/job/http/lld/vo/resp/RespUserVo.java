/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.http.lld.vo.resp;

import java.io.Serializable;

/**
 *
 * @author zengzw
 * @date 2016年10月15日
 */
public class RespUserVo implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 5948227385879059640L;


    private Long id;
    
    /**
     * 职位ID
     */
    private  Long jobId ;

    /**
     * 报名姓名
     */
    private String name;   


    /**
     * 报名电话
     */
    private String mobile  ;   

    /**
     * 身份证
     * 
     */
    private String idcard  ;  

    /**
     * 报名地址
     */
    private String network ;  

    /**
     * 性别 0：女，1：男
     */
    private int gender ; 


    /**
     * 备注
     */
    private String remark;
    
    /**
     * 报名状态
     */
    private boolean applyStatus;
    
    
    /**
     * 注册时间
     */
    private Long registTime;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Long getJobId() {
        return jobId;
    }


    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getMobile() {
        return mobile;
    }


    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public String getIdcard() {
        return idcard;
    }


    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }


    public String getNetwork() {
        return network;
    }


    public void setNetwork(String network) {
        this.network = network;
    }


    public int getGender() {
        return gender;
    }


    public void setGender(int gender) {
        this.gender = gender;
    }


    public String getRemark() {
        return remark;
    }


    public void setRemark(String remark) {
        this.remark = remark;
    }


    public boolean isApplyStatus() {
        return applyStatus;
    }


    public void setApplyStatus(boolean applyStatus) {
        this.applyStatus = applyStatus;
    }


    public Long getRegistTime() {
        return registTime;
    }


    public void setRegistTime(Long registTime) {
        this.registTime = registTime;
    }
    
}
