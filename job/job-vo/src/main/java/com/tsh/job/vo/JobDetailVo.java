package com.tsh.job.vo;

import java.io.Serializable;
import java.util.Date;


public class JobDetailVo implements Serializable{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;
    /**  job Id(内部自增Id）*/
    private Long jobInfoId;

    /**  入职奖励*/
    private Double entryAward;

    /**  工资详情*/
    private String salaryDesc;

    /**  工作内容*/
    private String workContent;

    /**  工作环境*/
    private String environment;

    /**  工作需求*/
    private String requirements;

    /**  待遇需求*/
    private String benefit;

    /**  企业介绍*/
    private String introduction;

    /**  企业图片.以；隔开*/
    private String images;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id =id;
    }
    public Long getJobInfoId() {
        return jobInfoId;
    }

    public void setJobInfoId(Long jobInfoId) {
        this.jobInfoId =jobInfoId;
    }
    public Double getEntryAward() {
        return entryAward;
    }

    public void setEntryAward(Double entryAward) {
        this.entryAward =entryAward;
    }
    public String getSalaryDesc() {
        return salaryDesc;
    }

    public void setSalaryDesc(String salaryDesc) {
        this.salaryDesc =salaryDesc;
    }
    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent =workContent;
    }
    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment =environment;
    }
    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements =requirements;
    }
    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit =benefit;
    }
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction =introduction;
    }
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images =images;
    }
}
