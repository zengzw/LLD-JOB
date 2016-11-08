/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.job.util;

import java.util.Date;

import com.dtds.platform.commons.utility.DateUtil;

/**
 *
 * @author zengzw
 * @date 2016年9月26日
 */
public class JobUtils {


    private final static String dateFormat = "yyyyMMddHHmmss";

    public final static String FORMAT_STRING = "yyyy-MM-dd";



    /**
     * 根据服务类型生产Code
     * 
     * @param type 服务类型
     * @return
     */
    public synchronized static String generateCode(String type){
        return type + DateUtil.date2String(new Date(), dateFormat) + createRandom(true, 4);
    }

    /**
     *  同城招工
     * 
     * @return
     */
    public synchronized static String getJobCode(){
        return generateCode("TCZG");
    }
    
    /**
     *  同城报名 
     * 
     * @return
     */
    public synchronized static String getApplyJobCode(){
        return generateCode("TCBM");
    }



    /**
     * 获取手机验证码
     * 
     * @param length 生成长度
     * @return String code
     */
    public synchronized static String generatePhoneCode(int length){
        return createRandom(true, length);
    }



    /** 
     * 创建指定数量的随机字符串 
     * @param numberFlag 是否是数字 
     * @param length 
     * @return 
     */  
    public static String createRandom(boolean numberFlag, int length){  
        String retStr = "";  
        String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";  
        int len = strTable.length();  
        boolean bDone = true;  
        do {  
            retStr = "";  
            int count = 0;  
            for (int i = 0; i < length; i++) {  
                double dblR = Math.random() * len;  
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR); 
                if (('0' <= c) && (c <= '9')) {  
                    count++;  
                }  
                retStr += strTable.charAt(intR);  
            }  

            if (count >= 2) {  
                bDone = false;  
            }

        } while (bDone);  

        return retStr;  
    }  


    
    /**
     * 获取前一天的开始时间
     * 
     * @return
     */
    public static Date getBeforeCurrenDate(){
        return getBeforeDate(new Date(), -1);
    }


    /**
     * 格式化成查询时间.一天开始时间 
     * 
     * @param time 格式化时间
     * @param daynum 增加天数
     * @return
     */
    public static Date getBeforeDate(Date time,int daynum){
        Date date = DateUtil.addDate(time, daynum);
        String timeStr =  DateUtil.date2String(date,FORMAT_STRING);
        timeStr += " 00:00:00";
        return DateUtil.str2Date(timeStr);
    }


    /**
     * 格式化成查询时间。 格式化成一天最后一秒种;2016-9-26 23:59:59
     * 
     * @param time 格式化时间
     * @param daynum 增加天数
     * @return
     */
    public static Date getEndDate(Date time,int daynum){
        Date date = DateUtil.addDate(time, daynum);
        String timeStr =  DateUtil.date2String(date,FORMAT_STRING);
        timeStr += " 23:59:59";
        return DateUtil.str2Date(timeStr);
    }

    /**
    * 格式化成查询时间
    * 
    * @param time 格式化时间
    * @param type 1:开始时间，2：结束时间
    * @return
    */
   public static Date parseSelectCondition(Date time,int type){
       if(time == null){
           return null;
       }

       if(type == 1){ //格式化开始时间
           String timeStr =  DateUtil.date2String(time,FORMAT_STRING);
           timeStr += " 00:00:00";
           return DateUtil.str2Date(timeStr);
       }else{ //格式化结束时间
           String timeStr =  DateUtil.date2String(time,FORMAT_STRING);
           timeStr += " 23:59:59";
           return DateUtil.str2Date(timeStr);
       }
   }


}
