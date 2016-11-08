package com.tsh.job.vo;

import java.io.Serializable;


public class CompanyVo implements Serializable{
    private static final long serialVersionUID = 1L;

    /**  主键ID*/
    private Long id;
    /**  企业名称*/
    private String name;

    /**  第三方企业ID*/
    private Long compId;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id =id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name =name;
    }
    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId =compId;
    }
}
