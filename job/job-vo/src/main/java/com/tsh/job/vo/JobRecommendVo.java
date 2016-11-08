package com.tsh.job.vo;

import java.io.Serializable;
import java.util.Date;


public class JobRecommendVo implements Serializable{
    private static final long serialVersionUID = 1L;

    /**  注解ID*/
    private Long id;
    /**  职位ID*/
    private Long jobInfoId;

    /**  推荐区域。全国*/
    private Long country;

    /**  身份ID*/
    private Long provinceId;

    /**  省份名称*/
    private String provinceName;

    /**  城市ID*/
    private Long cityId;

    /**  城市名称*/
    private String cityName;

    /**  状态：0：未推荐，1：取消推荐*/
    private Long status;

    /**  创建时间*/
    private Date createTime;

    /**  创建人ID*/
    private Long createId;

    /**  推荐的级别。
0:城市，1：省，2：全国*/
    private String type;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id =id;
    }
    public Long getJobInfoId() {
        return jobInfoId;
    }

    public void setJobInfoId(Long jobInfoId) {
        this.jobInfoId =jobInfoId;
    }
    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country =country;
    }
    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId =provinceId;
    }
    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName =provinceName;
    }
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId =cityId;
    }
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName =cityName;
    }
    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status =status;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime =createTime;
    }
    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId =createId;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type =type;
    }
}
