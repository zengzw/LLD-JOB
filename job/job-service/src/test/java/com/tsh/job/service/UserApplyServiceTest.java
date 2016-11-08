/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.dtds.platform.commons.utility.DateUtil;
import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Result;
import com.tsh.job.vo.ApplyJobQueryVo;

/**
 *
 * @author zengzw
 * @date 2016年10月13日
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:/applicationContext-service.xml"})
public class UserApplyServiceTest {

    @Autowired
    private ApplyUserService service;

    @Autowired
    private ApplyJobService applyjobService;

    @Test
    public void test() throws Exception{
        Result result = new Result();
        service.test(result);

        System.out.println(JSON.toJSONString(result.getData()));
    }


    @Test
    public void testApply(){
        Result result = new Result();
        Page page = new Page<>();
        ApplyJobQueryVo query = new ApplyJobQueryVo();
//        query.setCompName("富士康科技（成都）集团有限公司");
        query.setBeginCreateTime(new Date());
        query.setEndCreateTime(new Date());
        
        applyjobService.queryListApplyUserJob(result, page,query);
        System.out.println(JSON.toJSONString(result.getData()));
    }
    
    @Test
    public void testApplyJobDetail(){
        Result result = new Result();
        
        applyjobService.getApplyJobDetailByJobId(result, 5L, 1L);
        System.out.println(JSON.toJSONString(result.getData()));
    }
}

