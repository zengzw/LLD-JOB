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
public class AppJobListVo {
    /**  */
    private Long jobId;

    /**  标题*/
    private String jobName;
    
    /**
     * 公司名称
     */
    private String compName;
    
    /**
     * 企业亮点
     */
    private String highligets;
    
    /**
     * 起薪
     */
    private String salary;
    
    
    /**  图片*/
    private String images;
    

    /** 申请次数*/
    private Long applyCount;
    
    /**
     * 分类名称
     */
    private String categoryName;


    public String getCategoryName() {
        return categoryName;
    }


    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public Long getJobId() {
        return jobId;
    }


    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }


    public String getJobName() {
        return jobName;
    }


    public void setJobName(String jobName) {
        this.jobName = jobName;
    }


    public String getCompName() {
        return compName;
    }


    public void setCompName(String compName) {
        this.compName = compName;
    }


    public String getHighligets() {
        return highligets;
    }


    public void setHighligets(String highligets) {
        this.highligets = highligets;
    }


    public String getSalary() {
        return salary;
    }


    public void setSalary(String salary) {
        this.salary = salary;
    }


    public String getImages() {
        return images;
    }


    public void setImages(String images) {
        this.images = images;
    }


    public Long getApplyCount() {
        if(applyCount == null)
            return 0L;
                    
        return applyCount;
    }


    public void setApplyCount(Long applyCount) {
        this.applyCount = applyCount;
    }


}
