/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.http.lld.vo.resp;

/**
 * 用户报名更新Vo
 * 
 * @author zengzw
 * @date 2016年9月26日
 */
public class ResUserApplyVO {


    private int id; // userjob关联表的ID
    
    private int tshUserId;// 用户ID
    
    private int jobId;// job的ID
    
    private int awardRateId ;// 关联奖金表的ID（暂时不用）
    /**
     * 用户状态 
     * -4 = ‘已离职’, 
     * -3 = ‘入职失败’,
     * -2 = ‘面试失败’, 
     * -1 = ‘取消报名’,
     * 0 = ‘无关系’（手机用）, 
     * 1 = ‘已报名’, 
     * 2 = ‘已面试’, 
     * 3 = ‘已入职’, 
     * 4 = ‘已完成返费’
     */
    private int  status;
    
    private long applyTime;//报名时间（时间戳）
    
    private long  interviewTime;//  面试时间（时间戳）
    
    private long  entryTime;// 入职时间（时间戳）
    
    private long  leaveTime;//离职时间（时间戳）
    
    private long  faileTime; //  失败时间（时间戳）
    
    private long  faileReason;//  失败原因 （时间戳）
    
    private long  isFinished; // 用户是否走完流程：0=否，1=是
    
    private String  remark;  //  备注
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getTshUserId() {
        return tshUserId;
    }
    public void setTshUserId(int tshUserId) {
        this.tshUserId = tshUserId;
    }
    public int getJobId() {
        return jobId;
    }
    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
    public int getAwardRateId() {
        return awardRateId;
    }
    public void setAwardRateId(int awardRateId) {
        this.awardRateId = awardRateId;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public long getApplyTime() {
        return applyTime;
    }
    public void setApplyTime(long applyTime) {
        this.applyTime = applyTime;
    }
    public long getInterviewTime() {
        return interviewTime;
    }
    public void setInterviewTime(long interviewTime) {
        this.interviewTime = interviewTime;
    }
    public long getEntryTime() {
        return entryTime;
    }
    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }
    public long getLeaveTime() {
        return leaveTime;
    }
    public void setLeaveTime(long leaveTime) {
        this.leaveTime = leaveTime;
    }
    public long getFaileTime() {
        return faileTime;
    }
    public void setFaileTime(long faileTime) {
        this.faileTime = faileTime;
    }
    public long getFaileReason() {
        return faileReason;
    }
    public void setFaileReason(long faileReason) {
        this.faileReason = faileReason;
    }
    public long getIsFinished() {
        return isFinished;
    }
    public void setIsFinished(long isFinished) {
        this.isFinished = isFinished;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    
    
}
