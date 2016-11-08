/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.http;

import com.tsh.job.http.lld.vo.HttpRespMessageVo;

/**
 *
 * @author zengzw
 * @date 2016年7月26日
 */
public class BaseRquest {

    /**
     * 获取错误对象
     * 
     * @param code
     * @param value
     * @return
     */
    public  HttpRespMessageVo getErrorMessage(String code,String msg){
        //根据Code 获取message
        HttpRespMessageVo resultMessage = new HttpRespMessageVo();
        resultMessage.setStatus(code);
        resultMessage.setMessage(msg);
        
        return resultMessage;
    }
    
    /**
     * 获取错误对象
     * 
     * @param code
     * @param value
     * @return
     */
    public  HttpRespMessageVo getSuccessMessage(String code,String msg,String value){
        //根据Code 获取message
        HttpRespMessageVo resultMessage = new HttpRespMessageVo();
        resultMessage.setStatus(code);
        resultMessage.setData(value);
        
        return resultMessage;
    }
    
  

    /**
     * 获取成功对象
     * 
     * @param value
     * @return
     */
    public  HttpRespMessageVo getSuccessMessage(String code,String msg){
        HttpRespMessageVo resultMessage = new HttpRespMessageVo();
        resultMessage.setStatus(code);
        resultMessage.setMessage(msg);
        return resultMessage;
    }
    
}
