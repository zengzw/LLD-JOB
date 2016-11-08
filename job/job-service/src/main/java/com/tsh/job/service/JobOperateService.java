/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtds.platform.util.bean.Result;
import com.tsh.job.http.lld.JobParse;
import com.tsh.job.http.lld.vo.resp.ResJobInfoVO;
import com.tsh.job.http.lld.vo.resp.ResUserApplyVO;
import com.tsh.job.vo.ApplyUserVo;
import com.tsh.job.vo.CompanyVo;
import com.tsh.job.vo.JobDetailVo;
import com.tsh.job.vo.JobInfoVo;

/**
 * 职位过滤清洗服务
 * 
 * @author zengzw
 * @date 2016年10月9日
 */
@Service
public class JobOperateService {
    
   private Logger LOGGER = LoggerFactory.getLogger(JobOperateService.class);
    
    @Autowired
    private JobInfoService jobInfoService;
    
    @Autowired
    private CompanyService companyService;

    @Autowired
    private JobDetailService jobDetailService;
    
    @Autowired
    private ApplyJobService applyJobService;
    
    @Autowired
    private ApplyUserService applyUserService;
    
    /**
     * 更新职位
     * 
     * @param resJobInfoVO 职位信息对象
     */
    public void executeJob(ResJobInfoVO resJobInfoVO){
        
        Result result = new Result();
        JobInfoVo jobInfoVo = JobParse.parseJobInfoVO(resJobInfoVO);
        CompanyVo companyVo = jobInfoVo.getCompanyVo();
        JobDetailVo jobDetailVo = jobInfoVo.getJobDetailVo();
        
        try {
            jobInfoService.saveOrUpdateJobInfo(result, jobInfoVo);
            jobDetailService.saveorUpdateJobDetail(result, jobDetailVo);
            companyService.saveOrUpdateCompany(result, companyVo);
        } catch (Exception e) {
            LOGGER.error("新增job失败",e);
        }
    }
    
    
    
    
    /**
     * 职位更新
     * 
     * @param resUserApplyVO
     */
    public void executeApplyJob(ResUserApplyVO resUserApplyVO){
        ApplyUserVo applyUserVo = JobParse.parseApplyUser(resUserApplyVO);
        Result result = new Result();
        try {
            //修改用户的状态
            applyUserService.updateApplyUser(result, applyUserVo);
            
            applyJobService.updateApplyJob(result, applyUserVo.getApplyJobVo());
        } catch (Exception e) {
            LOGGER.error("更新用户报名出错 ",e);
        }
    }

}
