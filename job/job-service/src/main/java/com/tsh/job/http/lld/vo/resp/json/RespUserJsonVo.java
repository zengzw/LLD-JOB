/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.http.lld.vo.resp.json;

import com.tsh.job.http.lld.vo.HttpRespMessageVo;
import com.tsh.job.http.lld.vo.resp.RespUserVo;

/**
 *
 * @author zengzw
 * @date 2016年10月15日
 */
public class RespUserJsonVo extends HttpRespMessageVo {

    /**
     * 
     */
    private static final long serialVersionUID = -5358402520833424351L;
    
    private RespUserVo data;

    public RespUserVo getData() {
        return data;
    }

    public void setData(RespUserVo data) {
        this.data = data;
    }

}
