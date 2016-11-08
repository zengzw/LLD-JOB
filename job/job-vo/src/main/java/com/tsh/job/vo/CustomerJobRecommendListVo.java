/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.vo;

import java.util.Date;

/**
 *
 * @author zengzw
 * @date 2016年10月22日
 */
public class CustomerJobRecommendListVo {
    
    
    private String code;
    
    /**
     * 推荐-全国
     */
    private Long country;
    
    /**
     * 推荐-省
     */
    private String provinceName;
    /**
     * 推荐-城市
     */
    private String cityName;
    
    /**
     * 职位地区
     */
    private String jobAddress;
    
    /**
     * 招功能城市Id
     */
    private Long zoneId;
    
    /**
     * 推荐地区
     */
    private String recomdAddress;
    
    /**
     * 企业名称
     */
    private String compName;
    
    
    private String categoryPName;
    
    private String categoryCname;

    private String jobName;

    private Long applyCount;
    
    private Date pushTime;
    
    /**
     * 职位状态
     */
    private Long status;
    
    /**
     * 推荐状态
     */
    private Long recStatus;
    
    private Long recomId;
    
    private Long jobId;
    
    private Long cPid;
    
    private Long cCid;
    
    public CustomerJobRecommendListVo(){}
    
    public CustomerJobRecommendListVo(String code,Long rCountry,String rProvince,String rCityName,
            Long jZoneId,String jobName,String compName,Long cPid,Long cCid,Long applyCount,Date pushTime,Long
            status,Long jobId,Long recomId,Long recStatus){
        this.code = code;
        this.country = rCountry;
        this.provinceName = rProvince;
        this.cityName = rCityName;
        this.zoneId = jZoneId;
        this.jobName = jobName;
        this.compName = compName;
        this.cPid = cPid;
        this.cCid = cCid;
        this.applyCount = applyCount;
        this.pushTime = pushTime;
        this.status = status;
        this.jobId = jobId;
        this.recomId = recomId;
        this.recStatus = recStatus;
    }
    
    public Long getRecStatus() {
        return recStatus;
    }

    public void setRecStatus(Long recStatus) {
        this.recStatus = recStatus;
    }

    public Long getApplyCount() {
        return applyCount;
    }
    
    public String getCategoryCname() {
        return categoryCname;
    }

   
    public String getCategoryPName() {
        return categoryPName;
    }

    public Long getcCid() {
        return cCid;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCode() {
        return code;
    }

    public String getCompName() {
        return compName;
    }

    public Long getCountry() {
        return country;
    }

    public Long getcPid() {
        return cPid;
    }

    public String getJobAddress() {
        return jobAddress;
    }

    public Long getJobId() {
        return jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public String getRecomdAddress() {
        return recomdAddress;
    }

    public Long getRecomId() {
        return recomId;
    }

    public Long getStatus() {
        return status;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setApplyCount(Long applyCount) {
        this.applyCount = applyCount;
    }

    public void setCategoryCname(String categoryCname) {
        this.categoryCname = categoryCname;
    }

    public void setCategoryPName(String categoryPName) {
        this.categoryPName = categoryPName;
    }

    public void setcCid(Long cCid) {
        this.cCid = cCid;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public void setCountry(Long country) {
        this.country = country;
    }

    public void setcPid(Long cPid) {
        this.cPid = cPid;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public void setRecomdAddress(String recomdAddress) {
        this.recomdAddress = recomdAddress;
    }

    public void setRecomId(Long recomId) {
        this.recomId = recomId;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }
    
}
    
