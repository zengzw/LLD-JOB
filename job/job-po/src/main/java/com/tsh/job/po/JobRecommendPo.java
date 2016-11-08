package com.tsh.job.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "job_recommend")
public class JobRecommendPo implements Serializable{

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
    /**  城市名称*/
    private Long cityId;
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id =id;
    }
    @Column(name = "job_info_id")
    public Long getJobInfoId() {
        return jobInfoId;
    }

    public void setJobInfoId(Long jobInfoId) {
        this.jobInfoId =jobInfoId;
    }
    @Column(name = "country")
    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country =country;
    }
    @Column(name = "province_id")
    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId =provinceId;
    }
    @Column(name = "province_name")
    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName =provinceName;
    }
    @Column(name = "city_id")
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId =cityId;
    }
    @Column(name = "city_name")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName =cityName;
    }
    @Column(name = "status")
    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status =status;
    }
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime =createTime;
    }
    @Column(name = "create_id")
    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId =createId;
    }
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type =type;
    }
}
