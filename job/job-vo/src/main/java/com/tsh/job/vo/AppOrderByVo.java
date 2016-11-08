/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.vo;

/**
 *
 * @author zengzw
 * @date 2016年10月14日
 */
public class AppOrderByVo {
    /**
     * 报名数
     */
    private String applyCount;
    
    
    /**
     * 发布时间
     */
    private String pushTime;
    
    
    /**
     * 起薪
     */
    private String salary;
    
    
    /**
     * 浏览次数
     */
    private String viewCount;

    public String getApplyCount() {
        return applyCount;
    }

    public String getPushTime() {
        return pushTime;
    }

    public String getSalary() {
        return salary;
    }

    public String getViewCount() {
        return viewCount;
    }
    
    public void setApplyCount(String applyCount) {
        this.applyCount = applyCount;
    }

    public void setPushTime(String pushTime) {
        this.pushTime = pushTime;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }
}
