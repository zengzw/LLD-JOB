/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.http.lld.vo;

import java.io.Serializable;

/**
 * 返回结果对象
 * 
 * @author zengzw
 * @date 2016年8月31日
 */
public class HttpRespMessageVo implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 3822643331455463393L;

    /**
     * 状态吗
     */
    private String code;

    /**
     * 数据对象
     */
    private Object data;
    /**
     * 消息
     */
    private String message;

    /**
     * 消息
     */
    private String msg;


    /**
     * 状态。200：失败，500：成功
     */
    private String status;

    public String getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }


    public String getMessage() {
        return message;
    }


    public String getMsg() {
        return msg;
    }

    public String getStatus() {
        return status;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
