/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.timer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.dtds.platform.util.bean.Result;
import com.tsh.job.po.ApplyJobPo;
import com.tsh.job.po.ApplyUserPo;
import com.tsh.job.service.ApplyJobService;
import com.tsh.job.service.ApplyUserService;
import com.tsh.job.service.SyncJobService;

/**
 * 同步推送用户报名数据.每一分钟推送一次
 * 
 * @author zengzw
 * @date 2016年10月15日
 */
public class UserApplyJobErrorTimer {
    private static Logger logger = LoggerFactory.getLogger(JobInfoUpdateTimer.class);
    @Autowired
    private ApplyJobService jobService;
    @Autowired
    private ApplyUserService userService;
    @Autowired
    private SyncJobService syncJobService;


    public void start(){
        execute();
    }

    public void execute(){
        logger.info("--->SyncUserApplyJobTimer start........");

        Result result = new Result();
        List<ApplyJobPo> listJobPo = jobService.getNoPushListApplyJob(result).getData();
        if(!CollectionUtils.isEmpty(listJobPo)){
            logger.info("--->SyncUserApplyJobTimer 查询到：{}条........",listJobPo.size());

            for(ApplyJobPo job:listJobPo){
                ApplyUserPo userPo = userService.getApplyUserByUserId(result, job.getApplyUserId()).getData();
                syncJobService.reqApplyUserJob(userPo, job);
            }
        }else{
            logger.info("--->SyncUserApplyJobTimer 查询到：0条........");
        }

        logger.info("--->SyncUserApplyJobTimer end........");
    }
}
