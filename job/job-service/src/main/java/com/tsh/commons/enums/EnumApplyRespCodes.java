/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.commons.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 申请职位返回信息  枚举
 * 
 * @author zengzw
 * @date 2016年10月17日
 */
public enum EnumApplyRespCodes {
    M0001("成功"),
    
    E3001("已经报过名了."),
    
    E3002("没有可以进行该操作的用户。"),
    
    E3003("用户身份信息未完善。"),
    
    E3004("对非已入职状态的用户岗位进行返费。"),
    
    E3005("用户返费的金额和入职时的计算金额不相等。"),
    
    E3006("系统余额不足于入职奖金支出。"),
    
    E3007("已经不能取消报名。"),
    
    E3008("该岗位现在不可以报名。"),
    
    E3009("当前报名的工作已达上限。");

    
    public static String getMap(String key){
        Map<String, String> mapValue = new HashMap<>();
       for(EnumApplyRespCodes ea:EnumApplyRespCodes.values()){
           mapValue.put(ea.name(),ea.message);
       }
       
       return mapValue.get(key);
    }
    
    private String message;
    /**
     * 
     */
    private EnumApplyRespCodes(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
