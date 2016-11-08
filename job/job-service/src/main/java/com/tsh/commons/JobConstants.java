/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.commons;


/**
 *
 * @author zengzw
 * @date 2016年10月9日
 */
public class JobConstants {


    public interface ApplyStauts{
        int leave = -4; //已离职
        
        int join_error = -3;//:已入职
        
        int nullity = -2;//:面试失效
        
        int cancel = -1;//:取消报名
        
        int noimpact = 0;//：无关系
        
        int applyed = 1;//：已报名
        
        int interviewed = 2;//：已面试
        
        int join = 3;//：已面试
        
        int returnFree = 4;//：已完成返费
        
        int reward = 5;//：已完成奖励

        //============= extra status ===========
        
        int sync_error = 7; //报名异常
        
        int apply_error = 8; //报名截止
        
        
    }

    /**
     * 平台类型
     *
     * @author zengzw
     * @date 2016年8月30日
     */
    public interface RoleType{
        /** 平台 **/
        Integer PLATFORM = 2;

        /** 县域 **/
        Integer CITY = 3;

        /** 网点 **/
        Integer STORE = 4;

        /** 供应商 **/
        Integer SUPLIER = 5;

        /** 会员 **/
        Integer VIP = 9;
    }




    /**
     * 职位状态
     *
     * @author zengzw
     * @date 2016年10月9日
     */
    public interface JobStatus{

        /**
         * 上架
         */
        Long UP = 1l;

        /**
         * 下架
         */
        Long DOWN = 2L;

        /**
         * 为上架
         */
        Long INIT = 0L;
    }

    /**
     * 蓝领带 职位状态
     *
     * @author zengzw
     * @date 2016年10月9日
     */
    public interface LLDJobStatus{

        /** 未审核 **/
        int NOT_AUDIT = 0;

        /**审核中 **/
        int AUDITING = 1;

        /** 已审核 **/
        int AUDITED = 3;

        /** 招聘中 **/
        int RECRUITTING = 2;

        /** 暂停招聘  **/
        int STOP_RECRUIT = 4;

        /** 结束招聘 **/
        int CLOSE_RECRUIT = 5;

        /** 删除招聘 **/
        int DELETED = 6;
        
    }

    
    /**
     * 职位推送状态
     *
     * @author zengzw
     * @date 2016年10月15日
     */
    public  interface PushState{
        /**
         * 初始化，未推送
         */
        Long INIT = 0L;
        
        /**
         * 已推送
         */
        Long PUSHED =1L;
        
        /**
         * 推送失败
         */
        Long PUSHERROR = 2L;
    }
    
    public static String getStatusValue(int status){
        String msg = "";
        switch (status) {
        case JobConstants.ApplyStauts.applyed:
            msg =  "已报名";
         break;
        case JobConstants.ApplyStauts.cancel:
            msg =  "取消报名";
            break;
        case JobConstants.ApplyStauts.interviewed:
            msg =  "已面试";
            break;
        case JobConstants.ApplyStauts.join:
            msg =  "已入职";
            break;
        case JobConstants.ApplyStauts.leave:
            msg =  "已离职";
            break;
        case JobConstants.ApplyStauts.nullity:
            msg =  "面试失效";
            break;
        case JobConstants.ApplyStauts.returnFree:
            msg =  "已完成返费";
            break;
        case JobConstants.ApplyStauts.reward:
            msg =  "已完成奖励";
            break;
        case JobConstants.ApplyStauts.apply_error:
            msg = "报名截止";
            break;
        case JobConstants.ApplyStauts.sync_error:
            msg = "已报名";
            break;
            
        default:
            msg = "已报名";
            break;
        }
        
        return msg;
    }

}
