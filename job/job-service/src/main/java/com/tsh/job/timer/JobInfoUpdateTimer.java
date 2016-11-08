/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.timer;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.dtds.platform.commons.utility.DateUtil;
import com.job.util.JobUtils;
import com.tsh.commons.HttpConstants;
import com.tsh.job.http.lld.HttpService;
import com.tsh.job.http.lld.vo.resp.ResJobInfoVO;
import com.tsh.job.http.lld.vo.resp.json.RespJobInfoJsonVo;
import com.tsh.job.service.JobOperateService;

/**
 * 
 * 每天晚上十二点定时去抓取更新昨天的数据数据
 *
 * @author zengzw
 * @date 2016年9月26日
 */
public class JobInfoUpdateTimer {

    private static Logger logger = LoggerFactory.getLogger(JobInfoUpdateTimer.class);

    private HttpService service = new HttpService();

    @Autowired
    private JobOperateService operateService;

    public void start(){
        //获取前一天的时间. 今天同步昨天的数据 
        Date date = JobUtils.getBeforeCurrenDate();
        logger.info("----> jobInfoUpdate time：{} 定时任务开始.......",DateUtil.date2String(date));

        execute(date);

        logger.info("----> jobInfoUpdate time 定时任务结束.......");
    }


    private void execute(Date date){
        RespJobInfoJsonVo resJob =  service.updateJobInfo(null,date);

        if(resJob.getStatus().equals(HttpConstants.RespStatus.SUCCESS)){
            List<ResJobInfoVO> lstJob =  resJob.getData();
            if(!CollectionUtils.isEmpty(lstJob)){
                for(ResJobInfoVO job:lstJob){
                    operateService.executeJob(job);
                }
            }else{
                logger.info("--> 获取职位为空 ");
            }
        }else{

            logger.info("--> 获取职位失败.obj:{}",resJob.getStatus());
        }
    }


    /**
     * 初始化
     */
    public void init(){
        execute(null);
    }
}
