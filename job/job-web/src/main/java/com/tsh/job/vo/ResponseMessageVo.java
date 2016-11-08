/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.vo;

import java.io.Serializable;

/**
 * 返回结果对象
 * 
 * @author zengzw
 * @date 2016年8月31日
 */
public class ResponseMessageVo implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 3822643331455463393L;

    /**
     * 状态。0：失败，1：成功
     */
    private String status;

    /**
     * 消息
     */
    private String msg;

    /**
     * 数据对象
     */
    private Object data;
    

    public Object getData() {
        return data;
    }


    public String getStatus() {
        return status;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
