package com.tsh.job.vo;

import java.io.Serializable;
import java.util.List;


public class CommomAreaVo implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * 城市
     */
    private List<CommomAreaVo> citys;
    /**
     * 地区
     */
    private List<CommomAreaVo> district;

    /**  城市级别*/
    private Long  grade;

    /**  ID*/
    private String id;

    /**  名称*/
    private String name;
    
    /**  父ID*/
    private String pid;
    
    
    /**  排序*/
    private Long  sorting;


    public List<CommomAreaVo> getCitys() {
        return citys;
    }

    public List<CommomAreaVo> getDistrict() {
        return district;
    }

    public Long getGrade() {
        return grade;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPid() {
        return pid;
    }
    public Long getSorting() {
        return sorting;
    }

    public void setCitys(List<CommomAreaVo> citys) {
        this.citys = citys;
    }
    public void setDistrict(List<CommomAreaVo> district) {
        this.district = district;
    }

    public void setGrade(Long grade) {
        this.grade =grade;
    }
    public void setId(String id) {
        this.id =id;
    }

    public void setName(String name) {
        this.name =name;
    }
    public void setPid(String pid) {
        this.pid =pid;
    }

    public void setSorting(Long sorting) {
        this.sorting =sorting;
    }
}
