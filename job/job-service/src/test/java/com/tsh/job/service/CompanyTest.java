/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dtds.platform.data.redis.RedisSlave;
import com.dtds.platform.util.SerializeUtil;
import com.dtds.platform.util.bean.Result;
import com.tsh.job.vo.CompanyVo;

/**
 *
 * @author zengzw
 * @date 2016年10月9日
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:/applicationContext-service.xml"})
public class CompanyTest {
    
    @Autowired
    private CompanyService companyService;
    
    
    @Test
    public void testSave(){
        CompanyVo companyVo= new CompanyVo();
        companyVo.setCompId(111L);
        companyVo.setName("测试1");
        Result result = new Result();
        companyService.saveOrUpdateCompany(result, companyVo);
    }
    @Test
    public void testRedis(){
        List<String> list = new ArrayList<>();
        list.add("dd");
        list.add("cc");
        list.add("dd");
        list.add("ee");
        

        RedisSlave.getInstance().set("test".getBytes(),SerializeUtil.serialize(list), 0);
        
        byte[] result = RedisSlave.getInstance().get("test");
        
        List<String> resul = ( List<String>)SerializeUtil.unserialize(result);
        System.out.println(resul);
        
        
    }

}
