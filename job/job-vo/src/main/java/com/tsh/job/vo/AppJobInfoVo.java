/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.vo;

import java.util.Date;

/**
 *
 * @author zengzw
 * @date 2016年10月14日
 */
public class AppJobInfoVo {

    /**  工作地点*/
    private String address;
    /** 第三方 已申请人数*/
    private Long applyNumber;

    /**
     * 总申请人数
     */
    private Long applyNumCount;

    /**  待遇需求*/
    private String benefit;


    /**  城市ID*/
    private Long cityId;

    private String cityName;

    /**  招工编码*/
    private String code;


    /**  企业Id*/
    private Long compId;

    /**
     * 企业名称
     */
    private String compName;

    /**  发布时间*/
    private Date createTime;

    /**
     * 职位名称 大类
     */
    private String ctNameOne;

    /**
     * 职位名称小类
     */
    private String ctNameTwo;

    /**  报名截止日期*/
    private Date deadline;

    /**  报名截止日期*/
    private String deadlineTime;

    /**
     * 下架时间
     */
    private Date downTime;

    /**  入职奖励*/
    private Double entryAward;

    /**  工作环境*/
    private String environment;

    /**  企业亮点*/
    private String highligets;

    /**  企业图片.以；隔开*/
    private String images;

    /**  企业介绍*/
    private String introduction;

    /**  工作类型 子ID*/
    private Long jobCategoryCid;

    /**  工作类型父ID*/
    private Long jobCategoryPid;
    /**  第三方JobId*/
    private Long jobId;

    /**  职位名称*/
    private String jobName;


    /** 最大报名人数 **/
    private Long maxApplyCount;

    /** 最小报名人数 **/
    private Long minApplyCount;

    /**  最后更新时间*/
    private Date modifyTime;


    private String proviceName;

    /**  省份ID*/
    private Long provinceId;

    private Date pushTime;

    /**  招聘人数*/
    private Long  recruitNumber;

    /**  工作需求*/
    private String requirements;


    /**  工资详情*/
    private String salaryDesc;

    /**  最高工资*/
    private Long salaryMax;

    /**  最小工资*/
    private Long salaryMin;
    /**  招聘状态。
0：位审核
1：审核中
2：招聘中
3：审核未通过
4：已暂停
5：已介绍
6：已删除*/
    private Long status;


    /**自己内部已申请人数*/
    private Long tshApplyNumber;


    /**
     * 上架状态
     */
    private Long tshStatus;

    /**  关注度（查看数）*/
    private Long viewCount;

    /**  工作内容*/
    private String workContent;

    /**  地区ID*/
    private Long zoneId;

    private String zoneName;

    public String getAddress() {
        return address;
    }

    public Long getApplyNumber() {
        return applyNumber;
    }

    public Long getApplyNumCount() {
        if(applyNumCount == null)
            return 0L;
        return applyNumCount;
    }

    public String getBenefit() {
        return benefit;
    }

    public Long getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCode() {
        return code;
    }


    public Long getCompId() {
        return compId;
    }

    public String getCompName() {
        return compName;
    }

    public Date getCreateTime() {
        return createTime;
    }



    public String getCtNameOne() {
        return ctNameOne;
    }

    public String getCtNameTwo() {
        return ctNameTwo;
    }

    public Date getDeadline() {
        return deadline;
    }

    public String getDeadlineTime() {
        return deadlineTime;
    }

    public Date getDownTime() {
        return downTime;
    }

    public Double getEntryAward() {
        return entryAward;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getHighligets() {
        return highligets;
    }

    public String getImages() {
        return images;
    }


    public String getIntroduction() {
        return introduction;
    }



    public Long getJobCategoryCid() {
        return jobCategoryCid;
    }

    public Long getJobCategoryPid() {
        return jobCategoryPid;
    }

    public Long getJobId() {
        return jobId;
    }

    public String getJobName() {
        return jobName;
    }


    public Long getMaxApplyCount() {
        return maxApplyCount;
    }
    public Long getMinApplyCount() {
        return minApplyCount;
    }

    public Date getModifyTime() {
        return modifyTime;
    }
    public String getProviceName() {
        return proviceName;
    }

    public Long getProvinceId() {
        return provinceId;
    }
    public Date getPushTime() {
        return pushTime;
    }

    public Long getRecruitNumber() {
        return recruitNumber;
    }
    public String getRequirements() {
        return requirements;
    }

    public String getSalaryDesc() {
        return salaryDesc;
    }
    public Long getSalaryMax() {
        return salaryMax;
    }

    public Long getSalaryMin() {
        return salaryMin;
    }
    public Long getStatus() {
        return status;
    }

    public Long getTshApplyNumber() {
        return tshApplyNumber;
    }
    public Long getTshStatus() {
        return tshStatus;
    }

    public Long getViewCount() {
        return viewCount;
    }
    public String getWorkContent() {
        return workContent;
    }

    public Long getZoneId() {
        return zoneId;
    }
    public String getZoneName() {
        return zoneName;
    }

    public void setAddress(String address) {
        this.address =address;
    }
    public void setApplyNumber(Long applyNumber) {
        this.applyNumber =applyNumber;
    }

    public void setApplyNumCount(Long applyNumCount) {
        this.applyNumCount = applyNumCount;
    }
    public void setBenefit(String benefit) {
        this.benefit =benefit;
    }

    public void setCityId(Long cityId) {
        this.cityId =cityId;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCode(String code) {
        this.code =code;
    }

    public void setCompId(Long compId) {
        this.compId =compId;
    }
    public void setCompName(String compName) {
        this.compName = compName;
    }

    public void setCreateTime(Date createTime) {
        this.createTime =createTime;
    }

    public void setCtNameOne(String ctNameOne) {
        this.ctNameOne = ctNameOne;
    }
    public void setCtNameTwo(String ctNameTwo) {
        this.ctNameTwo = ctNameTwo;
    }

    public void setDeadline(Date deadline) {
        this.deadline =deadline;
    }
    public void setDeadlineTime(String deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }
    public void setEntryAward(Double entryAward) {
        this.entryAward =entryAward;
    }

    public void setEnvironment(String environment) {
        this.environment =environment;
    }
    public void setHighligets(String highligets) {
        this.highligets =highligets;
    }

    public void setImages(String images) {
        this.images =images;
    }


    public void setIntroduction(String introduction) {
        this.introduction =introduction;
    }

    public void setJobCategoryCid(Long jobCategoryCid) {
        this.jobCategoryCid =jobCategoryCid;
    }

    public void setJobCategoryPid(Long jobCategoryPid) {
        this.jobCategoryPid =jobCategoryPid;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public void setJobName(String jobName) {
        this.jobName =jobName;
    }
    public void setMaxApplyCount(Long maxApplyCount) {
        this.maxApplyCount = maxApplyCount;
    }

    public void setMinApplyCount(Long minApplyCount) {
        this.minApplyCount = minApplyCount;
    }
    public void setModifyTime(Date modifyTime) {
        this.modifyTime =modifyTime;
    }

    public void setProviceName(String proviceName) {
        this.proviceName = proviceName;
    }
    public void setProvinceId(Long provinceId) {
        this.provinceId =provinceId;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }
    public void setRecruitNumber(Long recruitNumber) {
        this.recruitNumber =recruitNumber;
    }

    public void setRequirements(String requirements) {
        this.requirements =requirements;
    }
    public void setSalaryDesc(String salaryDesc) {
        this.salaryDesc =salaryDesc;
    }

    public void setSalaryMax(Long salaryMax) {
        this.salaryMax =salaryMax;
    }
    public void setSalaryMin(Long salaryMin) {
        this.salaryMin =salaryMin;
    }

    public void setStatus(Long status) {
        this.status =status;
    }
    public void setTshApplyNumber(Long tshApplyNumber) {
        this.tshApplyNumber = tshApplyNumber;
    }

    public void setTshStatus(Long tshStatus) {
        this.tshStatus = tshStatus;
    }
    public void setViewCount(Long viewCount) {
        this.viewCount =viewCount;
    }

    public void setWorkContent(String workContent) {
        this.workContent =workContent;
    }
    public void setZoneId(Long zoneId) {
        this.zoneId =zoneId;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

}
