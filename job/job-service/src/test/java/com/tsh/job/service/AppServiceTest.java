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

import com.alibaba.fastjson.JSON;
import com.dtds.platform.util.bean.Page;
import com.dtds.platform.util.bean.Result;
import com.dtds.platform.util.security.UserInfo;
import com.tsh.dubbo.bis.api.AreaApi;
import com.tsh.dubbo.bis.vo.AreaInfoVO;
import com.tsh.dubbo.share.api.AddressApi;
import com.tsh.job.vo.ApplyUserVo;
import com.tsh.share.vo.AreaVo;


/**
 *
 * @author zengzw
 * @date 2016年10月13日
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:/applicationContext-service.xml"})
public class AppServiceTest {

    @Autowired
    APPApiService appService;
    
    @Autowired
    private AddressApi addressApi;
    
    @Autowired
    private AreaApi areaApi;
    
    @Test
    public void testListArea(){
        
        Result result = new Result();
        appService.queryListCity(result);
        System.out.println(JSON.toJSONString(result.getData()));
        
    }
    
    
    @Test
    public void testListCategoryAll(){
        Result result = new Result();
        appService.queryListCategory(result,442000L);
        System.out.println(JSON.toJSONString(result.getData()));
        
    }
    
    
    @Test
    public void testGetRealTime(){
        Result result = new Result();
        appService.getRealTimeApply(result);
        System.out.println(JSON.toJSONString(result.getData()));
        
    }
    
    @Test
    public void testQueryListUserApplyJob(){
        Result result = new Result();
        String mobilePhone = "15917169888";
        Page page = new Page<>(1, 20);
        appService.queryListUserApplyedJob(result, page, mobilePhone);
        System.out.println(JSON.toJSONString(result.getData()));
        
    }
    
    
    @Test
    public  void queryJobList(){
        Result result = new Result();
        String mobilePhone = "15917169888";
        Long cityId = 442000L;
        Long[] categoryIds = {1101L};
        Page page = new Page<>(1, 20);
        
        appService.queryJobList(result, page, cityId, categoryIds,null);
        System.out.println(JSON.toJSONString(result.getData()));
    }
    
    
    @Test
    public  void queryJobDetail(){
        Result result = new Result();
        Long jobId =145L;
        appService.queryJobDetail(result, jobId);
        System.out.println(JSON.toJSONString(result.getData()));
    }
    
    
    /**
     * 职位申请
     * @throws Exception 
     */
    @Test
    public void applyJob() throws Exception{
        Result result = new Result();
        ApplyUserVo applyUser = new ApplyUserVo();
        applyUser.setIdCard("4451211999922562");
        applyUser.setJobInfoId(146L);
        applyUser.setName("user1");
        applyUser.setSex(1L);
        applyUser.setPhone("15917169858");
        UserInfo userInfo  =new UserInfo();
        appService.userApplyJob(result, applyUser, userInfo);
        
        System.out.println(JSON.toJSONString(result.getData()));
    }
    
    
    
    /**
     * 查询热门推荐职位
     * 
     * @throws Exception
     */
    @Test
    public  void testHot() throws Exception{
        Result result = new Result();
        UserInfo userInfo = new UserInfo();
        userInfo.setBelongId(155L);
        result = appService.queryHotJob(result, userInfo);
        
        System.out.println(JSON.toJSONString(result.getData()));
    }
    
    @Test
    public void testArea() throws Exception{
        Result result = new Result();
        result =  areaApi.getAreaInfo(result, 148);
        AreaInfoVO areaInfoVO = result.getData();
        
        System.out.println(JSON.toJSONString(areaInfoVO));
        
        String name = areaInfoVO.getProvince()+"|"+areaInfoVO.getCity();//+"|"+areaInfoVO.getArea();
        System.out.println("---"+name);
        result = addressApi.getAddressByFullName(result, name);
        AreaVo areaVo = result.getData();
        System.out.println(JSON.toJSONString(areaVo));
    }
    
}
