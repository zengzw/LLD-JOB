/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dtds.platform.util.bean.Result;
import com.tsh.job.timer.JobInfoUpdateTimer;

/**
 *
 * 项目启动初始化数据
 * 
 * @author zengzw
 * @date 2016年10月10日
 */
@Controller
@RequestMapping("/job")
public class JobOperateController extends BaseController{

   @Autowired
    private JobInfoUpdateTimer jobInfoUpdate;
    
    
   /**
     * 保存招工接口对象
     * @param result
     * @param applyUser
     * @return
     */
     @RequestMapping(value = "/init")
     @ResponseBody
     public Result init()  {
         Result result = this.getResult();
         try {
             
             jobInfoUpdate.init();
             
         } catch (Exception e) {
             result = this.error(result, e);
         }
         
         return result;
     }
    
}
