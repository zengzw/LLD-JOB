package com.tsh.job.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "job_info")
public class JobInfoPo implements Serializable{
    
    public JobInfoPo(){};
    
    public JobInfoPo(Long provinceId,Long cityId,Long districtId,Long categoryPid,Long categoryCid){
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.zoneId = districtId;
        this.jobCategoryCid = categoryCid;
        this.jobCategoryPid = categoryPid;
    }

    private static final long serialVersionUID = 1L;

    /**  工作地点*/
    private String address;
    /**  已申请人数*/
    private Long applyNumber;
    /**
     * 总申请人数
     */
    private Long applyNumCount;
    /**  城市ID*/
    private Long cityId;
    /**  招工编码*/
    private String code;
    private CompanyPo companyPo;
    /**  企业Id*/
    private Long compId;
    /**  发布时间*/
    private Date createTime;
    /**  报名截止日期*/
    private Date deadline;
    /**  企业亮点*/
    private String highligets;
    /**  job id*/
    private Long id;
    /**  工作类型 子ID*/
    private Long jobCategoryCid;
    /**  工作类型父ID*/
    private Long jobCategoryPid;
    /**  第三方JobId*/
    private Long jobId;
    /**  职位名称*/
    private String jobName;
    /**  最后更新时间*/
    private Date modifyTime;
    /**  省份ID*/
    private Long provinceId;
    
    private Date pushTime;

    /**  招聘人数*/
    private  Long recruitNumber;


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
        6：已删除
     */
    private Long status;

    /**自己内部已申请人数*/
    private Long tshApplyNumber;

    /**
     * 下架时间
     */
    private Date downTime;
    
    @Column(name="down_time")
    public Date getDownTime() {
        return downTime;
    }

    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }

    /**
     * 上下架状态
     */
    private Long tshStatus;
    /**  关注度（查看数）*/
    private Long viewCount;
    /**  地区ID*/
    private Long zoneId;
    @Column(name = "address")
    public String getAddress() {
        return address;
    }
    
    @Column(name = "apply_number")
    public Long getApplyNumber() {
        return applyNumber;
    }

    @Column(name="apply_num_count")
    public Long getApplyNumCount() {
        return applyNumCount;
    }

    @Column(name = "city_id")
    public Long getCityId() {
        return cityId;
    }

    @Column(name = "code")
    public String getCode() {
        return code;
    }

    @ManyToOne(optional=false)
    @JoinColumn(name="comp_id",insertable=false,updatable=false)
    public CompanyPo getCompanyPo() {
        return companyPo;
    }
    @Column(name = "comp_id")
    public Long getCompId() {
        return compId;
    }

    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }
    @Column(name = "deadline")
    public Date getDeadline() {
        return deadline;
    }

    @Column(name = "highligets")
    public String getHighligets() {
        return highligets;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "job_category_cid")
    public Long getJobCategoryCid() {
        return jobCategoryCid;
    }
    @Column(name = "job_category_pid")
    public Long getJobCategoryPid() {
        return jobCategoryPid;
    }

    @Column(name = "job_id")
    public Long getJobId() {
        return jobId;
    }
    @Column(name = "job_name")
    public String getJobName() {
        return jobName;
    }

    @Column(name = "modify_time")
    public Date getModifyTime() {
        return modifyTime;
    }
    @Column(name = "province_id")
    public Long getProvinceId() {
        return provinceId;
    }

    @Column(name="push_time")
    public Date getPushTime() {
        return pushTime;
    }
    @Column(name = "recruit_number")
    public Long getRecruitNumber() {
        return recruitNumber;
    }

    @Column(name = "salary_max")
    public Long getSalaryMax() {
        return salaryMax;
    }
    @Column(name = "salary_min")
    public Long getSalaryMin() {
        return salaryMin;
    }

    @Column(name = "status")
    public Long getStatus() {
        return status;
    }
    @Column(name="tsh_apply_number")
    public Long getTshApplyNumber() {
        return tshApplyNumber;
    }

    @Column(name="tsh_status")
    public Long getTshStatus() {
        return tshStatus;
    }
    @Column(name = "view_count")
    public Long getViewCount() {
        return viewCount;
    }

    @Column(name = "zone_id")
    public Long getZoneId() {
        return zoneId;
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
    public void setCode(String code) {
        this.code =code;
    }

    public void setCompanyPo(CompanyPo companyPo) {
        this.companyPo = companyPo;
    }
    public void setCompId(Long compId) {
        this.compId =compId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime =createTime;
    }
    public void setDeadline(Date deadline) {
        this.deadline =deadline;
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

    public void setJobId(Long jobId) {
        this.jobId =jobId;
    }
    public void setJobName(String jobName) {
        this.jobName =jobName;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime =modifyTime;
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
}
