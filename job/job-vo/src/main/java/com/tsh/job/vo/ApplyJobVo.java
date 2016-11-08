package com.tsh.job.vo;

import java.io.Serializable;
import java.util.Date;


public class ApplyJobVo implements Serializable{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;
    /**  用户ID*/
    private Long applyUserId;

    /**  职位ID*/
    private Long jobInfoId;
    
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**  第三方平台，工作状态。
 -4:已离职
 -3:已入职
 -2:面试失效
 1-:取消报名
 0：无关系
 1：已报名
 2：已面试
 3：已入职
 4：已完成返费
 5：已完成奖励
     */
    private Long jobStatus;

    /**  报名网点*/
    private String applyAddress;

    /**  申请时间*/
    private Date createTime;

    /**  网点ID*/
    private Long shopId;

    /**  网点名称*/
    private String shopName;

    /**  城市ID*/
    private Long cityId;

    /**  县域名称*/
    private String cityName;

    /**  省份ID
     */
    private Long pvId;

    /**  省份名称*/
    private String pvName;

    /**  报名时间*/
    private Date applyTime;

    /**  面试时间*/
    private Date interviewTime;

    /**  入职时间*/
    private Date entryTime;

    /**  离职时间*/
    private Date leaveTime;

    /**  备注*/
    private String remark;

    /**  用户是否走完流程：0=否，1=是*/
    private Long isFinished;

    /**  0：未推送，1:已推送*/
    private Long pushState;

    /**  推送时间*/
    private Date pushTime;



    private JobInfoVo jobInfoVo;
    
    private ApplyUserVo applyUserVo;

    public JobInfoVo getJobInfoVo() {
        return jobInfoVo;
    }

    public void setJobInfoVo(JobInfoVo jobInfoVo) {
        this.jobInfoVo = jobInfoVo;
    }

    public ApplyUserVo getApplyUserVo() {
        return applyUserVo;
    }

    public void setApplyUserVo(ApplyUserVo applyUserVo) {
        this.applyUserVo = applyUserVo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id =id;
    }
    public Long getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Long applyUserId) {
        this.applyUserId =applyUserId;
    }
    public Long getJobInfoId() {
        return jobInfoId;
    }

    public void setJobInfoId(Long jobInfoId) {
        this.jobInfoId =jobInfoId;
    }
    public Long getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Long jobStatus) {
        this.jobStatus =jobStatus;
    }
    public String getApplyAddress() {
        return applyAddress;
    }

    public void setApplyAddress(String applyAddress) {
        this.applyAddress =applyAddress;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime =createTime;
    }
    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId =shopId;
    }
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName =shopName;
    }
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId =cityId;
    }
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName =cityName;
    }
    public Long getPvId() {
        return pvId;
    }

    public void setPvId(Long pvId) {
        this.pvId =pvId;
    }
    public String getPvName() {
        return pvName;
    }

    public void setPvName(String pvName) {
        this.pvName =pvName;
    }
    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime =applyTime;
    }
    public Date getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(Date interviewTime) {
        this.interviewTime =interviewTime;
    }
    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime =entryTime;
    }
    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime =leaveTime;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark =remark;
    }
    public Long getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Long isFinished) {
        this.isFinished =isFinished;
    }
    public Long getPushState() {
        return pushState;
    }

    public void setPushState(Long pushState) {
        this.pushState =pushState;
    }
    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime =pushTime;
    }
}
