package com.tsh.job.vo;

import java.io.Serializable;
import java.util.Date;


public class JobRecommendStatisticsVo implements Serializable{
    private static final long serialVersionUID = 1L;

    /**  主键ID*/
    private Long id;
    /**  身份/城市Code。
-1 是全国。 >1 是省或市*/
    private String code;

    /**  推荐职位数*/
    private Long recommendCount;

    /**  已下架数*/
    private Long downCount;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id =id;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code =code;
    }
    public Long getRecommendCount() {
        return recommendCount;
    }

    public void setRecommendCount(Long recommendCount) {
        this.recommendCount =recommendCount;
    }
    public Long getDownCount() {
        return downCount;
    }

    public void setDownCount(Long downCount) {
        this.downCount =downCount;
    }
}
