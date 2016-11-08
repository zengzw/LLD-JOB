/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.vo;

/**
 * 职位推荐接收VO
 * 
 * @author zengzw
 * @date 2016年10月20日
 */
public class CustomerJobRecommenedVo {
    
    private String country;
    
    private String province;
    
    private String provinceName;
    
    private String cityName;

    private String city;

    private String jobIds;

    public String getCity() {
        return city;
    }

    public String getCityName() {
        return cityName;
    }
    
    public String getCountry() {
        return country;
    }
    
    public String getJobIds() {
        return jobIds;
    }

    public String getProvince() {
        return province;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setJobIds(String jobIds) {
        this.jobIds = jobIds;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

}
