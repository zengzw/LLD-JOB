/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.dtds.platform.util.bean.Result;
import com.tsh.job.dao.CommomAreaDao;
import com.tsh.job.dao.CommomCategoryDao;
import com.tsh.job.po.CommomAreaPo;
import com.tsh.job.po.CommomCategoryPo;
import com.tsh.job.po.JobInfoPo;
import com.tsh.job.vo.AppJobInfoVo;

/**
 *
 * 公用服务
 * 
 * @author zengzw
 * @date 2016年10月15日
 */
@org.springframework.stereotype.Service
public class PublishService {

    @Autowired
    private CommomAreaDao areaDao;

    @Autowired
    private CommomCategoryDao categoryDao;
    
    
    
    
    /**
     * @param jobResult
     * @param po
     * @param job
     */
    public void setAreaName(Result jobResult, JobInfoPo po, AppJobInfoVo job) {
        areaDao.getCommomAreaById(jobResult,po.getProvinceId()+"");
        CommomAreaPo commomAreaPo = jobResult.getData();
        job.setProviceName(commomAreaPo.getName());
        jobResult.setData(null);

        areaDao.getCommomAreaById(jobResult,po.getCityId()+"");
        commomAreaPo = jobResult.getData();
        job.setCityName(commomAreaPo.getName());
        jobResult.setData(null);

        areaDao.getCommomAreaById(jobResult,po.getZoneId()+"");
        commomAreaPo = jobResult.getData();
        job.setZoneName(commomAreaPo.getName());
        jobResult.setData(null);
    }



    /**
     * @param categoryResult
     * @param po
     * @param job
     */
    public void setCategory(Result categoryResult, JobInfoPo po, AppJobInfoVo job) {
        categoryDao.getCommomCategoryById(categoryResult,po.getJobCategoryPid()+"");
        CommomCategoryPo categoryPo = categoryResult.getData();
        job.setCtNameOne(categoryPo.getName());
        categoryResult.setData(null);

        categoryDao.getCommomCategoryById(categoryResult,po.getJobCategoryCid()+"");
        categoryPo = categoryResult.getData();
        job.setCtNameTwo(categoryPo.getName());
        categoryResult.setData(null);
    }

}
