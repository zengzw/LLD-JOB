/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Result;
import com.dtds.platform.util.security.UserInfo;
import com.tsh.job.po.JobRecommendPo;
import com.tsh.job.vo.RecommendQueryVo;

/**
 *
 * @author zengzw
 * @date 2016年10月17日
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:/applicationContext-service.xml"})
public class RecommendTest {

    @Autowired
    private JobRecommendService service;
    
 /*   @Test
    public void testRecommend(){
        Result result = new Result();
        UserInfo userInfo = new UserInfo();
        
        service.queryByArea(result, userInfo);
        
        List<JobRecommendPo> list = result.getData();
        for(JobRecommendPo p:list){
           System.out.println(JSON.toJSONString(p));
        }
        
        System.out.println(JSON.toJSONString(result.getData()));
    }*/
    
    
    @Test
    public void testList(){
        Result result = new Result();
        Page page = new Page<>();
        page.setPageSize(20);
        RecommendQueryVo q = new RecommendQueryVo();
        q.setJCity(320400L);
        
        service.queryListRecommendInfo(result, page, q);
        
        System.out.println(JSON.toJSONString(result.getData()));
    }
}
