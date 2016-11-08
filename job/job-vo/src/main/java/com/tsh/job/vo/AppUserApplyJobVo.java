/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.vo;

/**
 *
 * @author zengzw
 * @date 2016年10月13日
 */
public class AppUserApplyJobVo {

    public AppUserApplyJobVo(){}
    
    public AppUserApplyJobVo(String categoryName,String compName,String phone,String userName,String status,String applyTime){
        this.categoryName = categoryName;
        this.compName = compName;
        this.phone = phone;
        this.userName = userName;
        this.status = status;
        this.applyTime = applyTime;
    }

    /**
     * 报名时间
     */
    private String applyTime;

    /**
     * 职位分类名称
     */
    private String categoryName;

    /**
     * 企业名称
     */
    private String compName;

    /**
     * 手机号码
     */
    private String phone;


    /**
     * 报名状态
     */
    private String status;

    /**
     * 用户名
     */
    private String userName;



    public String getApplyTime() {
        return applyTime;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCompName() {
        return compName;
    }

    public String getPhone() {
        return phone;
    }

    public String getStatus() {
        return status;
    }

    public String getUserName() {
        return userName;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
