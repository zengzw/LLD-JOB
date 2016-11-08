/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.http.lld;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.job.util.HttpUtils;
import com.tsh.commons.HttpConstants;
import com.tsh.job.http.BaseRquest;
import com.tsh.job.http.lld.vo.req.ReqUserApplyVo;
import com.tsh.job.http.lld.vo.resp.json.RespJobInfoJsonVo;
import com.tsh.job.http.lld.vo.resp.json.RespUserApplyJsonVo;
import com.tsh.job.http.lld.vo.resp.json.RespUserJsonVo;

/**
 *
 * 蓝领带 HttpService 服务类
 * 
 * @author zengzw
 * @date 2016年9月26日
 */
public class HttpService extends BaseRquest{

    private static final Logger LOG  = LoggerFactory.getLogger(HttpService.class);


    /**
     * 用户报名
     * 
     * @param reqVo
     */
    public RespUserJsonVo userApply(ReqUserApplyVo reqVo){
        Map<String, Object> params = new LinkedHashMap<String,Object>();
        params.put("jobId", reqVo.getJobId());
        params.put("name", reqVo.getName());
        params.put("mobile", reqVo.getMobile());
        params.put("idcard", reqVo.getIdcard());
        params.put("network", reqVo.getNetwork());
        params.put("gender", reqVo.getGender()); 

        String result =  HttpUtils.doPost(HttpConstants.URL.USER_APPLY, params, HttpUtils.charset_utf8);
        LOG.info("----> result:" +result);

        RespUserJsonVo responseMessage = new RespUserJsonVo();
        if(StringUtils.isEmpty(result)){
            responseMessage.setStatus(HttpConstants.RespStatus.ERROR);
            responseMessage.setMessage("返回数据为空!");
            return responseMessage;
        }

        responseMessage = JSON.parseObject(result, RespUserJsonVo.class);
        return responseMessage;
    }



    /**
     * 更新用户报名状态
     * 参数可选
     * 
     * @param userId 报名用户Id
     * @param updateTime时间搓
     */
    public RespUserApplyJsonVo updateUserJob(Integer userId,Date updateTime){
        Map<String, Object> params = new LinkedHashMap<String,Object>();
        if(userId != null){
            params.put("userId", userId);
        }
        if(updateTime != null){
            params.put("updateTime",updateTime.getTime());
        }

        String result =  HttpUtils.doGet(HttpConstants.URL.USERJOB_UPDATE, params, HttpUtils.charset_utf8);
        LOG.info("----> result:" +result);

        RespUserApplyJsonVo responseMessage = new RespUserApplyJsonVo();
        if(StringUtils.isEmpty(result)){
            responseMessage.setStatus(HttpConstants.RespStatus.ERROR);
            responseMessage.setMessage("返回数据为空!");
            return responseMessage;
        }

        responseMessage = JSON.parseObject(result, RespUserApplyJsonVo.class);
        return responseMessage;
    }

    /**
     * 更新职位状态
     * 参数可选
     * 
     * @param userId 报名用户Id
     * @param updateTime时间搓
     */
    public RespJobInfoJsonVo updateJobInfo(Integer jobId,Date updateTime){
        Map<String, Object> params = new LinkedHashMap<String,Object>();
        if(jobId != null){
            params.put("jobId", jobId);
        }
        if(updateTime != null){
            params.put("updateTime",updateTime.getTime());
        }
        String result =  HttpUtils.doGet(HttpConstants.URL.JOB_UPDATE, params, HttpUtils.charset_utf8);
        LOG.info("----> result:" +result);

        RespJobInfoJsonVo responseMessage = new RespJobInfoJsonVo();
        if(StringUtils.isEmpty(result)){
            responseMessage.setCode(HttpConstants.RespStatus.ERROR);
            responseMessage.setMessage("返回数据为空");
            return responseMessage;
        }

        responseMessage = JSON.parseObject(result,RespJobInfoJsonVo.class);
        return responseMessage;
    }


}
