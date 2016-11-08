/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.vo;

import java.util.Date;

/**
 *
 * @author zengzw
 * @date 2016年10月18日
 */
public class ApplyJobQueryVo {
    
    private String code;
    
    
    private Long contactProvince;
    
    private Long contactCity;
    
    /**
     * 县域名称
     */
    private Long contactArea;
    
    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    private String name;
    
    /**
     * 网点ID
     */
    private Long shopId;
    
    private Long sex;
    
    private String phone;
    
    
    private Date beginCreateTime;
    
    private Date endCreateTime;
    
    private String compName;
    
    private Long categoryPid;
    
    private Long categoryCid;
    
    private Long jobStatus;
    
    private Long provinceId;
    
    private Long cityId;
    
    /**
     *  用户所属县域Id
     */
    private Long userBlongBizId;

    public Date getBeginCreateTime() {
        return beginCreateTime;
    }

    public Long getCategoryCid() {
        return categoryCid;
    }

    public Long getCategoryPid() {
        return categoryPid;
    }

    public Long getCityId() {
        return cityId;
    }
    public String getCode() {
        return code;
    }

    public String getCompName() {
        return compName;
    }

    public Long getContactArea() {
        return contactArea;
    }

    public Long getContactCity() {
        return contactCity;
    }

    public Long getContactProvince() {
        return contactProvince;
    }

    public Date getEndCreateTime() {
        return endCreateTime;
    }

    public Long getJobStatus() {
        return jobStatus;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public Long getSex() {
        return sex;
    }

    public Long getUserBlongBizId() {
        return userBlongBizId;
    }

    public void setBeginCreateTime(Date beginCreateTime) {
        this.beginCreateTime = beginCreateTime;
    }

    public void setCategoryCid(Long categoryCid) {
        this.categoryCid = categoryCid;
    }


    public void setCategoryPid(Long categoryPid) {
        this.categoryPid = categoryPid;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public void setContactArea(Long contactArea) {
        this.contactArea = contactArea;
    }

    public void setContactCity(Long contactCity) {
        this.contactCity = contactCity;
    }

    public void setContactProvince(Long contactProvince) {
        this.contactProvince = contactProvince;
    }

    public void setEndCreateTime(Date endCreateTime) {
        this.endCreateTime = endCreateTime;
    }

    public void setJobStatus(Long jobStatus) {
        this.jobStatus = jobStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }

    public void setUserBlongBizId(Long userBlongBizId) {
        this.userBlongBizId = userBlongBizId;
    }
    
    
}
