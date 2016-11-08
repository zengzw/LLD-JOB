package com.tsh.job.vo;

import java.io.Serializable;
import java.util.Date;


public class ApplyUserVo implements Serializable{
    private static final long serialVersionUID = 1L;

    /**  注解*/
    private Long id;
    /**  职位ID*/
    private Long jobInfoId;

    /**  第三方用户Id*/
    private Long userId;

    /**  性别。0：女生，1：男生*/
    private Long  sex;
    
    private Long gender;
    
    /**  姓名*/
    private String name;

    /**  手机号码*/
    private String phone;

    /**  身份证*/
    private String idCard;

    /**  审核状态。0：未审核。1：已审核。系统内部工作状态。*/
    private Long status;

    private ApplyJobVo applyJobVo;

    public ApplyJobVo getApplyJobVo() {
        return applyJobVo;
    }

    
    public Long getGender() {
        return sex;
    }

    public Long getId() {
        return id;
    }

    public String getIdCard() {
        return idCard;
    }



    public Long getJobInfoId() {
        return jobInfoId;
    }

    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }

    public Long getSex() {
        return sex;
    }
    public Long getStatus() {
        return status;
    }

    public Long getUserId() {
        return userId;
    }
    public void setApplyJobVo(ApplyJobVo applyJobVo) {
        this.applyJobVo = applyJobVo;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }
    public void setId(Long id) {
        this.id =id;
    }

    public void setIdCard(String idCard) {
        this.idCard =idCard;
    }
    public void setJobInfoId(Long jobInfoId) {
        this.jobInfoId =jobInfoId;
    }

    public void setName(String name) {
        this.name =name;
    }
    public void setPhone(String phone) {
        this.phone =phone;
    }

    public void setSex(Long sex) {
        this.sex =sex;
    }
    public void setStatus(Long status) {
        this.status =status;
    }

    public void setUserId(Long userId) {
        this.userId =userId;
    }
}
