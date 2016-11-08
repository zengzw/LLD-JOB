/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.http.lld.vo.resp;

/**
 * 职位信息Vo
 * 
 * @author zengzw
 * @date 2016年9月26日
 */
public class ResJobInfoVO {

    private long id;      //job的id

    private long companyId;// 公司的id

    private String jobName;//  招工标题

    private String companyName;// 公司名字

    private  int salaryMin; //工资范围

    private int salaryMax; // 工资范围

    private String[] highligetslist ;//   企业亮点

    private int  applicantNumbe;// 蓝领带平台已报名人数

    private long workAddress;//   地区ID

    private long category; // 职位类型ID

    private int crossProvince;// 是否跨省 0 = ‘否’, 1 = ’是


    private String districtProvince;//  省

    private String districtCity; //市

    private String districtZone;// 区/县

    private String jobCategoryLevelOne ;//  岗位

    private String jobCategoryLevelTwo;// 详细分类

    
    private String districtProvinceId; //  省Id
    
    private String  districtCityId;
    
    private String  districtZoneId;
    
    private String  jobCategoryLevelOneId;
    
    private String  jobCategoryLevelTwoId;

    private int recruitmentNumber;//共招聘（数量）

    private long deadline; //  截止日期 时间戳

    private  double entryAward;//    入职奖

    private String salary ;//工资详情

    private String workContent;//工作内容

    private String environment;//工作环境

    private String requirements ;//职位要求

    private String benefit; //福利待遇

    private String introduction;// 企业介绍

    private String[] imgList;// 图片
    
    private long updateTime; //更新时间

    
    private int status; //状态
    

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public long getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }
    public String getDistrictProvinceId() {
        return districtProvinceId;
    }
    public void setDistrictProvinceId(String districtProvinceId) {
        this.districtProvinceId = districtProvinceId;
    }
    public String getDistrictCityId() {
        return districtCityId;
    }
    public void setDistrictCityId(String districtCityId) {
        this.districtCityId = districtCityId;
    }
    public String getDistrictZoneId() {
        return districtZoneId;
    }
    public void setDistrictZoneId(String districtZoneId) {
        this.districtZoneId = districtZoneId;
    }
    public String getJobCategoryLevelOneId() {
        return jobCategoryLevelOneId;
    }
    public void setJobCategoryLevelOneId(String jobCategoryLevelOneId) {
        this.jobCategoryLevelOneId = jobCategoryLevelOneId;
    }
    public String getJobCategoryLevelTwoId() {
        return jobCategoryLevelTwoId;
    }
    public void setJobCategoryLevelTwoId(String jobCategoryLevelTwoId) {
        this.jobCategoryLevelTwoId = jobCategoryLevelTwoId;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getCompanyId() {
        return companyId;
    }
    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }
    public String getJobName() {
        return jobName;
    }
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public int getSalaryMin() {
        return salaryMin;
    }
    public void setSalaryMin(int salaryMin) {
        this.salaryMin = salaryMin;
    }
    public int getSalaryMax() {
        return salaryMax;
    }
    public void setSalaryMax(int salaryMax) {
        this.salaryMax = salaryMax;
    }
    public String[] getHighligetslist() {
        return highligetslist;
    }
    public void setHighligetslist(String[] highligetslist) {
        this.highligetslist = highligetslist;
    }
    public int getApplicantNumbe() {
        return applicantNumbe;
    }
    public void setApplicantNumbe(int applicantNumbe) {
        this.applicantNumbe = applicantNumbe;
    }
    public long getWorkAddress() {
        return workAddress;
    }
    public void setWorkAddress(long workAddress) {
        this.workAddress = workAddress;
    }
    public long getCategory() {
        return category;
    }
    public void setCategory(long category) {
        this.category = category;
    }
    public int getCrossProvince() {
        return crossProvince;
    }
    public void setCrossProvince(int crossProvince) {
        this.crossProvince = crossProvince;
    }
    public String getDistrictProvince() {
        return districtProvince;
    }
    public void setDistrictProvince(String districtProvince) {
        this.districtProvince = districtProvince;
    }
    public String getDistrictCity() {
        return districtCity;
    }
    public void setDistrictCity(String districtCity) {
        this.districtCity = districtCity;
    }
    public String getDistrictZone() {
        return districtZone;
    }
    public void setDistrictZone(String districtZone) {
        this.districtZone = districtZone;
    }
    public String getJobCategoryLevelOne() {
        return jobCategoryLevelOne;
    }
    public void setJobCategoryLevelOne(String jobCategoryLevelOne) {
        this.jobCategoryLevelOne = jobCategoryLevelOne;
    }
    public String getJobCategoryLevelTwo() {
        return jobCategoryLevelTwo;
    }
    public void setJobCategoryLevelTwo(String jobCategoryLevelTwo) {
        this.jobCategoryLevelTwo = jobCategoryLevelTwo;
    }
    public int getRecruitmentNumber() {
        return recruitmentNumber;
    }
    public void setRecruitmentNumber(int recruitmentNumber) {
        this.recruitmentNumber = recruitmentNumber;
    }
    public long getDeadline() {
        return deadline;
    }
    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }
    public double getEntryAward() {
        return entryAward;
    }
    public void setEntryAward(double entryAward) {
        this.entryAward = entryAward;
    }
    public String getSalary() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
    public String getWorkContent() {
        return workContent;
    }
    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }
    public String getEnvironment() {
        return environment;
    }
    public void setEnvironment(String environment) {
        this.environment = environment;
    }
    public String getRequirements() {
        return requirements;
    }
    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }
    public String getBenefit() {
        return benefit;
    }
    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }
    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public String[] getImgList() {
        return imgList;
    }
    public void setImgList(String[] imgList) {
        this.imgList = imgList;
    }



}
