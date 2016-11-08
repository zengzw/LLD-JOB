package com.tsh.job.vo;

import java.io.Serializable;
import java.util.Date;



public class JobInfoVo implements Serializable{
    private static final long serialVersionUID = 1L;

    /**  工作地点*/
    private String address;
    /** 第三方 已申请人数*/
    private Long applyNumber;

    /**
     * 总申请人数
     */
    private Long applyNumCount;

    /**  城市ID*/
    private Long cityId;

    private String cityName;

    /**  招工编码*/
    private String code;
    
    private CompanyVo companyVo = new CompanyVo();

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

    /**
     * 下架时间
     */
    private Date downTime;

    /**  企业亮点*/
    private String highligets;

    /**  job id*/
    private Long id;

    /**  工作类型 子ID*/
    private Long jobCategoryCid;

    /**  工作类型父ID*/
    private Long jobCategoryPid;

    private JobDetailVo jobDetailVo;

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

    /**  地区ID*/
    private Long zoneId;
    private String zoneName;

    
    /**
     * 职位ID
     */
    private Long[] categoryCIds;
    
    
    public Long[] getCategoryCIds() {
        return categoryCIds;
    }

    public void setCategoryCIds(Long[] categoryCIds) {
        this.categoryCIds = categoryCIds;
    }

    public String getAddress() {
        return address;
    }

    public Long getApplyNumber() {
        return applyNumber;
    }

    public Long getApplyNumCount() {
        return applyNumCount;
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

    public CompanyVo getCompanyVo() {
        return companyVo;
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

    public Date getDownTime() {
        return downTime;
    }

    public String getHighligets() {
        return highligets;
    }

    public Long getId() {
        return id;
    }

    public Long getJobCategoryCid() {
        return jobCategoryCid;
    }

    public Long getJobCategoryPid() {
        return jobCategoryPid;
    }

    public JobDetailVo getJobDetailVo() {
        return jobDetailVo;
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

    public void setCityId(Long cityId) {
        this.cityId =cityId;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCode(String code) {
        this.code =code;
    }
    public void setCompanyVo(CompanyVo companyVo) {
        this.companyVo = companyVo;
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

    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }
    public void setHighligets(String highligets) {
        this.highligets =highligets;
    }

    public void setId(Long id) {
        this.id =id;
    }
    public void setJobCategoryCid(Long jobCategoryCid) {
        this.jobCategoryCid =jobCategoryCid;
    }

    public void setJobCategoryPid(Long jobCategoryPid) {
        this.jobCategoryPid =jobCategoryPid;
    }
    public void setJobDetailVo(JobDetailVo jobDetailVo) {
        this.jobDetailVo = jobDetailVo;
    }

    public void setJobId(Long jobId) {
        this.jobId =jobId;
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
    public void setZoneId(Long zoneId) {
        this.zoneId =zoneId;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }
}
