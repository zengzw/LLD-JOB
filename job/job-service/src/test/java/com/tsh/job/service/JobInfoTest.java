/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Result;
import com.tsh.job.vo.JobInfoVo;


/**
 *
 * @author zengzw
 * @date 2016年10月10日
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:/applicationContext-service.xml"})
public class JobInfoTest {
    
    @Autowired
    JobInfoService jobInfoService;
    
    @Test
    public void testSearch(){
        
        JobInfoVo jobInfoVo = new JobInfoVo();
//        jobInfoVo.setCompName("南宁统一企业有限公司（鑫贯线外包岗位）");
//        jobInfoVo.setJobName("中山纬创直招普工包车费");
        Result result = new Result();
       jobInfoService.queryJobInfoList(result, new Page<>(), jobInfoVo);
       
       System.out.println(com.alibaba.fastjson.JSON.toJSONString(result.getData()));
    }
    
    
    @Test
    public void test(){
        Result result = new Result();
        jobInfoService.test(result);
    }
}
