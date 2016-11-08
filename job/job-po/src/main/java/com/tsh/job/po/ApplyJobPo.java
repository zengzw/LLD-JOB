package com.tsh.job.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "apply_job")
public class ApplyJobPo implements Serializable{

    private static final long serialVersionUID = 1L;

    /**  报名网点*/
    private String applyAddress;
    /**  报名时间*/
    private Date applyTime;
    /**  用户ID*/
    private Long applyUserId;

    /**  城市ID*/
    private Long cityId;
    /**  县域名称*/
    private String cityName;

    /**编码 **/
    private String code;

    /**  申请时间*/
    private Date createTime;
    /**  入职时间*/
    private Date entryTime;
    /**  */
    private Long id;
    /**  面试时间*/
    private Date interviewTime;
    /**  用户是否走完流程：0=否，1=是*/
    private Long isFinished;
    /**  职位ID*/
    private Long jobInfoId;
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
    /**  离职时间*/
    private Date leaveTime;
    /**  0：未推送，1:已推送*/
    private Long pushState;
    /**  推送时间*/
    private Date pushTime;
    /**  省份ID
     */
    private Long pvId;
    /**  省份名称*/
    private String pvName;
    /**  备注*/
    private String remark;
    /**  网点ID*/
    private Long shopId;
    /**  网点名称*/
    private String shopName;
    @Column(name = "apply_address")
    public String getApplyAddress() {
        return applyAddress;
    }
    @Column(name = "apply_time")
    public Date getApplyTime() {
        return applyTime;
    }

    @Column(name = "apply_user_id")
    public Long getApplyUserId() {
        return applyUserId;
    }

    @Column(name = "city_id")
    public Long getCityId() {
        return cityId;
    }
    @Column(name = "city_name")
    public String getCityName() {
        return cityName;
    }

    @Column(name="code")
    public String getCode() {
        return code;
    }
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    @Column(name = "entry_time")
    public Date getEntryTime() {
        return entryTime;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "interview_time")
    public Date getInterviewTime() {
        return interviewTime;
    }
    @Column(name = "is_finished")
    public Long getIsFinished() {
        return isFinished;
    }

    @Column(name = "job_info_id")
    public Long getJobInfoId() {
        return jobInfoId;
    }
    @Column(name = "job_status")
    public Long getJobStatus() {
        return jobStatus;
    }

    @Column(name = "leave_time")
    public Date getLeaveTime() {
        return leaveTime;
    }
    @Column(name = "push_state")
    public Long getPushState() {
        return pushState;
    }

    @Column(name = "push_time")
    public Date getPushTime() {
        return pushTime;
    }
    @Column(name = "pv_id")
    public Long getPvId() {
        return pvId;
    }

    @Column(name = "pv_name")
    public String getPvName() {
        return pvName;
    }
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    @Column(name = "shop_id")
    public Long getShopId() {
        return shopId;
    }
    @Column(name = "shop_name")
    public String getShopName() {
        return shopName;
    }

    public void setApplyAddress(String applyAddress) {
        this.applyAddress =applyAddress;
    }
    public void setApplyTime(Date applyTime) {
        this.applyTime =applyTime;
    }

    public void setApplyUserId(Long applyUserId) {
        this.applyUserId =applyUserId;
    }
    public void setCityId(Long cityId) {
        this.cityId =cityId;
    }

    public void setCityName(String cityName) {
        this.cityName =cityName;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public void setCreateTime(Date createTime) {
        this.createTime =createTime;
    }
    public void setEntryTime(Date entryTime) {
        this.entryTime =entryTime;
    }

    public void setId(Long id) {
        this.id =id;
    }
    public void setInterviewTime(Date interviewTime) {
        this.interviewTime =interviewTime;
    }

    public void setIsFinished(Long isFinished) {
        this.isFinished =isFinished;
    }
    public void setJobInfoId(Long jobInfoId) {
        this.jobInfoId =jobInfoId;
    }

    public void setJobStatus(Long jobStatus) {
        this.jobStatus =jobStatus;
    }
    public void setLeaveTime(Date leaveTime) {
        this.leaveTime =leaveTime;
    }

    public void setPushState(Long pushState) {
        this.pushState =pushState;
    }
    public void setPushTime(Date pushTime) {
        this.pushTime =pushTime;
    }

    public void setPvId(Long pvId) {
        this.pvId =pvId;
    }
    public void setPvName(String pvName) {
        this.pvName =pvName;
    }

    public void setRemark(String remark) {
        this.remark =remark;
    }
    public void setShopId(Long shopId) {
        this.shopId =shopId;
    }

    public void setShopName(String shopName) {
        this.shopName =shopName;
    }
}
