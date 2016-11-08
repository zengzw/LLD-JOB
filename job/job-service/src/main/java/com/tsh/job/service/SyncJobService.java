/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dtds.platform.util.bean.Result;
import com.job.util.StringUtils;
import com.tsh.commons.HttpConstants;
import com.tsh.commons.JobConstants;
import com.tsh.commons.enums.EnumApplyRespCodes;
import com.tsh.job.dao.ApplyJobLogDao;
import com.tsh.job.dao.ApplyUserDao;
import com.tsh.job.http.lld.HttpService;
import com.tsh.job.http.lld.vo.req.ReqUserApplyVo;
import com.tsh.job.http.lld.vo.resp.RespUserVo;
import com.tsh.job.http.lld.vo.resp.json.RespUserJsonVo;
import com.tsh.job.po.ApplyJobLogPo;
import com.tsh.job.po.ApplyJobPo;
import com.tsh.job.po.ApplyUserPo;

/** 
 *  
 * @author zengzw
 * @date 2016年10月17日
 */
@Service
public class SyncJobService {

    private static Logger LOGGER = LoggerFactory.getLogger(APPApiService.class);

    private HttpService httpService = new HttpService();
    
    @Autowired
    private ApplyJobLogDao applyJobLogDao;
    
    @Autowired
    private ApplyJobLogDao applyJobDao;
    
    @Autowired
    private ApplyUserDao applyUserDao;
    
    /**
     * 推送
     * @param userApplyPo
     * @param applyJobPo
     * @return
     */
    public void reqApplyUserJob(ApplyUserPo userApplyPo, ApplyJobPo applyJobPo) {
        ReqUserApplyVo reqUser = new ReqUserApplyVo();
        reqUser.setGender(Integer.parseInt(userApplyPo.getSex()+""));
        reqUser.setName(userApplyPo.getName());
        reqUser.setIdcard(userApplyPo.getIdCard());
        reqUser.setMobile(userApplyPo.getPhone());
        reqUser.setJobId(applyJobPo.getJobInfoId());
        

        addApplyJobLog(JSON.toJSONString(reqUser),applyJobPo.getJobInfoId(),0L);

        RespUserJsonVo userJsonVo =  httpService.userApply(reqUser);
        
        addApplyJobLog(JSON.toJSONString(userJsonVo),applyJobPo.getJobInfoId(),1L);
        
        
        if(userJsonVo.getStatus().equals(HttpConstants.RespStatus.SUCCESS)){
            RespUserVo user = userJsonVo.getData();
            //修改用户Id
            userApplyPo.setUserId(user.getId());
            applyUserDao.update(userApplyPo);

            //修改推送状态
            applyJobPo.setPushState(JobConstants.PushState.PUSHED);
            applyJobPo.setJobStatus(StringUtils.parseLong(JobConstants.ApplyStauts.applyed));
            applyJobPo.setPushTime(new Date());
            applyJobDao.update(applyJobPo);

        }else{
            //如果没有报名状态错误码，当做是接口异常，需要重试
            if(StringUtils.isEmpty(userJsonVo.getCode())){
                applyJobPo.setPushState(JobConstants.PushState.PUSHERROR);
                applyJobPo.setJobStatus(StringUtils.parseLong(JobConstants.ApplyStauts.sync_error));
            }else{
                LOGGER.info("---> jobId:{},code:{}",applyJobPo.getJobInfoId(),userJsonVo.getCode());
                
                //当状态码位“报名上限”，“停止报名”,我们的状态位截止。其他的状态位已报名
                if(userJsonVo.getCode().equals(EnumApplyRespCodes.E3008.name())
                        || userJsonVo.getCode().equals(EnumApplyRespCodes.E3009.name())){
                    applyJobPo.setPushState(JobConstants.PushState.PUSHED);
                    applyJobPo.setJobStatus(StringUtils.parseLong(JobConstants.ApplyStauts.apply_error));
                }

                applyJobPo.setRemark(userJsonVo.getMessage());
            }

            applyJobPo.setPushTime(new Date());
            applyJobDao.update(applyJobPo);
        }

    }

    

    /**
     * 添加日志
     * 
     * @param reqUser
     * @throws Exception
     */
    private void addApplyJobLog(String param, Long jobId,Long status){
        ApplyJobLogPo applyJobLog = new ApplyJobLogPo();
        applyJobLog.setAppJobId(jobId);
        applyJobLog.setCreateTime(new Date());
        applyJobLog.setParams(param);
        applyJobLog.setState(status);
        Result result = new Result();
        applyJobLogDao.addApplyJobLog(result, applyJobLog);
    }

}
