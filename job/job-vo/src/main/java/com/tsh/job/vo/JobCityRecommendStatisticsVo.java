package com.tsh.job.vo;

import java.io.Serializable;
import java.util.Date;


public class JobCityRecommendStatisticsVo implements Serializable{
    private static final long serialVersionUID = 1L;

    /**  主键ID*/
    private Long id;
    /**  推荐职位数*/
    private Long recommendCount;

    /**  省份ID*/
    private String proviceId;

    /**  省份名称*/
    private String proviceName;

    /**  城市ID*/
    private String cityId;

    /**  城市名称*/
    private String cityName;

    /**  类型。0：城市，1：省份*/
    private Long type;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id =id;
    }
    public Long getRecommendCount() {
        return recommendCount;
    }

    public void setRecommendCount(Long recommendCount) {
        this.recommendCount =recommendCount;
    }
    public String getProviceId() {
        return proviceId;
    }

    public void setProviceId(String proviceId) {
        this.proviceId =proviceId;
    }
    public String getProviceName() {
        return proviceName;
    }

    public void setProviceName(String proviceName) {
        this.proviceName =proviceName;
    }
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId =cityId;
    }
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName =cityName;
    }
    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type =type;
    }
}
