package com.tsh.job.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class CommomCategoryVo implements Serializable{
    private static final long serialVersionUID = 1L;

    private List<CommomCategoryVo> cjob;
    /**  城市级别*/
    private Long grade;

    /**  ID*/
    private String id;

    /**  名称*/
    private String name;

    /**  父ID*/
    private String pid;


    /**  排序*/
    private Long  sorting;

    public List<CommomCategoryVo> getCjob() {
        return cjob;
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
    public void setCjob(List<CommomCategoryVo> cjob) {
        this.cjob = cjob;
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
