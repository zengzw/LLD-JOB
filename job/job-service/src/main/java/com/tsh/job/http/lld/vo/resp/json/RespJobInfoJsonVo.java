/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.http.lld.vo.resp.json;

import java.util.List;

import com.tsh.job.http.lld.vo.HttpRespMessageVo;
import com.tsh.job.http.lld.vo.resp.ResJobInfoVO;

/**
 *
 * @author zengzw
 * @date 2016年9月26日
 */
public class RespJobInfoJsonVo extends HttpRespMessageVo{
    
    /**
     * 
     */
    private static final long serialVersionUID = -2694117019140939229L;
    
    private List<ResJobInfoVO> data;

    public List<ResJobInfoVO> getData() {
        return data;
    }

    public void setData(List<ResJobInfoVO> data) {
        this.data = data;
    }
}
