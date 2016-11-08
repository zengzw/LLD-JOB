package com.tsh.job.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;


@Entity
@Table(name = "company")
public class CompanyPo implements Serializable{

    private static final long serialVersionUID = 1L;

    /**  企业名称*/
    private String name;
    /**  第三方企业ID*/
    private Long compId;
    
  /*  @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")*/
  
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name =name;
    }
    @Id
    @Column(name = "comp_id")
    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId =compId;
    }
}
