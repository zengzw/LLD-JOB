package com.tsh.job.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "commom_category")
public class CommomCategoryPo implements Serializable{

    private static final long serialVersionUID = 1L;

    /**  城市级别*/
    private  Long grade;
    /**  ID*/
    private String id;
    /**  名称*/
    private String name;
    /**  父ID*/
    private String pid;
    /**  排序*/
    private  Long sorting;

    @Column(name = "grade")
    public Long getGrade() {
        return grade;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public String getId() {
        return id;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "pid")
    public String getPid() {
        return pid;
    }
    @Column(name = "sorting")
    public Long getSorting() {
        return sorting;
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
