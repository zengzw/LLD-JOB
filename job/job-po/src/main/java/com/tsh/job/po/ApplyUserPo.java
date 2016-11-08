package com.tsh.job.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "apply_user")
public class ApplyUserPo implements Serializable{

    private static final long serialVersionUID = 1L;

   
    /**  注解*/
    private Long id;
    /**  身份证*/
    private String idCard;
    /**  姓名*/
    private String name;
    /**  手机号码*/
    private String phone;
    /**  性别。0：女生，1：男生*/
    private Long sex;
    /**  审核状态。0：未审核。1：已审核。系统内部工作状态。*/
    private Long status;
    /**  第三方用户Id*/
    private Long userId;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "id_card")
    public String getIdCard() {
        return idCard;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }
    @Column(name = "sex")
    public Long  getSex() {
        return sex;
    }

    @Column(name = "status")
    public Long getStatus() {
        return status;
    }
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setId(Long id) {
        this.id =id;
    }

    public void setIdCard(String idCard) {
        this.idCard =idCard;
    }

    public void setName(String name) {
        this.name =name;
    }
    public void setPhone(String phone) {
        this.phone =phone;
    }

    public void setSex(Long sex) {
        this.sex =sex;
    }
    public void setStatus(Long status) {
        this.status =status;
    }

    public void setUserId(Long userId) {
        this.userId =userId;
    }
}
