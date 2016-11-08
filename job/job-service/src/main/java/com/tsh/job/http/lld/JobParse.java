/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.http.lld;

import java.util.Date;


import com.job.util.StringUtils;
import com.tsh.job.http.lld.vo.resp.ResJobInfoVO;
import com.tsh.job.http.lld.vo.resp.ResUserApplyVO;
import com.tsh.job.vo.ApplyJobVo;
import com.tsh.job.vo.ApplyUserVo;
import com.tsh.job.vo.CompanyVo;
import com.tsh.job.vo.JobDetailVo;
import com.tsh.job.vo.JobInfoVo;

/**
 *
 * @author zengzw
 * @date 2016年10月9日
 */
public class JobParse {


    /**
     * 格式话为jobVo 对象
     * 
     * @param job
     * @return
     */
    public static JobInfoVo parseJobInfoVO(ResJobInfoVO job){
        //职位
        JobInfoVo jobInfoVo = new JobInfoVo();
        jobInfoVo.setCompId(job.getCompanyId());
        jobInfoVo.setJobId(job.getId());
        jobInfoVo.setJobName(job.getJobName());
        jobInfoVo.setSalaryMin(Long.parseLong(job.getSalaryMin()+""));
        jobInfoVo.setSalaryMax(Long.parseLong(job.getSalaryMax()+""));
        jobInfoVo.setHighligets(StringUtils.arraysToString(job.getHighligetslist(),","));
        jobInfoVo.setRecruitNumber(Long.parseLong(job.getRecruitmentNumber()+""));
        jobInfoVo.setDeadline(new Date(job.getDeadline()));
        jobInfoVo.setProvinceId(Long.parseLong(job.getDistrictProvinceId()+""));
        jobInfoVo.setCityId(Long.parseLong(job.getDistrictCityId()+""));
        jobInfoVo.setZoneId(Long.parseLong(job.getDistrictZoneId()+""));
        jobInfoVo.setJobCategoryPid(Long.parseLong(job.getJobCategoryLevelOneId()+""));
        jobInfoVo.setJobCategoryCid(Long.parseLong(job.getJobCategoryLevelTwoId()+""));
        jobInfoVo.setStatus(Long.parseLong(job.getStatus()+""));
        jobInfoVo.setApplyNumber(Long.parseLong(job.getApplicantNumbe()+""));
        jobInfoVo.setCreateTime(new Date(job.getUpdateTime()));
        jobInfoVo.setAddress(job.getDistrictProvince() + job.getDistrictCity() + job.getDistrictZone());
        
        
        
        //企业对象
        CompanyVo companyVo = new CompanyVo();
        companyVo.setCompId(job.getCompanyId());
        companyVo.setName(job.getCompanyName());
      


        //职位详情
        JobDetailVo jobDetailVo = new JobDetailVo();
        jobDetailVo.setJobInfoId(job.getId());
        jobDetailVo.setEntryAward(job.getEntryAward());
        jobDetailVo.setSalaryDesc(job.getSalary());
        jobDetailVo.setWorkContent(job.getWorkContent());
        jobDetailVo.setEnvironment(job.getEnvironment());
        jobDetailVo.setRequirements(job.getRequirements());
        jobDetailVo.setBenefit(job.getBenefit());
        jobDetailVo.setIntroduction(job.getIntroduction());
        jobDetailVo.setImages(StringUtils.arraysToString(job.getImgList(),","));
        
        
        jobInfoVo.setCompanyVo(companyVo);
        jobInfoVo.setJobDetailVo(jobDetailVo);
        
        return jobInfoVo;
    }

    
    /**
     * 格式化用户报名数据
     * 
     * @param user
     * @return
     */
    public static ApplyUserVo parseApplyUser(ResUserApplyVO user){
        ApplyUserVo applyUserVo = new ApplyUserVo();
        applyUserVo.setJobInfoId(Long.parseLong(user.getJobId()+""));
        applyUserVo.setUserId(Long.parseLong(user.getTshUserId()+""));
        applyUserVo.setStatus(Long.parseLong(user.getStatus()+""));
        
        
        ApplyJobVo applyJobVo = new ApplyJobVo();
        applyJobVo.setApplyTime(new Date(user.getApplyTime()));
        applyJobVo.setInterviewTime(new Date(user.getInterviewTime()));
        applyJobVo.setEntryTime(new Date(user.getEntryTime()));
        applyJobVo.setLeaveTime(new Date(user.getLeaveTime()));
        applyJobVo.setIsFinished(user.getIsFinished());
        applyJobVo.setRemark(user.getRemark());
        
        applyUserVo.setApplyJobVo(applyJobVo);
        
        return applyUserVo;
        
    }
}