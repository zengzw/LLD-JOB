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
public class CustomerApplyJobVo {
    /*java.lang.String, java.lang.String, long, java.lang.String, java.lang.String, java.util.Date, long, long, java.lang.String, long, long, long, long, long*/
    public CustomerApplyJobVo(){};
    public CustomerApplyJobVo(String code,String name,Long sex,String phone,String idCard
            ,Date createTime,Long provinceId,Long cityId,Long zoneId,String compName,Long categoryPid
            ,Long categoryCid,Long status,Long jobId,Long userId,String pvName,String areaName,String shopName
            ,String jobName){
        this.code= code;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.idCard = idCard;
        this.createTime = createTime;
        this.contactProvince = provinceId;
        this.contactCity = cityId;
        this.contactArea = zoneId;
        this.compName = compName;
        this.categoryPid = categoryPid;
        this.categoryCid = categoryCid;
        this.status = status;
        this.jobInfoId = jobId;
        this.userId =userId;
        this.pvName = pvName;
        this.areaName = areaName;
        this.shopName = shopName;
        this.jobName = jobName;
    }


    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getCategoryPid() {
        return categoryPid;
    }
    public void setCategoryPid(Long categoryPid) {
        this.categoryPid = categoryPid;
    }
    public Long getCategoryCid() {
        return categoryCid;
    }
    public void setCategoryCid(Long categoryCid) {
        this.categoryCid = categoryCid;
    }


    /**  城市ID*/
    private Long contactCity;
   
    /**  招工编码*/
    private String code;
    private Long userId;
    /**
     * 企业名称
     */
    private String compName;

    /**  发布时间*/
    private Date createTime;

    private Long categoryPid;
    
    private Long categoryCid;
    
    /**
     * 职位名称 大类
     */
    private String ctNameOne;
    /**
     * 职位名称小类
     */
    private String ctNameTwo;

    /**  职位名称*/
    private String jobName;

    private Long contactProvince;



    private Long contactArea;
    
    
    private String proviceName;
    
    private String cityName;
    
    private String zoneName;

    private Long status;

    private Long id;
    
    /**  职位ID*/
    private Long jobInfoId;

    /**  性别。0：女生，1：男生*/
    private Long  sex;

    /**  姓名*/
    private String name;

    /**  手机号码*/
    private String phone;

    /**  身份证*/
    private String idCard;

    
    /**
     * 用户报名省名称
     */
    private String pvName;
    /**
     * 用户报名区名称
     */
    private String areaName;
    /**
     * 用户报名网点名称
     */
    private String shopName;
    
    public Long getContactCity() {
        return contactCity;
    }
    public void setContactCity(Long contactCity) {
        this.contactCity = contactCity;
    }
    public Long getContactProvince() {
        return contactProvince;
    }
    public void setContactProvince(Long contactProvince) {
        this.contactProvince = contactProvince;
    }
    public Long getContactArea() {
        return contactArea;
    }
    public void setContactArea(Long contactArea) {
        this.contactArea = contactArea;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getCompName() {
        return compName;
    }
    public void setCompName(String compName) {
        this.compName = compName;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getCtNameOne() {
        return ctNameOne;
    }
    public void setCtNameOne(String ctNameOne) {
        this.ctNameOne = ctNameOne;
    }
    public String getCtNameTwo() {
        return ctNameTwo;
    }
    public void setCtNameTwo(String ctNameTwo) {
        this.ctNameTwo = ctNameTwo;
    }
    public String getJobName() {
        return jobName;
    }
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    public String getProviceName() {
        return proviceName;
    }
    public void setProviceName(String proviceName) {
        this.proviceName = proviceName;
    }
    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getZoneName() {
        return zoneName;
    }
    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }
    public Long getStatus() {
        return status;
    }
    public void setStatus(Long status) {
        this.status = status;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getJobInfoId() {
        return jobInfoId;
    }
    public void setJobInfoId(Long jobInfoId) {
        this.jobInfoId = jobInfoId;
    }
    public Long getSex() {
        return sex;
    }
    public void setSex(Long sex) {
        this.sex = sex;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    public String getPvName() {
        return pvName;
    }
    public void setPvName(String pvName) {
        this.pvName = pvName;
    }
    public String getAreaName() {
        return areaName;
    }
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    public String getShopName() {
        return shopName;
    }
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
    
    

}
