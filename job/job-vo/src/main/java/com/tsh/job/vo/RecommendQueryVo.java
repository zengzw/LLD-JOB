/*
 * Copyright (c) 2013, FPX and/or its affiliates. All rights reserved.
 * Use, Copy is subject to authorized license.
 */
package com.tsh.job.vo;

/**
 *
 * @author zengzw
 * @date 2016年10月22日
 */
public class RecommendQueryVo {
    
    private Long RCountry;
   
    private Long RProvince;
    
    private Long RCity;
    
    private Long JProvince;
    
    private Long JCity;
    
    private Long CPid;
    
    private Long CCid;
    
    private String code;
    
    private String compName;
    
    private Long status;


    public Long getRCountry() {
        return RCountry;
    }

    public void setRCountry(Long rCountry) {
        RCountry = rCountry;
    }

    public Long getRProvince() {
        return RProvince;
    }

    public void setRProvince(Long rProvince) {
        RProvince = rProvince;
    }

    public Long getRCity() {
        return RCity;
    }

    public void setRCity(Long rCity) {
        RCity = rCity;
    }

    public Long getJProvince() {
        return JProvince;
    }

    public void setJProvince(Long jProvince) {
        JProvince = jProvince;
    }

    public Long getJCity() {
        return JCity;
    }

    public void setJCity(Long jCity) {
        JCity = jCity;
    }

    public Long getCPid() {
        return CPid;
    }

    public void setCPid(Long cPid) {
        CPid = cPid;
    }

    public Long getCCid() {
        return CCid;
    }

    public void setCCid(Long cCid) {
        CCid = cCid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
    
}
