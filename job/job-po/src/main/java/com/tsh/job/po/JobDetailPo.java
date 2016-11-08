package com.tsh.job.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "job_detail")
public class JobDetailPo implements Serializable{

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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id =id;
    }
    @Column(name = "job_info_id")
    public Long getJobInfoId() {
        return jobInfoId;
    }

    public void setJobInfoId(Long jobInfoId) {
        this.jobInfoId =jobInfoId;
    }
    @Column(name = "entry_award")
    public Double getEntryAward() {
        return entryAward;
    }

    public void setEntryAward(Double entryAward) {
        this.entryAward =entryAward;
    }
    @Column(name = "salary_desc")
    public String getSalaryDesc() {
        return salaryDesc;
    }

    public void setSalaryDesc(String salaryDesc) {
        this.salaryDesc =salaryDesc;
    }
    @Column(name = "work_content")
    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent =workContent;
    }
    @Column(name = "environment")
    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment =environment;
    }
    @Column(name = "requirements")
    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements =requirements;
    }
    @Column(name = "benefit")
    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit =benefit;
    }
    @Column(name = "introduction")
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction =introduction;
    }
    @Column(name = "images")
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images =images;
    }
}
