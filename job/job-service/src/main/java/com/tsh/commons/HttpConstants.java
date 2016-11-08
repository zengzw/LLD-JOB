/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.commons;

import com.tsh.diamond.TshDiamondClient;

/**
 *
 * @author zengzw
 * @date 2016年9月26日
 */
public class HttpConstants {
    
    private static TshDiamondClient client = TshDiamondClient.getInstance();

    /**
     * 地址
     *
     * @author zengzw
     * @date 2016年9月26日
     */
    public interface URL{
        /**
         * 用户报名
         */
        String USER_APPLY = client.getConfig("nld_url")+"/tsh/job/apply.json";


        /**
         *  job 数据同步
         */
        String JOB_UPDATE = client.getConfig("nld_url")+"/tsh/job/update.json";


        /**
         * 用户报名数据同步
         */
        String USERJOB_UPDATE = client.getConfig("nld_url")+"/tsh/userJob.json";

    }


    /**
     * 返回状态
     *
     * @author zengzw
     * @date 2016年9月26日
     */
    public interface RespStatus{

        /**
         * 成功
         */
        String  SUCCESS = "200";

        /**
         * 失败
         */
        String ERROR = "500";
    }

    
}

