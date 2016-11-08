/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.http.lld.vo.resp.json;

import java.util.List;

import com.tsh.job.http.lld.vo.HttpRespMessageVo;
import com.tsh.job.http.lld.vo.resp.ResUserApplyVO;

/**
 *
 * @author zengzw
 * @date 2016年9月26日
 */
public class RespUserApplyJsonVo extends HttpRespMessageVo{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private List<ResUserApplyVO> data;

    public List<ResUserApplyVO> getData() {
        return data;
    }

    public void setData(List<ResUserApplyVO> data) {
        this.data = data;
    }

}
